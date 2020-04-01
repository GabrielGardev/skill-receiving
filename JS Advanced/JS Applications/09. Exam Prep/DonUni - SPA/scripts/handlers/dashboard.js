import { applyCommon } from './common.js';
import { requester } from '../services/app-service.js';

export async function dashboardHandler() {
    let causes = await requester.causes.getAll();

    this.causes = Object.entries(causes || {}).map(([causeId, cause]) => ({...cause, causeId}));

    /**
     * Load hbs templates
     */
    await applyCommon.call(this);
    this.partial('./templates/home/dashboard.hbs');
}