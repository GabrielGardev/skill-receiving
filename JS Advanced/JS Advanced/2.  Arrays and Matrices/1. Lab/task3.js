function solve(arr){
    let actionsMap = {
        true: "unshift",
        false: "push"
    }

    let result = [];

    for (let i = 0; i < arr.length; i++) {
        result[actionsMap[arr[i] < 0]](arr[i])   
    }    

    return result
    .forEach(x => {
        console.log(x)
    });
}

solve([7, -2, 8, 9])