(() => {
    renderCatTemplate();

    async function renderCatTemplate() {
        const catCard = await fetch("./cat-card.hbs").then(x => x.text());
        const catTemp = await fetch("./cat-temp.hbs").then(x => x.text());

        Handlebars.registerPartial('cat', catTemp);
        const tempFn = Handlebars.compile(catCard);
        const html = tempFn({ cats });

        document.getElementById('allCats').innerHTML = html;
    }

    document.addEventListener('click', (e) => {
        if (e.target.tagName === 'BUTTON') {
            const showStr = 'Show status code';
            const hideStr = 'Hide status code';

            let c = document.getElementById(`${e.target.dataset.id}`);
            e.target.innerText = e.target.innerText === showStr ? hideStr : showStr;
            c.style.display = c.style.display === "none" ? "block" : "none";
        }
    })
})()
