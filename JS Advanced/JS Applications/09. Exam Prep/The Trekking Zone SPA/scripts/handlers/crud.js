import { applyCommon } from './common.js';
import { createFormEntity } from '../form-helpers.js';
import { requester } from '../services/app-service.js';

export async function createHandler() {
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

        let form = createFormEntity(formRef, ['location', 'dateTime', 'description', 'imageURL']);
        let formValue = form.getValue();
        
        formValue.createdById = sessionStorage.getItem('userId');
        formValue.createdByName = sessionStorage.getItem('email');
        formValue.likes = 0;

        await requester.treks.createEntity(formValue);
        
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
    let form = createFormEntity(formRef, ['location', 'dateTime', 'description', 'imageURL']);

    /**
     * Load and set the initial form value for edit
     */
    const trekToEdit = await requester.treks.getById(this.params.id);
    form.setValue(trekToEdit);

    formRef.addEventListener('submit', async e => {
        e.preventDefault();
        let form = createFormEntity(formRef, ['location', 'dateTime', 'description', 'imageURL']);
        let formValue = form.getValue();

        await requester.treks.patchEntity(formValue, this.params.id);

        /** 
         * Navigates back to the catalog details
         */
        this.redirect(`#/details/${this.params.id}`);
    });
}

export async function deleteHandler() {
    await requester.treks.deleteEntity(this.params.id);

    this.redirect('#/home')
    return false
}
