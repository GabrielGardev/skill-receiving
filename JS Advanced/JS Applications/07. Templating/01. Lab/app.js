import { contacts } from './contacts.js';

const HB = window.Handlebars;

async function main() {
    let contactCard;
    let cards;

    try {
        contactCard = await fetch("/contact-card.hbs")
            .then(x => x.text());
        cards = await fetch("/contact-cards.hbs")
            .then(x => x.text());
    } catch (e) {
        console.log(e)
    }

    HB.registerPartial('contact', contactCard)
    const allContacts = HB.compile(cards);

    document.body.insertAdjacentHTML('beforeend',
        allContacts({ contacts }));

    document.addEventListener('click', (e) => {
        if (e.target.tagName === 'BUTTON') {
            let c = document.getElementById(`contact_${e.target.dataset.id}`);
            c.style.display = c.style.display === "none" ? "block" : "none";
        }
    })
}

main()