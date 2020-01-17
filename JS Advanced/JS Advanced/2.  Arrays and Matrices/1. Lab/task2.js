function solve(arr){
    let result = '';

    arr
    .forEach((x, index) => {
        if(index % 2 == 0){
            result += x + ' ';
        }
    });

    return result;
}

console.log(solve(['20', '30', '40']))