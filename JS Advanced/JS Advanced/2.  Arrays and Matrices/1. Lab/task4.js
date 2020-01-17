function solve(n, k){
    let result = [1];

    for (let i = 1; i < n; i++) {

        let sum = 0;

        let startIndex = Math.max(0, i - k)
        for (let j = startIndex; j < i; j++) {
            sum += result[j];
        }
        result.push(sum)
    }

    return result.join(' ');
}

console.log(solve(6, 3))