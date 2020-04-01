import { applyCommon } from './common.js';
import { createFormEntity } from '../form-helpers.js';
import { requester } from '../services/app-service.js';
import { triggerSuccessNotification } from '../services/notification.js';

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

        let form = createFormEntity(formRef, ['cause', 'pictureUrl', 'neededFunds', 'description']);
        let formValue = form.getValue();

        if (!formValue.cause || !formValue.pictureUrl || !formValue.neededFunds || !formValue.description) {
            throw new Error('One or more of the fields are empty!')
        }

        formValue.donors = [{ name: "" }];
        formValue.collectedFunds = 0;
        formValue.createdById = sessionStorage.getItem('userId');
        formValue.createdByName = sessionStorage.getItem('email');

        await requester.causes.createEntity(formValue);

        triggerSuccessNotification('Your cause was created successfully!');
        this.redirect('#/home')
    });
}

export async function editHandler() {
    const donation = Number(this.params.currentDonation);
    const cause = await requester.causes.getById(this.params.id);

    if (donation < 0) {
        throw new Error('Cant donate negative value!')
    }

    const donor = {
        name: sessionStorage.getItem('email')
    }

    const updatedDonors = cause.donors.find(x => x.name === donor.name) ?
        cause.donors : [...cause.donors, donor];

    let fundsAndDonors = {
        collectedFunds: cause.collectedFunds + donation,
        donors: updatedDonors
    }

    await requester.causes.patchEntity(fundsAndDonors, this.params.id);

    triggerSuccessNotification('You donated successfully!');
    this.redirect(`#/details/${this.params.id}`)
}

export async function deleteHandler() {
    await requester.causes.deleteEntity(this.params.id);

    triggerSuccessNotification('Cause successfully deleted!');
    this.redirect('#/dashboard')
    return false
}
