let expect = require('chai').expect;

function rgbToHexColor(red, green, blue) {
    if (!Number.isInteger(red) || (red < 0) || (red > 255))
        return undefined; // Red value is invalid
    if (!Number.isInteger(green) || (green < 0) || (green > 255))
        return undefined; // Green value is invalid
    if (!Number.isInteger(blue) || (blue < 0) || (blue > 255))
        return undefined; // Blue value is invalid
    return "#" +
        ("0" + red.toString(16).toUpperCase()).slice(-2) +
        ("0" + green.toString(16).toUpperCase()).slice(-2) +
        ("0" + blue.toString(16).toUpperCase()).slice(-2);
}

describe("rgbToHexColor(red, green, blue)", function () {
    describe("Nominal cases(valid input)", function () {
        it("should return #000000 for (0, 0, 0)", function () {
            expect(rgbToHexColor(0, 0, 0)).to.be.equal("#000000");
        });
        it("should return #FFFFFF for (255, 255, 255)", function () {
            expect(rgbToHexColor(255, 255, 255)).to.be.equal("#FFFFFF");
        });
    });

    describe("Special cases(invalid input", function () {
        it("should return undefined for less then 0", function () {
            expect(rgbToHexColor(-1, 0, 0)).to.be.equal(undefined);
            expect(rgbToHexColor(0, -1, 0)).to.be.equal(undefined);
            expect(rgbToHexColor(0, 0, -1)).to.be.equal(undefined);
        });
        it("should return undefined for greather then 255", function () {
            expect(rgbToHexColor(256, 0, 0)).to.be.equal(undefined);
            expect(rgbToHexColor(0, 256, 0)).to.be.equal(undefined);
            expect(rgbToHexColor(0, 0, 256)).to.be.equal(undefined);
        });
        it("should return undefined for not integer value", function () {
            expect(rgbToHexColor(3.14, 0, 0)).to.be.equal(undefined);
            expect(rgbToHexColor(0, 3.14, 0)).to.be.equal(undefined);
            expect(rgbToHexColor(0, 0, 3.14)).to.be.equal(undefined);
        });
        it("should return undefined for empty input", function () {
            expect(rgbToHexColor()).to.be.equal(undefined);
        });
    });
});