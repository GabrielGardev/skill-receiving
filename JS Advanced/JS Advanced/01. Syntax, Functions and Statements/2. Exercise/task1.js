function solve(fruit, weight, price){
    weight = weight / 1000;
    price = weight * price;

    console.log(`I need $${price.toFixed(2)} to buy ${weight.toFixed(2)} kilograms ${fruit}.`);
}

console.log(solve('orange', 2500, 1.80))