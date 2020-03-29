import { applyCommon } from './common.js';
import { requester } from '../services/app-service.js';

export async function profileHandler(){

    const userId = this.params.id;
    const allTreks = await requester.treks.getAll();
    const userTreks = Object.values(allTreks || {}).filter(x => x.createdById === userId);

    this.hasTreks = userTreks.length !== 0;
    this.userTreks = userTreks;
    this.treksCount = userTreks.length;

    await applyCommon.call(this);
    await this.partial('./templates/profile/profile.hbs');
}