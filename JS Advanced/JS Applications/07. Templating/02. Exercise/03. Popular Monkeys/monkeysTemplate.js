import { monkeys } from './monkeys.js';

(() => {
    renderMonkeyTemplate();

    async function renderMonkeyTemplate() {
        const monkeyCard = await fetch("./mon-card.hbs").then(x => x.text());

        const tempFn = Handlebars.compile(monkeyCard);
        const html = tempFn({ monkeys });

        document.getElementsByClassName('monkeys')[0].innerHTML = html;
    }

    document.addEventListener('click', (e) => {
        if (e.target.tagName === 'BUTTON') {
            let c = document.getElementById(`${e.target.dataset.id}`);
            c.style.display = c.style.display === "none" ? "block" : "none";
        }
    })
})()