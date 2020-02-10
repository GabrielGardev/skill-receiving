let StringBuilder = require('../task5');
let assert = require('chai').assert;
let expect = require('chai').expect;

describe('StringBuilder behavior', () => {

    beforeEach(() =>{

    });

    describe('constructor check', () => {
        it('without params', () => {
            let actual = new StringBuilder();
            assert.deepEqual(actual._stringArray, []);
        });

        it('with params', () => {
            let actual = new StringBuilder("ab");
            assert.deepEqual(actual._stringArray, ['a', 'b']);
        });

        it('with undefined', () => {
            let actual = new StringBuilder(undefined);
            assert.deepEqual(actual._stringArray, []);
        });

        it('when param is not string', () => {
            let actual = () => new StringBuilder(1);
            assert.throws(actual, 'Argument must be string');
        });

        it('Simple input test', function() {
            let str = new StringBuilder('hello');
            str.append(', there');
            str.prepend('User, ');
            str.insertAt('woop', 5);
            str.remove(6, 3);
     
            expect(str.toString()).equal('User,w hello, there');
        })

        it('Should have instance type', function() {
            expect(StringBuilder.prototype).to.have.property('append');
            expect(StringBuilder.prototype).to.have.property('prepend');
            expect(StringBuilder.prototype).to.have.property('insertAt');
            expect(StringBuilder.prototype).to.have.property('remove');
            expect(StringBuilder.prototype).to.have.property('toString');
        })
    });

    describe('append behavior', () => {
        it('with params', () => {
            let actual = new StringBuilder("ab");
            actual.append('c')
            assert.deepEqual(actual._stringArray, ['a', 'b', 'c']);
            assert.equal(actual._stringArray.length, 3)
        });

        it('with params more then 1', () => {
            let actual = new StringBuilder("ab");
            actual.append('cde')
            assert.deepEqual(actual._stringArray, ['a', 'b', 'c', 'd', 'e']);
            assert.equal(actual._stringArray.length, 5)
        });

        it('without params', () => {
            let actual = () => new StringBuilder("ab").append();
            assert.throws(actual, 'Argument must be string');
        });

        it('inavalid params', () => {
            let actual = () => new StringBuilder("ab").append(1);
            assert.throws(actual, 'Argument must be string');
        });

        it('inavalid params', () => {
            let actual = () => new StringBuilder("ab").append(true);
            assert.throws(actual, 'Argument must be string');
        });
    });

    describe('prepend behavior', () => {
        it('with params', () => {
            let actual = new StringBuilder("ab");
            actual.prepend('c')
            assert.deepEqual(actual._stringArray, ['c', 'a', 'b']);
            assert.equal(actual._stringArray.length, 3)
        });

        it('with params more then 1', () => {
            let actual = new StringBuilder("ab");
            actual.prepend('cde')
            assert.deepEqual(actual._stringArray, ['c', 'd', 'e', 'a', 'b']);
            assert.equal(actual._stringArray.length, 5)
        });

        it('without params', () => {
            let actual = () => new StringBuilder("ab").prepend();
            assert.throws(actual, 'Argument must be string');
        });

        it('inavalid params', () => {
            let actual = () => new StringBuilder("ab").prepend(1);
            assert.throws(actual, 'Argument must be string');
        });
    });

    describe('insertAt behavior', () => {
        it('with params', () => {
            let actual = new StringBuilder("ab");
            actual.insertAt('c', 1)
            assert.deepEqual(actual._stringArray, ['a', 'c',  'b']);
            assert.equal(actual._stringArray.length, 3)
        });

        it('with one param', () => {
            let actual = () => new StringBuilder("ab").insertAt('c');
            assert.deepEqual(actual._stringArray, undefined);
        });

        it('on bigger position', () => {
            let actual = new StringBuilder("ab");
            actual.insertAt('c', 10)
            assert.deepEqual(actual._stringArray, ['a', 'b', 'c']);
            assert.equal(actual._stringArray.length, 3)
        });

        it('on negative position', () => {
            let actual = new StringBuilder("ab");
            actual.insertAt('c', -10)
            assert.deepEqual(actual._stringArray, ['c', 'a', 'b']);
            assert.equal(actual._stringArray.length, 3)
        });

        it('without params', () => {
            let actual = () => new StringBuilder("ab").insertAt();
            assert.throws(actual, 'Argument must be string');
        });

        it('inavalid params', () => {
            let actual = () => new StringBuilder("ab").insertAt(1, 1);
            assert.throws(actual, 'Argument must be string');
        });

        it('inavalid params', () => {
            let actual = () => new StringBuilder("ab").insertAt(true, false);
            assert.throws(actual, 'Argument must be string');
        });
    });

    describe('remove behavior', () => {
        it('with params', () => {
            let actual = new StringBuilder("abc");
            actual.remove(1, 1)
            assert.deepEqual(actual._stringArray, ['a', 'c']);
            assert.equal(actual._stringArray.length, 2)
        });

        it('with one param', () => {
            let actual = () => new StringBuilder("ab").remove(1);
            assert.deepEqual(actual._stringArray, undefined);
        });

        it('on bigger position', () => {
            let actual = new StringBuilder("ab");
            actual.remove(10, 1)
            assert.deepEqual(actual._stringArray, ['a', 'b']);
            assert.equal(actual._stringArray.length, 2)
        });

        it('on bigger length', () => {
            let actual = new StringBuilder("abc");
            actual.remove(1, 10)
            assert.deepEqual(actual._stringArray, ['a']);
            assert.equal(actual._stringArray.length, 1)
        });

        it('on negative position', () => {
            let actual = new StringBuilder("ab");
            actual.remove(-10 , 1)
            assert.deepEqual(actual._stringArray, ['b']);
            assert.equal(actual._stringArray.length, 1)
        });

        it('on negative lenght', () => {
            let actual = new StringBuilder("ab");
            actual.remove(1 , -1)
            assert.deepEqual(actual._stringArray, ['a', 'b']);
            assert.equal(actual._stringArray.length, 2)
        });

        it('on both negative', () => {
            let actual = new StringBuilder("ab");
            actual.remove(-1 , -1)
            assert.deepEqual(actual._stringArray, ['a', 'b']);
            assert.equal(actual._stringArray.length, 2)
        });

        it('whotout params', () => {
            let actual = () => new StringBuilder("ab").remove();
            assert.deepEqual(actual._stringArray, undefined);
        });

        it('inavalid params', () => {
            let actual = () => new StringBuilder("ab").remove(true, false);
            assert.deepEqual(actual._stringArray, undefined);
        });
    });

    describe('toString behavior', () => {
        it('valid', () => {
            let actual = new StringBuilder("abc");
            assert.deepEqual(actual.toString(), 'abc');
        });

        it('with empty', () => {
            let actual = new StringBuilder();
            assert.deepEqual(actual.toString(), '');
        });
    });
})