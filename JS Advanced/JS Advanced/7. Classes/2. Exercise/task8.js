class Kitchen {
    menu = {};
    productsInStock = {};
    actionsHistory = [];

    constructor(budget) {
        this.budget = budget;
    }

    removeUsedProducts(productArr) {
        productArr.map(x => x.split(' ')).forEach(x => this.productsInStock[x[0]] -= Number(x[1]));
    }

    hasTheNeededProducts(productArr) {
        return productArr.map(x => x.split(' '))
            .reduce((a, b) => a && this.productsInStock[b[0]] &&
                this.productsInStock[b[0]] >= Number(b[1]), true)
    }

    loadProducts(array) {
        for (const product of array) {
            let [name, quantity, price] = product.split(' ');

            if (this.budget >= Number(price)) {
                if (!this.productsInStock[name]) {
                    this.productsInStock[name] = 0;
                }
                this.productsInStock[name] += Number(quantity);

                this.budget -= Number(price);
                this.actionsHistory.push(`Successfully loaded ${quantity} ${name}`)
            } else {
                this.actionsHistory.push(`There was not enough money to load ${quantity} ${name}`)
            }
        }
        return this.actionsHistory.join('\n')
    }

    addToMenu(meal, neededProducts, price) {
        if (this.menu.hasOwnProperty(meal)) {
            return `The ${meal} is already in our menu, try something different.`
        }

        this.menu[meal] = { products: neededProducts, price: Number(price) };
        return `Great idea! Now with the ${meal} we have ${Object.keys(this.menu).length} meals in the menu, other ideas?`
    }

    showTheMenu() {
        if (Object.keys(this.menu).length === 0) {
            return `Our menu is not ready yet, please come later...`
        }
        return Object.entries(this.menu).map(([key, value]) => `${key} - $ ${value.price}`)
            .join('\n').trim() + '\n';
    }

    makeTheOrder(meal) {
        if (!this.menu.hasOwnProperty(meal)) {
            return `There is not ${meal} yet in our menu, do you want to order something else?`;
        }

        if (!this.hasTheNeededProducts(this.menu[meal].products)) {
            return `For the time being, we cannot complete your order (${meal}), we are very sorry...`
        }

        this.removeUsedProducts(this.menu[meal].products);
        let price = this.menu[meal].price;
        this.budget += price;

        return `Your order (${meal}) will be completed in the next 30 minutes and will cost you ${price}.`
    }
}