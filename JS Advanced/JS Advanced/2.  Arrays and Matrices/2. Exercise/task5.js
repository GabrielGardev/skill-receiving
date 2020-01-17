function solve(arr){
    arr.reduce((acc, curr, i) => {
        let last = acc[acc.length - 1];
        if (curr > last || last === undefined) {
            acc.push(curr)
        }

        return acc;
    }, [])

    return arr
}

solve([1, 
    3, 
    8, 
    4, 
    10, 
    12, 
    3, 
    2, 
    24])