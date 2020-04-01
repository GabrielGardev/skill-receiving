import { applyCommon } from './common.js';
import { requester } from '../services/app-service.js';

export async function detailsHandler() {
    let { createdByName, cause, description, pictureUrl, collectedFunds, neededFunds, createdById, donors } 
    = await requester.causes.getById(this.params.id);

    this.causeId = this.params.id;
    this.cause = cause;
    this.description = description;
    this.pictureUrl = pictureUrl;
    this.collectedFunds = collectedFunds;
    this.neededFunds = neededFunds;
    this.createdByName = createdByName;
    this.donors = donors;
    this.userIsCreator = sessionStorage.getItem('userId') === createdById;
    /**
     * Load hbs templates
     */
    await applyCommon.call(this);
    await this.partial('./templates/details/details.hbs');
}