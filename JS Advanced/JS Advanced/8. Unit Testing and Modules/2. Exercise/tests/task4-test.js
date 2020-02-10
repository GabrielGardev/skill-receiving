let mathEnforcer = require('../task4');
let assert = require('chai').assert;

describe('mathEnforcer', () => {
    describe('addFive function', () => {
        it('addFive({}) === undefined', () => {
            assert.equal(mathEnforcer.addFive({}), undefined);
        });
        it('addFive(1) === 6', () => {
            assert.equal(mathEnforcer.addFive(1), 6);
        });
        it('addFive(1.1) === 6.1', () => {
            assert.equal(mathEnforcer.addFive(1.1), 6.1);
        });
        it('addFive(-1.2) === 3.8', () => {
            assert.equal(mathEnforcer.addFive(-1.2), 3.8);
        });
        it('addFive(-20.5) === -15.5', () => {
            assert.equal(mathEnforcer.addFive(-20.5), -15.5);
        });
    });

    describe('subtractTen function', () => {
        it('subtractTen({}) === undefined', () => {
            assert.equal(mathEnforcer.subtractTen({}), undefined);
        });
        it('subtractTen(11) === 1', () => {
            assert.equal(mathEnforcer.subtractTen(11), 1);
        });
        it('subtractTen(11.2) === 1.2', () => {
            assert.equal(mathEnforcer.subtractTen(11.2), 1.1999999999999993);
        });
        it('subtractTen(-11.2) === -21.2', () => {
            assert.equal(mathEnforcer.subtractTen(-11.2), -21.2);
        });
        it('subtractTen(5.6) === -5.6', () => {
            assert.equal(mathEnforcer.subtractTen(5.6), -4.4);
        });
    })

    describe('sum function', () => {
        it('sum({}, 1) === undefined', () => {
            assert.equal(mathEnforcer.sum({}, 1), undefined);
        });
        it('sum(1, {}) === undefined', () => {
            assert.equal(mathEnforcer.sum(1, {}), undefined);
        });
        it('sum(11, 1) === 12', () => {
            assert.equal(mathEnforcer.sum(11, 1), 12);
        });
        it('sum(11.2, 1.1) === 12.3', () => {
            assert.equal(mathEnforcer.sum(11.2, 1.1), 12.299999999999999);
        });
        it('sum(-11.2, -1.1) === -12.3', () => {
            assert.equal(mathEnforcer.sum(-11.2, -1.1), -12.299999999999999);
        });
        it('sum(5.6, -8.2) === 2.6', () => {
            assert.equal(mathEnforcer.sum(5.6, -8.2), -2.5999999999999996);
        });
    })
})