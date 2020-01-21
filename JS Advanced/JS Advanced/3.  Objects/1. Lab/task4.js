function solve(input) {
    return JSON.stringify(input
        .reduce((a, b, i) => {
            if (isNaN(b)) {
                if (!a[b]) {
                    a[b] = 0
                }
            } else {
                a[input[i - 1]] += +b
            }
            return a;
        }, {}))
}

console.log(
    solve(
        ['Sofia',
            '20',
            'Varna',
            '3',
            'Sofia',
            '5',
            'Varna',
            '4']
    )
)