import { createFormEntity } from './../form-helpers.js';
import { applyCommon } from './common.js';
import { requester } from './../services/app-service.js';

/**
 * Logs user
 */
export async function loginHandler() {

    await applyCommon.call(this);
    await this.partial('./templates/login/loginPage.hbs');

    /**
     * Handling form events part
     */
    let formRef = document.querySelector('form');
    formRef.addEventListener('submit', async e => {
        e.preventDefault();

        let form = createFormEntity(formRef, ['email', 'password']);
        let formValue = form.getValue();

        /**
         * Authenticates a user with email and password
         */
        const loggedInUser = await firebase.auth().signInWithEmailAndPassword(formValue.email, formValue.password);
        const userToken = await firebase.auth().currentUser.getIdToken();
        sessionStorage.setItem('email', loggedInUser.user.email);
        sessionStorage.setItem('userId', firebase.auth().currentUser.uid);

        /**
         * Updates the requester authentication token
         */
        sessionStorage.setItem('token', userToken);
        requester.setAuthToken(userToken);

        this.redirect('#/home');
    });
}

/**
 * Registers user
 */
export async function registerViewHandler() {

    await applyCommon.call(this);
    await this.partial('./templates/register/registerPage.hbs');


    let formRef = document.querySelector('form');
    formRef.addEventListener('submit', async (e) => {
        e.preventDefault();
        let form = createFormEntity(formRef, ['email', 'password', 'rep-pass']);
        let formValue = form.getValue();

        if (formValue.password !== formValue['rep-pass']) {
            throw new Error('Password and repeat password must match');
        }

        /**
         * Creates new user
         */
        const newUser = await firebase.auth().createUserWithEmailAndPassword(formValue.email, formValue.password);

        let userToken = await firebase.auth().currentUser.getIdToken();
        sessionStorage.setItem('email', newUser.user.email);
        sessionStorage.setItem('userId', firebase.auth().currentUser.uid);

        sessionStorage.setItem('token', userToken);

        /**
         * Updates the requester authentication token
         */
        requester.setAuthToken(userToken);

        this.redirect('#/home');
    });
}

/**
 * Signs out user
 */
export function logoutHandler() {
    sessionStorage.clear();
    firebase.auth().signOut();
    this.redirect('#/login');
}