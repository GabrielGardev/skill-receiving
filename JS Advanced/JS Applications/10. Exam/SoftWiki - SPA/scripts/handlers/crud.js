import { applyCommon } from './common.js';
import { createFormEntity } from '../form-helpers.js';
import { requester } from '../services/app-service.js';

export async function createHandler() {

    if(!sessionStorage.getItem('userId')){
        this.redirect('#/login')
        return;
    }
    /**
     * Load hbs templates
     */
    await applyCommon.call(this);
    await this.partial('./templates/create/createPage.hbs');

    /**
     * Handling form events part
     */
    let formRef = document.querySelector('form');
    formRef.addEventListener('submit', async e => {
        e.preventDefault();

        let form = createFormEntity(formRef, ['title', 'category', 'content']);
        let formValue = form.getValue();
        
        formValue.creator = sessionStorage.getItem('email');

        await requester.articles.createEntity(formValue);
        
        this.redirect('#/home')
    });
}

export async function editHandler() {
    /**
     * Load hbs templates
     */
    await applyCommon.call(this);
    await this.partial('./templates/edit/editPage.hbs');

    /**
     * Handling form events part
     */
    let formRef = document.querySelector('form');
    let form = createFormEntity(formRef, ['title', 'category', 'content']);

    /**
     * Load and set the initial form value for edit
     */
    const articleToEdit = await requester.articles.getById(this.params.id);
    form.setValue(articleToEdit);

    formRef.addEventListener('submit', async e => {
        e.preventDefault();
        let form = createFormEntity(formRef, ['title', 'category', 'content']);
        let formValue = form.getValue();

        await requester.articles.patchEntity(formValue, this.params.id);

        /** 
         * Navigates back to the catalog details
         */
        this.redirect(`#/home`);
    });
}

export async function deleteHandler() {
    await requester.articles.deleteEntity(this.params.id);

    this.redirect('#/home')
    return false
}
