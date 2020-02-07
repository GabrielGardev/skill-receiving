let expect = require("chai").expect;

function isSymmetric(arr) {
    if (!Array.isArray(arr))
        return false; // Non-arrays are non-symmetric
    let reversed = arr.slice(0).reverse(); // Clone and reverse
    let equal = (JSON.stringify(arr) == JSON.stringify(reversed));
    return equal;
}

describe('symetry test', function() {
    it('should return false if not array', () => {
        let arr = 'not array';
        let result= isSymmetric(arr);
        expect(result).to.be.false;
    });

    it('should return true for symetry', () => {
        let arr = [1, 2, 2, 1];
        let result= isSymmetric(arr);
        expect(result).to.be.true;
    });

    it('should return false for no symetry', () => {
        let arr = [1, 2, 2, 2];
        let result= isSymmetric(arr);
        expect(result).to.be.false;
    });

    it('should return true for empty arr', () => {
        let arr = [];
        let result= isSymmetric(arr);
        expect(result).to.be.true;
    });
    
    it('should return false for number', function () {
        let array = 1;
        let result = isSymmetric(array);
        expect(result).to.be.false;
    });

    it("should return false for [5,'hi',{a:5},new Date(),{X:5},'hi',5]", function() {
        let symmetric = isSymmetric([5, 'hi', { a: 5 }, new Date(), { X: 5 }, 'hi', 5]);
        expect(symmetric).to.be.false;
    });

    it("should return false for [5,'hi',{a:5},new Date(),{X:5},'hi',5]", function() {
        let symmetric = isSymmetric([5, 'hi', { a: 5 }, new Date(), { a: 5 }, 'hi', 5]);
        expect(symmetric).to.be.true;
    });
});