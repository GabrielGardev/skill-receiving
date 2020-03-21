function attachEvents() {
    document.getElementById('btnLoadTowns')
        .addEventListener('click', async () => {
            const towns = document.getElementById('towns').value.split(', ');
            let root = document.getElementById('root');

            let sourceTemp;
            try {
                // URL is from live server
                sourceTemp = await fetch('http://127.0.0.1:5500/01.%20List%20Towns/towns.hbs')
                    .then(x => x.text())
            } catch (e) {
                console.log(e)
            }

            const context = { towns } //Always an Object
            const template = Handlebars.compile(sourceTemp);
            const html = template(context);
            
            root.innerHTML = html;
        })
}

attachEvents()