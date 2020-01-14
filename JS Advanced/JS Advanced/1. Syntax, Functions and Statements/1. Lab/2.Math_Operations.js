function slove(x, y, operator){
    return eval(`${x}${operator}${y}`);
};

console.log(
    slove(5, 6, "+")
);