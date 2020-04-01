import { createFormEntity } from './../form-helpers.js';
import { applyCommon } from './common.js';
import { requester } from './../services/app-service.js';
import { triggerSuccessNotification, triggerFailNotification } from '../services/notification.js';

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

        let form = createFormEntity(formRef, ['username', 'password']);
        let formValue = form.getValue();

        /**
         * Authenticates a user with email and password
         */
        try {
            const loggedInUser = await firebase.auth().signInWithEmailAndPassword(formValue.username, formValue.password);
            const userToken = await firebase.auth().currentUser.getIdToken();
            sessionStorage.setItem('email', loggedInUser.user.email);
            sessionStorage.setItem('userId', firebase.auth().currentUser.uid);

            /**
             * Updates the requester authentication token
             */
            sessionStorage.setItem('token', userToken);
            requester.setAuthToken(userToken);

            triggerSuccessNotification('Logged in successfully!')
            this.redirect('#/home');
        } catch (ex) {
            triggerFailNotification(ex.message);
        }
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
        let form = createFormEntity(formRef, ['username', 'password', 'rePassword']);
        let formValue = form.getValue();

        if (!formValue.username || !formValue.password) {
            throw new Error('Username or password is empty!');
        }

        if (formValue.password !== formValue.rePassword) {
            throw new Error('Password and repeat password must match');
        }

        /**
         * Creates new user
         */
        try {
            const newUser = await firebase.auth().createUserWithEmailAndPassword(formValue.username, formValue.password);

            let userToken = await firebase.auth().currentUser.getIdToken();
            sessionStorage.setItem('email', newUser.user.email);
            sessionStorage.setItem('userId', firebase.auth().currentUser.uid);

            sessionStorage.setItem('token', userToken);
            /**
             * Updates the requester authentication token
             */
            requester.setAuthToken(userToken);

            triggerSuccessNotification('Registered successfully!')
            this.redirect('#/home');
        } catch (ex) {
            triggerFailNotification(ex.message);
        }
    });
}

/**
 * Signs out user
 */
export function logoutHandler() {
    sessionStorage.clear();
    firebase.auth().signOut();
    triggerSuccessNotification('Logged out successfully!')
    this.redirect('#/home');
}