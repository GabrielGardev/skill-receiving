import { fireBaseRequestFactory } from './firebase-requests.js';

/**
 * Creates object that support CRUD operations over set of entities 
 */
export const requester = (() => {
    let _teams;
    let _userMeta;
    let apiKey;

    let setAuthToken = (token) => {
        _teams = fireBaseRequestFactory(apiKey, 'teams', token);
        _userMeta = fireBaseRequestFactory(apiKey, 'userMeta', token);
    };

    
    let init = (firebaseApiKey,token = null) => {
        apiKey = firebaseApiKey;
        _teams = fireBaseRequestFactory(apiKey, 'teams', token);
        _userMeta = fireBaseRequestFactory(apiKey, 'userMeta', token);
    };

    return {
        init,
        setAuthToken,
        get userMeta(){
            return _userMeta
        },
        get teams(){
            return _teams
        }
    };
})();