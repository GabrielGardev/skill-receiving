import { applyCommon } from './common.js';
import { requester } from '../services/app-service.js';

export async function detailsHandler() {
    let { createdByName, dateTime, description, imageURL, likes, location, createdById } = await requester.treks.getById(this.params.id);
    this.trekId = this.params.id;
    this.dateTime = dateTime;
    this.description = description;
    this.imageURL = imageURL;
    this.likes = likes;
    this.location = location;
    this.createdByName = createdByName;
    this.userIsCreator = sessionStorage.getItem('userId') === createdById;
    /**
     * Load hbs templates
     */
    await applyCommon.call(this);
    this.partial('./templates/details/details.hbs');
}