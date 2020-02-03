function solve(){
    class Person {
        _firstName;
        _lastName;
        _age;
        _email;
        constructor(firstName, lastName, age, email) {
            this._firstName = firstName;
            this._lastName = lastName;
            this._age = age;
            this._email = email;
        }
    
        get firstName() {
            return this._firstName;
        }
    
        get lastName() {
            return this._lastName;
        }
    
        get age() {
            return this._age;
        }
    
        get email() {
            return this._email;
        }
    
        toString(){
            return `${this.firstName} ${this.lastName} (age: ${this.age}, email: ${this.email})`
        }
    }

    let result = [];

    result.push(new Person('Anna', 'Simpson', 22, 'anna@yahoo.com'))
    result.push(new Person('SoftUni'))
    result.push(new Person('Stephan', 'Johnson', 25))
    result.push(new Person('Gabriel', 'Peterson', 24, 'g.p@gmail.com'))

    return result
}