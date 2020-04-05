import { applyCommon } from './common.js';
import { requester } from '../services/app-service.js';

export async function homeViewHandler() {

    if (!sessionStorage.getItem('userId')) {
        this.redirect('#/login')
        return;
    }

    let articles = await requester.articles.getAll();

    this.articles = Object.entries(articles || {}).map(([articleId, article]) => ({ ...article, articleId }));

    this.JsArticles = this.articles.filter(x => x.category === 'JavaScript')
        .sort((a, b) => b.title.localeCompare(a.title));
    this.CSharpArticles = this.articles.filter(x => x.category === 'C#')
        .sort((a, b) => b.title.localeCompare(a.title));
    this.JavaArticles = this.articles.filter(x => x.category === 'Java')
        .sort((a, b) => b.title.localeCompare(a.title));
    this.PytonArticles = this.articles.filter(x => x.category === 'Pyton')
        .sort((a, b) => b.title.localeCompare(a.title));

    /**
     * Load hbs templates
     */
    await applyCommon.call(this);
    this.partial('./templates/home/home.hbs');
}
