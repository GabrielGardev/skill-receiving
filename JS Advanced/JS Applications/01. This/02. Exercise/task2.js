function solve(){
    let prev = 0;
    let currentNum = 1;

    return function(){
        const result = prev + currentNum;
        prev = currentNum;
        currentNum = result;

        return prev;
    }
}