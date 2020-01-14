function slove(firstStr, secondStr, thirdStr){
    let sum = firstStr.length + secondStr.length + thirdStr.length;
    let avg = Math.floor(sum / 3);
    
    console.log(sum);
    console.log(avg);
}


slove('chocolate', 'ice cream', 'cake');


function slove2(...params){
    let sum = params.reduce((a, b) => a + b.length, 0);
    let avg = Math.floor(sum / params.length);

    return [sum, avg];
}

console.log(
    slove2('chocolate', 'ice cream', 'cake')
        .join("\n")
);