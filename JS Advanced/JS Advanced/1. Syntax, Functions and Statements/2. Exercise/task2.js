function solve(a, b){
    let copyA = a;
    let copyB = b;

    while(copyB !== 0){
        [copyA, copyB] = [copyB, copyA % copyB]
    }
    return copyA;
}