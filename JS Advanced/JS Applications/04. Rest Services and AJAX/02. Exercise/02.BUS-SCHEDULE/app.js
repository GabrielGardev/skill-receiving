function solve() {
    let info = document.querySelector('.info');
    let btnDepart = document.querySelector('#depart');
    let btnArrive = document.querySelector('#arrive');

    let [currentId, currentName] = ['depot', '']

    function depart() {
        fetch(`https://rest-service-and-ajax.firebaseio.com/schedule/${currentId}.json`)
            .then(x => x.json())
            .then(res => {
                btnDepart.disabled = true;
                btnArrive.disabled = false;
                [currentId, currentName] = [res.next, res.name];
                info.textContent = `Next stop ${currentName}`;
            })
            .catch(() => {
                btnDepart.disabled = true;
                btnArrive.disabled = true;
                info.textContent = `Error`
            })
    }

    function arrive() {
        btnDepart.disabled = false;
        btnArrive.disabled = true;
        info.textContent = `Arriving at ${currentName}`
    }

    return {
        depart,
        arrive
    };
}

let result = solve();