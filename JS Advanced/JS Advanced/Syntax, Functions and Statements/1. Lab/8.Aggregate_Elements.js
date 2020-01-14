function solve(elements){
    const add = (x, y) => x + y;
    const addInverse = (x, y) => x + (1 / y);
    const conrat = (x, y) => x + y.toString();

    return [
        elements.reduce(add, 0),
        elements.reduce(addInverse, 0),
        elements.reduce(conrat, "")
    ].join("\n")
}

console.log(solve(1, 2, 3))