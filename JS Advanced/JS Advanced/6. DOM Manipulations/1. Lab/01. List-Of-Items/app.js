function addItem() {
    let input = document.getElementById("newItemText")
    let items = document.getElementById('items')

    function add() {
        let li = document.createElement('li')
        li.innerHTML = input.value
        items.appendChild(li)

        input.value = ''
    }
    add()
}