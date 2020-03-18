import {load} from './load.js';
import {createBook} from './functions.js';

let submit = document.querySelector('#submit');

(function main() {
    load(); 
    submit.addEventListener('click', createBook)
})()