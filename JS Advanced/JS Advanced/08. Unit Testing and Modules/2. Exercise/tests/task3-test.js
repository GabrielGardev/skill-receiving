let lookupChar = require('../task3');
let assert = require('chai').assert;

describe('lookupChar test', () => {
    it('first arg invalid', () => {
        assert.equal(lookupChar({}, 5), undefined)
    });

    it('second arg invalid', () => {
        assert.equal(lookupChar('string', {}), undefined)
    });

    it('second arg float num', () => {
        assert.equal(lookupChar('string', 2.5), undefined)
    });

    it('index outOfBounty', () => {
        assert.equal(lookupChar('string', -1), "Incorrect index")
        assert.equal(lookupChar('string', 90), "Incorrect index")
    });

    it('correct args', () => {
        assert.equal(lookupChar('string', 2), 'r')
    });
})