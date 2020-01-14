function solve(x){
    let result;
    let type = typeof(x);

    if(type === 'number'){
        result = Math.pow(x, 2) * Math.PI;
        console.log(result.toFixed(2));
    }else{
        console.log(`We can not calculate the circle area, because we receive a ${type}.`)
    }
}
