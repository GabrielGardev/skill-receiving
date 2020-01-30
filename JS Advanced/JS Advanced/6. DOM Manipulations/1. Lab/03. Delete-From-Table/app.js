function deleteByEmail() {
    let email = document.getElementsByName('email')[0].value;
    let rows = document.querySelectorAll('tbody tr td:nth-child(2)')
    let result = document.getElementById('result')

    for (let td of rows){
        if (td.textContent === email) {
            let row = td.parentNode;
            row.parentNode.removeChild(row);
            result.textContent = "Deleted.";
            return;
        }
        result.textContent = "Not found."
    }
}