function solve(number){
    let num = number.toString().split('');
    let allTrue = true;
    let sum = 0;
    for (let i = 0; i < num.length; i++) {
        if (allTrue){
            allTrue = num[i] === num[0];
        }

        sum = sum + +num[i];
    }

    console.log(allTrue);
    console.log(sum);
}

console.log(solve(2222222))