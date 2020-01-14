function solve(input) {
    let num = Number(input[0]);
 
    for (let i = 1; i < input.length; i++) {
 
        if (input[i] === 'chop') {
            num = num / 2;
            console.log(num);
        }
        else if (input[i] === 'dice') {
            num = Math.sqrt(num);
            console.log(num);
        }
        else if (input[i] === 'spice') {
            num += 1;
            console.log(num);
        }
        else if (input[i] === 'bake') {
            num *= 3;
            console.log(num);
        }
        else  {
            num = num - 0.2 * num;
            console.log(num);
        }
    }
}

solve(['32', 'chop', 'chop', 'chop', 'chop', 'chop'])