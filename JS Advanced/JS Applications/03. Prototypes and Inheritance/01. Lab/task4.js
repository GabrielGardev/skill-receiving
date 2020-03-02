function solve() {
    class Figure {
        units = {
            m: 0.01,
            cm: 1,
            mm: 10
        }
        defaultUnit;

        constructor(unit = 'cm') {
            this.defaultUnit = unit;
        }

        get area() { return NaN }
        toString() { return `Figures units: ${this.defaultUnit} Area: ${this.area} - ` }
        changeUnits(x) { this.defaultUnit = x }
    }

    class Circle extends Figure {
        constructor(radius) {
            super();
            this.radius = radius
        }

        get area() {
            let r = this.radius * this.units[this.defaultUnit];
            return Math.PI * r * r;
        }
        toString() {
            return super.toString() + `radius: ${this.radius}`
        }
    }

    class Rectangle extends Figure {
        constructor(width, height, unit) {
            super(unit);
            this.width = width;
            this.height = height;
        }
        get w() {
            return this.width * this.units[this.defaultUnit];
        }

        get h() {
            return this.height * this.units[this.defaultUnit];
        }

        get area() {
            return this.w * this.h;
        }
        toString() {
            return super.toString() + `width: ${this.w}, height: ${this.h}`
        }
    }

    return { Figure, Circle, Rectangle }
}


let c = new Circle(5);
console.log(c.area); // 78.53981633974483
console.log(c.toString()); // Figures units: cm Area: 78.53981633974483 - radius: 5

let r = new Rectangle(3, 4, 'mm');
console.log(r.area); // 1200 
console.log(r.toString()); //Figures units: mm Area: 1200 - width: 30, height: 40

r.changeUnits('cm');
console.log(r.area); // 12
console.log(r.toString()); // Figures units: cm Area: 12 - width: 3, height: 4

c.changeUnits('mm');
console.log(c.area); // 7853.981633974483
console.log(c.toString()) // Figures units: mm Area: 7853.981633974483 - radius: 50