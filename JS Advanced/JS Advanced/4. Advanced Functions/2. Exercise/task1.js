function solve(arr, order){
    let obj = {
        'asc': (x) => x.sort((a, b) => a - b),
        'desc': (x) => x.sort((a, b) => b - a)
    }

    return obj[order](arr)
}

console.log(
    solve([14, 7, 17, 6, 8], 'asc')
)