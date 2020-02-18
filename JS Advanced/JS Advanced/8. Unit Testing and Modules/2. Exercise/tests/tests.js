let SkiResort = require('../solution');
let assert = require('chai').assert;

describe('SkiResort', function () {
    let ski;

    beforeEach(() => {
        ski = new SkiResort('gosho');
    });

    describe('constructor', () => {
        it('', () => {
            assert.deepEqual(ski, { name: 'gosho', voters: 0, hotels: [] });
        });
    });

    describe('bestHotel', () => {
        it('no voters', () => {
            assert.deepEqual(ski.bestHotel, 'No votes yet');
        });

        it('some voters', () => {
            ski.build('pesho', 10)
            ski.book('pesho', 6)
            ski.leave('pesho', 6, 7)
            console.log(ski.bestHotel)
            assert.equal(ski.bestHotel, 'Best hotel is pesho with grade 42. Available beds: 10');
        });
    });

    describe('build', () => {
        it('if empty', () => {
            assert.throws(() => ski.build("", 3), "Invalid input");
            assert.throws(() => ski.build("gosho", -1), "Invalid input");
        });
        it('if OK', () => {
            assert.equal(ski.build("pravec", 3), "Successfully built new hotel - pravec")
            assert.equal(ski.hotels.length, 1);
        });
    });

    describe('book', () => {
        beforeEach(() => {
            ski.build('gosho', 10);
        });
        it('if empty', () => {
            assert.throws(() => ski.book("", 3), "Invalid input");
            assert.throws(() => ski.book("gosho", -1), "Invalid input");
        });
        it('if hotel dont exist', () => {
            assert.throws(() => ski.book("pravec", 5), "There is no such hotel");
        });
        it('if no free beds', () => {
            assert.throws(() => ski.book("gosho", 11), "There is no free space");
        });
        it('if OK', () => {
            assert.equal(ski.book("gosho", 3), "Successfully booked");
            assert.equal(ski.hotels[0].beds, 7);
        });
    });

    describe('leave', () => {
        beforeEach(() => {
            ski.build('gosho', 10);
        });
        it('if empty', () => {
            assert.throws(() => ski.leave("", 3, 5), "Invalid input");
            assert.throws(() => ski.leave("gosho", -1, 5), "Invalid input");
        });
        it('if hotel dont exist', () => {
            assert.throws(() => ski.leave("pravec", 5, 7), "There is no such hotel");
        });
        it('if OK', () => {
            ski.book('gosho', 3);
            assert.equal(ski.leave("gosho", 3, 7), "3 people left gosho hotel");
            assert.equal(ski.hotels[0].beds, 10);
        });
    });

    describe('averageGrade', () => {
        it('if empty', () => {
            assert.equal(ski.averageGrade(), "No votes yet");
        });
        it('if OK', () => {
            ski.build('gosho', 10);
            ski.book('gosho', 3);
            ski.leave("gosho", 3, 7)
            console.log(ski.averageGrade());
            assert.equal(ski.averageGrade(), "Average grade: 7.00");
        });
    });
});
