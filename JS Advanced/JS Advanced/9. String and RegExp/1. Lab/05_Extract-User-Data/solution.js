function solve() {
    const regex = /([A-Z][a-z]*\s[A-Z][a-z]{1,})\s(\+359(\s|\-)[0-9](\s|\-)[0-9]{3}(\s|\-)[0-9]{3})\s([0-9a-z]+\@[a-z]+\.[a-z]{2,3})/gm;
    let array = JSON.parse(document.getElementById('arr').value);
    let result = document.getElementById('result');

    for (let element of array) {
        let m = regex.exec(element);
        if (m === null) {
            let p = document.createElement('p');
            p.innerHTML = 'Invalid data';
            result.appendChild(p);
        }
        if (m !== null) {
            m.forEach((match, groupIndex) => {
                if (groupIndex == 1) {
                    let p = document.createElement('p');
                    p.innerHTML = `Name: ${match}`;
                    result.appendChild(p);
                }
                if (groupIndex == 2) {
                    let p = document.createElement('p');
                    p.innerHTML = `Phone Number: ${match}`;
                    result.appendChild(p);
                }
                if (groupIndex == 6) {
                    let p = document.createElement('p');
                    p.innerHTML = `Email: ${match}`;
                    result.appendChild(p);
                }
            });

        }
        let p = document.createElement('p');
        p.innerHTML = '- - -';
        result.appendChild(p);
    }
}