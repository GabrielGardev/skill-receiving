function solve(input){
    let result = {}
    JSON.parse(input).map(x => Object.assign(result, x))
    return result
}

console.log(
    solve(
        `[{"canMove": true},{"canMove":true, "doors": 4},{"capacity": 5}]`
    )
)