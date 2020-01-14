function solve(...params){
    return `The largest number is ${params
    .sort((a, b) => a - b).pop()}.`
}

console.log(
    solve(5, -3, 16)
)