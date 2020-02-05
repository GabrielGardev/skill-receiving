class CheckingAccount {
    constructor(clientId, email, firstName, lastName) {
        this.clientId = clientId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    set clientId(givenId) {
        if (typeof givenId !== "string" || !/^[0-9]{6}$/g.test(givenId)) {
            throw new TypeError(`Client ID must be a 6-digit number`);
        }
        this._clientId = givenId;
    }

    set email(givenEmail) {
        if (!/^[A-Za-z0-9]+@[A-Za-z.]+$/g.test(givenEmail)) {
            throw  new TypeError("Invalid e-mail");
        }
        this._email = givenEmail;
    }

    set firstName(fName) {
        if (CheckingAccount.validateName(fName, 'First')) {
            this._firstName = fName;
        }
    }

    set lastName(lName) {
        if (CheckingAccount.validateName(lName, 'Last')) {
            this._lastName = lName;
        }
    }

    static validateName(name, nameType) {
        if (name.length < 3 || name.length > 20) {
            throw  new TypeError(`${nameType} name must be between 3 and 20 characters long`);
        }
        if (!/^[A-Za-z]+$/g.test(name)) {
            throw  new TypeError(`${nameType} name must contain only Latin characters`);
        }
        return true;
    }
}