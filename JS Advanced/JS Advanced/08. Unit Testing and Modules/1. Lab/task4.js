let expect = require("chai").expect;

function sum(arr) {
    let sum = 0;
    for (num of arr)
        sum += Number(num);
    return sum;
}

describe('sum tests', function () {
    it("Should return sum(\"invalid data\") NaN", function () {
        // Arrange
        let array = "invalid data";
        // Act
        let result = sum(array);
        // Assert
        expect(result).to.be.NaN;
    });

    it("Should return NaN if array contains string", function () {
        // Arrange
        let array = [1, 2, "gosho"];
        // Act
        let result = sum(array);
        // Assert
        expect(result).to.be.NaN;
    });

    it('should return correct sum of integers', function () {
        // Arrange
        let array = [1, 1];
        // Act
        let result = sum(array);
        // Assert
        expect(result).to.be.equal(2);
    });

    it('should return correct sum of floats', function () {
        // Arrange
        let array = [1.1, 1.1];
        // Act
        let result = sum(array);
        // Assert
        expect(result).to.be.equal(2.2);
    });

    it('should return correct sum of floats with negatives', function () {
        // Arrange
        let array = [1.1, 1.1, -0.2];
        // Act
        let result = sum(array);
        // Assert
        expect(result).to.be.equal(2);
    });

    it("Should return sum([1.5, 2.5, -1])  3", function () {
        // Arrange
        let array = [1.5, 2.5, -1];
        // Act
        let result = sum(array);
        // Assert
        expect(result).to.be.equal(3);
    });

    it("Should return sum([1, 2])  3", function () {
        // Arrange
        let array = [1, "2"];
        // Act
        let result = sum(array);
        // Assert
        expect(result).to.be.equal(3);
    });

    it("Should return error", function () {
        // Arrange
        let array = {};
        // Assert
        expect(() => sum(array)).to.throw();
    });

    it("should return 0 for empty array", function () {
        expect(sum([])).to.be.equal(0);
    });
})