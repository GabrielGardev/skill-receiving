function solve() {
    let microElements = { protein: 0, carbohydrate: 0, fat: 0, flavour: 0 };

    let recipes = {
        apple: { carbohydrate: 1, flavour: 2 },
        lemonade: { carbohydrate: 10, flavour: 20 },
        burger: { carbohydrate: 5, fat: 7, flavour: 3 },
        eggs: { protein: 5, fat: 1, flavour: 1 },
        turkey: { protein: 10, carbohydrate: 10, fat: 10, flavour: 10 }
    };

    let commands = {
        restock,
        prepare,
        report
    };

    function restock(el, q) {
        microElements[el] += q
        return 'Success';
    }

    function prepare(recipe, quantity) {
        let meal = recipes[recipe];

        for (const element in meal) {
            let amountNeeded = meal[element] * quantity;
            let currentAmount = microElements[element];
            if (amountNeeded > currentAmount) {
                return `Error: not enough ${element} in stock`;
            }
        }

        for (const element in meal) {
            microElements[element] -= meal[element] * quantity;
        }
        return 'Success'
    }

    function report(){
        return Object.keys(microElements)
            .map(key => `${key}=${microElements[key]}`)
            .join(' ');
    }

    return function(input){
        let [command, microElement, quantity] = input.split(/\s+/);
        return commands[command](microElement, +quantity)
    }
}

let manager = solve();

console.log(manager("restock carbohydrate 10"));
console.log(manager("restock flavour 10"));
console.log(manager("prepare apple 1"));
console.log(manager("restock fat 10"));
console.log(manager("prepare burger 1"));
console.log(manager("report"));