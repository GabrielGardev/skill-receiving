let isOddOrEven = require('../task2');
let assert = require('chai').assert;

describe('isOddOrEven behavior', () => {
    it('check the type of input - Boolean case', () => {
        let result = isOddOrEven(true);
        assert.equal(result, undefined)
    });

    it('check the type of input - integer case', () => {
        let result = isOddOrEven(1);
        assert.equal(result, undefined)
    });

    it('should return even', () => {
        let result = isOddOrEven("test");
        assert.equal(result, "even")
    });

    it('should return odd', () => {
        let result = isOddOrEven("tes");
        assert.equal(result, "odd")
    });
})