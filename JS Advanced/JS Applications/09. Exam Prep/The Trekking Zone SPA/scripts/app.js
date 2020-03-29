import { requester } from './services/app-service.js';
import {
    homeViewHandler,
    loginHandler,
    registerViewHandler,
    logoutHandler,
    detailsHandler,
    editHandler,
    createHandler,
    likesHandler,
    deleteHandler,
    profileHandler
} from './handlers/index.js';

const apiKey = 'https://testapp-465f1.firebaseio.com/';
requester.init(apiKey, sessionStorage.getItem('token'));


const app = Sammy('#main', function () {
   
    this.use('Handlebars', 'hbs');

    this.get('#/', homeViewHandler);
    this.get('#/home', homeViewHandler);

    this.get('#/register', registerViewHandler);
    this.post('#/register', () => false);

    this.get('#/logout', logoutHandler);

    this.get('#/login', loginHandler);
    this.post('#/login', () => false);

    this.get('#/create', createHandler);
    this.post('#/create', () => false);

    this.get('#/details/:id', detailsHandler);

    this.get('#/likes/:currentLikes/:id', likesHandler);

    this.get('#/edit/:id', editHandler);
    this.post('#/edit/:id', () => false);
    
    this.get('#/delete/:id', deleteHandler); 

    this.get('#/profile/:id', profileHandler); 
});

app.run('#/');
