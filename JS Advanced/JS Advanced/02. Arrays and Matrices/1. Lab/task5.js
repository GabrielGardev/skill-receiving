function solve(arr){
    let result = [];

    arr.forEach((val, index) => {
        if(index % 2 !== 0){
            result.push(val * 2)
        }
    })

    return result.reverse().join(' ');
}