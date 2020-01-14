function solve(min, max){
    let num1 = Number(min);
    let num2 = Number(max);

    let result = 0;

    for(let i = num1; i <= num2; i++){
        result += i;
    }
    return result;
}

console.log(
    solve(1, 5)
)