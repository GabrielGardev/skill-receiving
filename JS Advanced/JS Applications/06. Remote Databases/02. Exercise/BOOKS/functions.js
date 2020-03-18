import { load } from "./load.js";

const url = "https://testapp-465f1.firebaseio.com/Books/"; //add your URL here

let title = document.getElementById('title');
let author = document.getElementById('author');
let isbn = document.getElementById('isbn');
let actualEdit = document.getElementById('edit');

export function createBook(e) {
    action(e, 'POST')
    .then(load())
}

export function editBook(e, id) {
    action(e, 'PUT', id)
}

export function deleteElem(e) {
    let id = e.target.parentNode.parentNode.getAttribute('data-id');

    fetch(`${url}${id}.json`, {
        method: 'DELETE'
    })
        .then(x => x.json())
        .then(load)
        .catch(x => console.log(x))
}

export function update(e){
    let fields = e.currentTarget.parentNode.parentNode.children;
    let id = e.currentTarget.parentNode.parentNode.getAttribute('data-id');
    title.value = fields[0].innerText
    author.value = fields[1].innerText
    isbn.value = fields[2].innerText

    actualEdit.addEventListener('click', (e) => editBook(e, id))
}

function action(e, method, id = '') {
    e.preventDefault();
    if (!author.value || !title.value || !isbn.value) {
        console.log('Empty inputs')
        return
    }
    let data = {
        "author": author.value,
        "isbn": isbn.value,
        "title": title.value
    }
    return fetch(`${url}${id}.json`, {
        method: method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })
        .then(x => x.json())
        .then(() => {
            author.value = ''
            title.value = ''
            isbn.value = ''
        })
        .catch(x => console.log(x))
}