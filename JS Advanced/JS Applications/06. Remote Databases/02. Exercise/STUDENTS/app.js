import { extractFromData, getAll, updateRequest } from "./functionsAndRequests.js";

let tbody = document.querySelector("tbody")

function formRow(id, obj) {
    let row = document.createElement('tr');

    row.innerHTML = `
    <th>${id}</th>
    <th>${obj.firstName}</th>
    <th>${obj.lastName}</th>
    <th>${obj.facultyNumber}</th>
    <th>${obj.grade}</th>
    `
    tbody.appendChild(row);
}

const load = () => {
    getAll().then(getAllSorted)
}

const getAllSorted = (students) => {
    tbody.innerHTML = '';
    Object.entries(students)
        .sort((a, b) => Number(a[0]) - Number(b[0]))
        .forEach(([id, value]) => {
            formRow(id, value);
        })
}

(function doStuff() {
    let formRef = document.querySelector('form');
    const formConfig = ['firstName', 'lastName', 'facultyNumber', 'grade'];

    load()

    formRef.addEventListener('submit', (e) => {
        e.preventDefault();

        let formResult = extractFromData(e.target, formConfig);

        getAll()
            .then(stud => {
                let nextStudentId = !stud ? 0 : Object.keys(stud).length;

                updateRequest(formResult, nextStudentId)
                    .then(() => load())
            })
    })
})()