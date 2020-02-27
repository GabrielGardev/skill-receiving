function manipulator() {
    let firstElement;
    let secondElement;
    let resultElement;

    function init(selector1, selector2, resultSelector) {
        firstElement = document.querySelector(selector1);
        secondElement = document.querySelector(selector2);
        resultElement = document.querySelector(resultSelector);
    };

    function add() {
        resultElement.value =
            Number(firstElement.value) + Number(secondElement.value);
    };

    function subtract() {
        resultElement.value =
            Number(firstElement.value) - Number(secondElement.value);
    };

    return { init, add, subtract };
}