import { applyCommon } from './common.js';

export async function homeViewHandler() {
    /**
     * Load hbs templates
     */
    await applyCommon.call(this);
    this.partial('./templates/home/home.hbs');
}
