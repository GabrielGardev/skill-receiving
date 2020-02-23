class Circle{
    _radius;

    constructor(radius){
        this._radius = radius;
    }

    get diameter() {
        return 2 * this._radius;
    }

    get radius() {
        return this._radius;
    }

    set diameter(diameter){
        this._radius = diameter / 2;
    }

    get area(){
        return Math.PI * this._radius**2;
    }
}