class Stringer {
    constructor(initSting, length) {
        this.innerString = initSting;
        this.innerLength = length;
    }

    increase(length) {
            this.innerLength = this.innerLength + length < 0 ? 0 : this.innerLength + length;  
    }

    decrease(length) {
            this.innerLength = this.innerLength - length < 0 ? 0 : this.innerLength - length;
    }

    toString() {
        return this.innerString.slice(0, this.innerLength) + '...';
    }
}