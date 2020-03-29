import {requester} from '../services/app-service.js';

export async function likesHandler(){
    const likes = Number(this.params.currentLikes) + 1;
    const id = this.params.id;
    
    await requester.treks.patchEntity({likes: likes}, id);

    this.redirect('#/details/' + id)
    return false;
}