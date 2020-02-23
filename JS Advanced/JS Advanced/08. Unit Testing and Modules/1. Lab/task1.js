function solve(arr, start, end){
    if(!Array.isArray(arr)){
        return NaN;
    }
    start = start < 0 ? 0 : start;
    end = end > arr.length ? arr.length + 1: end;

    return arr.slice(start, end + 1)
    .reduce((acc, b) => {
        acc += Number(b)
        return acc;
    }, 0)
}

console.log(
    solve([10, 'twenty', 30, 40], 0, 2)
)