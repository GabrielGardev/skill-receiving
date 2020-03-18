import {update} from './functions.js';
import {deleteElem} from './functions.js';

const url = "https://testapp-465f1.firebaseio.com/Books/"; //add your URL here

let tbody = document.querySelector("tbody")

function createElement(tag, content) {
    let element = document.createElement(tag);
    element.innerText = content;
    return element;
}

function appendElements(parrent, childer) {
    parrent.append(...childer)
    return parrent
}

function formRow(rowId, obj) {
    let editBtn = createElement('button', 'Edit');
    editBtn.addEventListener('click', update);

    let deleteBtn = createElement('button', 'Delete');
    deleteBtn.addEventListener('click', deleteElem)
    
    let tdBtns = appendElements(document.createElement('td'), [editBtn, deleteBtn])

    let tdIsbn = createElement('td', obj.isbn);
    let tdAuthor = createElement('td', obj.author);
    let tdTtile = createElement('td', obj.title);

    let row = appendElements(document.createElement('tr'), [tdTtile, tdAuthor, tdIsbn, tdBtns])
    row.setAttribute('data-id' , rowId);
    tbody.appendChild(row);
}

export function load() {
    fetch(`${url}.json`)
        .then(x => x.json())
        .then(res => {
            tbody.innerHTML = ''
            Object.entries(res)
                .forEach(([id, value]) => {
                    formRow(id, value);
                })
        })
        .catch(x => console.log(x))
}