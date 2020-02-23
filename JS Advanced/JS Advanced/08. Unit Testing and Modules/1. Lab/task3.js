function solve(cards){
    function makeCard(face, suit) {
        const validFaces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
        const validSuits = {S: '\u2660', H:'\u2665', D:'\u2666', C:'\u2663'};
    
        if (!validFaces.includes(face)) {
            throw new Error("Invalid card face: " + face);
        }
        if (!validSuits.hasOwnProperty(suit)) {
            throw new Error("Invalid card suit: " + suit);
        }
    
        return {
            face,
            suit,
            toString() {
                return face + validSuits[suit]
            }
        };
    }

    let deck = [];

    for (const card of cards) {
        let suit = card.substring(card.length - 1);
        let face = card.substring(0, card.length - 1);

        try {
            deck.push(makeCard(face, suit));
        }
        catch (err) {
            console.log("Invalid card: " + card);
            return;
        }
    }

    console.log(deck.join(' '));
}

solve(
    ['AS', '10D', 'KH', '2C']
)