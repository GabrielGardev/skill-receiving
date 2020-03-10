function attachEvents() {
    let ul = document.querySelector('#phonebook');
    let personInput = document.querySelector('#person');
    let phoneInput = document.querySelector('#phone');

    function load() {
        ul.innerHTML = ''
        fetch('https://rest-service-and-ajax.firebaseio.com/phonebook.json')
            .then(x => x.json())
            .then(res => {
                Object.entries(res).forEach(([elId, data]) => {
                    if (data) {
                        let li = document.createElement('li');
                        li.textContent = `${data.person}: ${data.phone}`

                        let btn = document.createElement('button');
                        btn.textContent = 'Delete';
                        btn.setAttribute('data-target', elId);
                        btn.addEventListener('click', deleteEvent);
                        li.appendChild(btn);

                        ul.appendChild(li);
                    }
                });
            })
            .catch(handelError)
    }

    function create() {
        let [person, phone] = [personInput.value, phoneInput.value]

        fetch('https://rest-service-and-ajax.firebaseio.com/phonebook.json', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ person, phone })
        })
            .then(() => {
                ul.innerHTML = ''
                personInput.value = ''
                phoneInput.value = ''

                load()
            })
            .catch(handelError)
    }

    function handelError(err) {
        console.log(err)
    }

    function deleteEvent() {
        fetch(`https://rest-service-and-ajax.firebaseio.com/phonebook/${this.getAttribute("data-target")}.json`, {
            method: 'DELETE'
        })
        .then(() => {
            ul.innerHTML = ''
            load();
        })
        .catch(handelError)
    }

    return { load, create }
}

let result = attachEvents();