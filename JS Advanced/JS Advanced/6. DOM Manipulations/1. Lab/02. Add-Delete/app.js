function addItem() {
    let items = document.getElementById('items')
    let input = document.getElementById('newText');

    items.addEventListener('click', deleteElement)

    function add() {
        console.log('hoi')
        if (input.value.trim().length > 0) {
            let li = document.createElement('li')
            let link = document.createElement('a')
            link.href = '#';
            link.appendChild(document.createTextNode('[Delete]'))
            
            li.innerHTML = input.value + ' '
            li.appendChild(link);
            items.appendChild(li)

            input.value = ''
        }
    }
    add()

    function deleteElement(e) {
        items.removeChild(e.target.parentElement)
    }
}
