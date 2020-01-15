function solve(arr) {
    let drinks = {
        'coffee caffeine': 0.80,
        'coffee decaf': 0.90,
        tea: 0.80
    }
    let totalMoney = 0;

    arr.forEach(element => {
        let arr1 = element.split(', ')
        let coins = arr1[0];
        let typeOfDrink = arr1[1];
        let price;

        if (typeOfDrink === 'coffee') {
            price = drinks[typeOfDrink.concat(' ').concat(arr1[2])]
        } else {
            price = drinks[typeOfDrink]
        }

        if (arr1.includes('milk')) {
            let milkPrice = Math.round((price * 0.1) * 10) / 10;
            price += milkPrice;
        }

        if (arr1[arr1.length - 1] !== '0') {
            price += 0.1;
        }

        let change = coins - price;
        if (coins >= price) {
            totalMoney += price;
            console.log(`You ordered ${typeOfDrink}. Price: $${price.toFixed(2)} Change: $${change.toFixed(2)}`)
        } else {
            console.log(`Not enough money for ${typeOfDrink}. Need $${Math.abs(change).toFixed(2)} more`)
        }
    });
    console.log(`Income Report: $${totalMoney.toFixed(2)}`)
}

solve(['1.00, coffee, caffeine, milk, 4', '0.40, tea, milk, 2', '1.00, coffee, decaf, 0'])