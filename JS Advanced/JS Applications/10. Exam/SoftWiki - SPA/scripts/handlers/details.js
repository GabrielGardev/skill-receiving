import { applyCommon } from './common.js';
import { requester } from '../services/app-service.js';

export async function detailsHandler() {
    let { title, content, creator, category } = await requester.articles.getById(this.params.id);
    this.articleId = this.params.id;
    this.content = content;
    this.title = title;
    this.category = category;
    this.creator = creator;
    this.userIsCreator = sessionStorage.getItem('email') === creator;
    /**
     * Load hbs templates
     */
    await applyCommon.call(this);
    this.partial('./templates/details/details.hbs');
}