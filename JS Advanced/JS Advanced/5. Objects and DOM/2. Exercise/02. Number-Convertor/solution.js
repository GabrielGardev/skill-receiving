function solve() {
    let optionList = document.querySelectorAll('#selectMenuTo')[0]
    let button = document.querySelector('#container button')
    let input = document.querySelector('#input')

    optionList.innerHTML = `
    <option selected value=""></option>
    <option value="hexadecimal">Hexadecimal</option>
    <option value="binary">Binary</option>
    `

    button.addEventListener('click', () => {

        let result = ''
        if (optionList.value === 'binary') {
            result = (Number(input.value)).toString(2)
        } else {
            result = (Number(input.value)).toString(16).toUpperCase()
        }
        document.getElementById('result').value = result;
    })
}