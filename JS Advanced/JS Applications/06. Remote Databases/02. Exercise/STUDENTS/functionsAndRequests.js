export const apiKey = 'https://testapp-465f1.firebaseio.com/';
const tableName = 'students'; //add name of the table here example: 'books'

// @formRef param is reference of the html from element
// @formConfig param is array of names that we searching for example: ['title', 'author', 'isbn'] 
// return object with values of the elements
// form shuld have name attributes
export function extractFromData(formRef, formConfig) {
    return formConfig.reduce((acc, inputName) => {
        acc[inputName] = formRef.elements[inputName].value;
        return acc;
    }, {})
}

const jsonParse = (x) => x.json();
const errorHandler = (err) => console.log(err);

// Requests
export const getAll = () => {
    return fetch(`${apiKey}${tableName}.json`)
        .then(jsonParse)
        .catch(errorHandler)
};

export const updateRequest = (data, id) => {
    return fetch(`${apiKey}${tableName}/${id}.json`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })
        .then(jsonParse)
        .catch(errorHandler);
};
