let Parser = require('./solution');
let assert = require("chai").assert;

describe('Parser', function () {
    let parser;
    beforeEach(() => {
        parser = new Parser('[ {"Nancy":"architect"} ]');
    });

    describe('constructor', () => {
        it('addToLog', () => {
            parser._addToLog('neshto');
            assert.deepEqual(parser._log, ['0: neshto'])
        });
        it('check', () => {
            assert.equal(JSON.stringify(parser), 
            '{"_data":[{"Nancy":"architect"}],"_log":[]}');


            assert.deepEqual(parser._log, [])
            parser.addEntries("Steven:tech-support Edd:administrator")
            assert.deepEqual(parser.data, [
                { Nancy: 'architect' },
                { Steven: 'tech-support' },
                { Edd: 'administrator' }
              ]);
        });
        it('ctr', function() {
            const testData = [{ "Rob": "app" }, { "Mike": "racer" }, { "Robin": "razors" }];
            const par = new Parser(JSON.stringify(testData));
    
            assert.deepEqual(par._data, testData);
            assert.deepEqual(par._log, []);
            par._addToLog('start');
            assert.deepEqual(par._log, [`0: start`]);
        });
    });

    describe('getter data', () => {
        it('check', () => {
            const testData = [{ "Rob": "app" }, { "Mike": "racer" }, { "Robin": "razors" }];
            const par = new Parser(JSON.stringify(testData));
            assert.deepEqual(par.data, testData);
            assert.equal(par._log.length, 1);
        });
    });

    describe('print', () => {
        it('check', () => {
            assert.equal(parser.print(), "id|name|position\n0|Nancy|architect");
            assert.equal(parser._log.length, 1);
            assert.deepEqual(parser._log, [`0: print`]);
        });
        it('check lenght', () => {;
            parser.print()
            assert.equal(parser._log.length, 1);
        });
        it('print()', function() {

            const testData = [{ "Rob": "app" }, { "Mike": "racer" }, { "Robin": "razors" }];
            const par = new Parser(JSON.stringify(testData));
            const print = par.print();
    
            assert.deepEqual(par._log, [`0: print`]);
    
            const printStr = 'id|name|position\n' +
                '0|Rob|apple\n' +
                '1|Mike|race\n' +
                '2|Robin|razor';
    
            assert.deepEqual(print, printStr);
        });
    });

    describe('addEntries', () => {
        it('check', () => {
            let actual = parser.addEntries("Steven:tech-support Edd:administrator")
            assert.equal(actual, "Entries added!");
            assert.equal(parser._log.length, 1);
            assert.deepEqual(parser._log, [ '0: addEntries' ]);
            assert.deepEqual(parser._data, [
                { Nancy: 'architect' },
                { Steven: 'tech-support' },
                { Edd: 'administrator' }
              ]);
              assert.equal(parser.print(), "id|name|position\n0|Nancy|architect\n1|Steven|tech-support\n2|Edd|administrator");
        });
    });

    describe('removeEntry', () => {
        it('dont exist', () => {
            let actual = () => parser.removeEntry("pesho");
            assert.throws(actual, "There is no such entry!");
        })
        it('check', () => {
            parser.addEntries("Steven:tech-support Edd:administrator");
            let actual = parser.removeEntry("Nancy")
            assert.equal(actual, "Removed correctly!");
            assert.equal(parser._log.length, 2);
            assert.deepEqual(parser._data, [
                { Nancy: 'architect', deleted: true },
                { Steven: 'tech-support' },
                { Edd: 'administrator' }
              ]);
        });
    });
});
