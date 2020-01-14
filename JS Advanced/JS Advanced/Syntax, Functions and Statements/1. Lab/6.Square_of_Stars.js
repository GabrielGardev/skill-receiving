function solve(x = 5){
    let delimeter = "*";
    let result = new Array(x);
    for (let i = 0; i < x; i++) {
        result[i] = delimeter.repeat(x).split("").join(" ")
    }
    return result.join("\n")
}

console.log(solve())