
class SortedList {
    constructor(array) {
        this.numbers = array || [];
        this.size = 0;
    }

    add(element) {
        this.numbers.push(element);
        this.sort();
        this.size++;
    }

    remove(index) {
        if (this.isValidIndex(index) && !this.isEmpty()) {
            this.numbers.splice(index, 1);
            this.size--;
        }
    }

    get(index) {
        if (this.isValidIndex(index)) {
            return this.numbers[index];
        }
    }

    isValidIndex(index) {
        return index >= 0 && index < this.numbers.length;
    }

    isEmpty() {
        return this.numbers.length === 0;
    }

    sort() {
        return this.numbers.sort((a, b) => a - b)
    }
}