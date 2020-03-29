import { createFormEntity } from './form-healper.js';
import { NO_VALUE } from './utils.js';
import { requester } from './services/app-service.js';

const apiKey = 'https://testapp-465f1.firebaseio.com/';
requester.init(apiKey, sessionStorage.getItem('token'));

async function applyCommon() {
    this.username = sessionStorage.getItem('username');
    this.loggedIn = !!sessionStorage.getItem('token');

    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    };

    if (sessionStorage.getItem('userId')) {
        this.hasNoTeam = await requester.userMeta
            .getById(sessionStorage.getItem('userId'))
            .then(res => {
                return !res || (res && res.team == NO_VALUE);
            });
    }
}

async function homeHandler() {
    await applyCommon.call(this);
    this.partial('./templates/home/home.hbs');
}

async function aboutHandler() {
    await applyCommon.call(this);
    this.partial('./templates/about/about.hbs');
}

async function loginHandler() {
    await applyCommon.call(this);
    this.partials.loginForm = await this.load('./templates/login/loginForm.hbs');

    await this.partial('./templates/login/loginPage.hbs');

    let formRef = document.querySelector('#login-form');
    formRef.addEventListener('submit', async e => {
        e.preventDefault();

        let form = createFormEntity(formRef, ['username', 'password']);
        let formValue = form.getValue();

        /**
         * Authenticates a user with email and password
         */
        const loggedInUser = await firebase.auth().signInWithEmailAndPassword(formValue.username, formValue.password);
        const userToken = await firebase.auth().currentUser.getIdToken();
        sessionStorage.setItem('username', loggedInUser.user.email);
        sessionStorage.setItem('userId', firebase.auth().currentUser.uid);

        /**
         * Updates the requester authentication token
         */
        sessionStorage.setItem('token', userToken);
        requester.setAuthToken(userToken);


        this.redirect(['#/home']);
    });
}

async function registerHandler() {
    await applyCommon.call(this);
    this.partials.registerForm = await this.load('./templates/register/registerForm.hbs');
    await this.partial('./templates/register/registerPage.hbs');

    let formRef = document.querySelector('#register-form');
    formRef.addEventListener('submit', async (e) => {
        e.preventDefault();
        let form = createFormEntity(formRef, ['username', 'password', 'repeatPassword']);
        let formValue = form.getValue();

        if (formValue.password !== formValue.repeatPassword) {
            throw new Error('Password and repeat password must match');
        }

        /**
         * Creates new user
         */
        const newUser = await firebase.auth().createUserWithEmailAndPassword(formValue.username, formValue.password);

        let userToken = await firebase.auth().currentUser.getIdToken();
        sessionStorage.setItem('username', newUser.user.email);
        sessionStorage.setItem('userId', firebase.auth().currentUser.uid);

        sessionStorage.setItem('token', userToken);
        /**
         * Updates the requester authentication token
         */
        requester.setAuthToken(userToken);

        /**
         * Creates a collection that hold the user's team, and the teams created by him 
         */
        await requester.userMeta.patchEntity({
            team: NO_VALUE,
            createdTeams: NO_VALUE
        }, sessionStorage.getItem('userId'));

        this.redirect(['#/home']);
    });

}

async function catalogHandler() {
    this.teams = Object.entries(await requester.teams.getAll()
        .then(x => x || {}))
        .map(([id, value]) => ({ _id: id, ...value }));

    await applyCommon.call(this);
    this.partials.team = await this.load('./templates/catalog/team.hbs');
    await this.partial('./templates/catalog/teamCatalog.hbs');
}

async function createHandler() {
    await applyCommon.call(this);
    this.partials.createForm = await this.load('./templates/create/createForm.hbs');

    await this.partial('./templates/create/createPage.hbs');

    let formRef = document.querySelector('#create-form');
    formRef.addEventListener('submit', async e => {
        e.preventDefault();

        let form = createFormEntity(formRef, ['name', 'comment']);
        let formValue = form.getValue();
        formValue.teamMembers = [{
            id: sessionStorage.getItem('userId'),
            name: sessionStorage.getItem('username')
        }];
        formValue.createdBy = sessionStorage.getItem('userId');

        let createdTeam = await requester.teams.createEntity(formValue);

        await requester.userMeta.patchEntity({
            createdTeams: createdTeam.name,
            team: createdTeam.name,
        }, sessionStorage.getItem('userId'));

        this.redirect('#/catalog');
    });
}

async function catalogueDetailsHandler() {
    this.teamId = this.params.id;
    let { name, comment, teamMembers, createdBy } = await requester.teams.getById(this.teamId);
    this.name = name;
    this.comment = comment;
    this.members = (teamMembers || []).map(member => ({ username: member.name }));
    this.isAuthor = createdBy === sessionStorage.getItem('userId');
    this.isOnTeam = (teamMembers || []).find(x => x.id === sessionStorage.getItem('userId'));


    await applyCommon.call(this);
    this.partials.teamMember = await this.load('./templates/catalog/teamMember.hbs');
    this.partials.teamControls = await this.load('./templates/catalog/teamControls.hbs');
    this.partial('./templates/catalog/details.hbs');
}

async function editTeamHandler() {
    await applyCommon.call(this);
    this.partials.editForm = await this.load('./templates/edit/editForm.hbs');
    await this.partial('./templates/edit/editPage.hbs');

    let formRef = document.querySelector('#edit-form');
    let form = createFormEntity(formRef, ['name', 'comment']);

    const teamToEdit = await requester.teams.getById(this.params.id);
    form.setValue(teamToEdit);

    formRef.addEventListener('submit', async e => {
        e.preventDefault();
        let form = createFormEntity(formRef, ['name', 'comment']);
        let formValue = form.getValue();

        await requester.teams.patchEntity(formValue, this.params.id);

        this.redirect(`#/catalog/${this.params.id}`);
    });
}

async function joinTeamHandler() {
    /**
     * Get data about the team the user wants to join
     * -- this.params comes from the url
     */
    let team = await requester.teams.getById(this.params.id);
    /** 
     * Updates the user meta data with the id of the team he/she joins 
     * Updates the teamsData with the id and the name of the user that is joining
     */
    await requester.userMeta.patchEntity({ team: this.params.id }, sessionStorage.getItem('userId'));
    await requester.teams.patchEntity(
        {
            teamMembers: [...(team.teamMembers || []),
            {
                name: sessionStorage.getItem('username'),
                id: sessionStorage.getItem('userId')
            }
            ]
        },
        this.params.id
    );

    this.redirect(`#/catalog/${this.params.id}`);
}

async function leaveTeamHandler() {
    /**
     * Get data about the team the user wants to leave
     * -- this.params comes from the url
     */
    let team = await requester.teams.getById(this.params.id);

    /** 
     * Updates the user meta data with the id of the team he/she leave 
     * Removes from teamsData the leaving user
     */
    await requester.userMeta.patchEntity({ team: NO_VALUE, createdTeams: NO_VALUE }, sessionStorage.getItem('userId'));
    await requester.teams.patchEntity(
        {
            teamMembers: [
                ...(team.teamMembers || [])
                    .filter(teamMember => teamMember.id !== sessionStorage.getItem('userId'))
            ]
        },
        this.params.id
    );
    /** 
     * Navigates back to the catalog details
     */
    this.redirect(`#/catalog/${this.params.id}`);
}

function logoutHandler() {
    sessionStorage.clear();
    firebase.auth().signOut();
    this.redirect(['#/home']);
}

// initialize the application
var app = Sammy('#main', function () {
    // include a plugin
    this.use('Handlebars', 'hbs');

    // define a 'route'
    this.get('#/', homeHandler);
    this.get('#/home', homeHandler);
    this.get('#/about', aboutHandler);
    this.get('#/login', loginHandler);
    this.post('#/login', () => false);
    this.get('#/register', registerHandler);
    this.post('#/register', () => false);
    this.get('#/logout', logoutHandler);
    this.get('#/catalog', catalogHandler);
    this.post('#/catalog', () => false);
    this.get('#/catalog/:id', catalogueDetailsHandler);
    this.post('#/catalog', false);
    this.get('#/edit/:id', editTeamHandler);
    this.post('#/edit/:id', () => false);
    this.get('#/join/:id', joinTeamHandler);
    this.get('#/leave/:id', leaveTeamHandler);
    this.get('#/create', createHandler);
    this.post('#/create', () => false);

});

// start the application
app.run('#/');