function solve(arr){
    let result = 0;

    function intersect(a, b){
        return a.filter((element, index) => b[index] === element).length;
    }

    function intersect2(a, b){
        return a.filter((element, index) => b[index + 1] === element).length;
    }


    for (let i = 0; i < arr.length; i++) {
        if(arr.length - 1 === i){
            result += intersect2(arr[i], arr[i]) 
            break;
        }
        result += intersect(arr[i], arr[i + 1])
        result += intersect2(arr[i], arr[i])
    }

    return result;
}
