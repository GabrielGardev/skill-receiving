class Person {
    _first;
    _last;
    constructor(first, last) {
        this._first = first;
        this._last = last;
    }

    get firstName() { return this._first; }
    set firstName(first) { return this._first = first; }

    get lastName() {
        return this._last;
    }

    set lastName(last) {
        return this._last = last;
    }

    get fullName() {
        return `${this.firstName} ${this.lastName}`;
    }

    set fullName(name) {
        let arr = Array.from(name.split(' '));
        if (arr.length === 2) {
            this._first = arr[0];
            this._last = arr[1];
        }

        return this.fullName;
    }
}

let person = new Person("Peter", "Ivanov");
console.log(person.fullName);//Peter Ivanov
person.firstName = "George";
console.log(person.fullName);//George Ivanov
person.lastName = "Peterson";
console.log(person.fullName);//George Peterson
person.fullName = "Nikola Tesla";
console.log(person.firstName)//Nikola
console.log(person.lastName)//Tesla