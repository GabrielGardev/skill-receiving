function attachEvents() {
    let messages = document.getElementById('messages')
    let inputA = document.getElementById('author')
    let inputC = document.getElementById('content')
    let btnSent = document.getElementById('submit')
    let btnRefresh = document.getElementById('refresh')

    btnSent.addEventListener('click', postReq)
    btnRefresh.addEventListener('click', getReq)

    function getReq() {
        fetch('https://bomb-cd5af.firebaseio.com/messenger.json')
            .then(x => x.json())
            .then(res => {
                messages.textContent = "";

                const result = [];
                Object.entries(res).forEach(([_, data]) => {
                    result.push(`${data.author}: ${data.content}`)                   
                })
                messages.textContent = result.join("\n");
            })
            .catch(handelError)
    }

    function postReq() {
        [author, content] = [inputA.value, inputC.value]
        const obj = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ author, content })
        }
        fetch('https://bomb-cd5af.firebaseio.com/messenger.json', obj)
            .then(() => {
                inputA.value = ''
                inputC.value = ''
            })
            .catch(handelError)
    }

    function handelError(err) {
        console.log(err)
    }
}

attachEvents();