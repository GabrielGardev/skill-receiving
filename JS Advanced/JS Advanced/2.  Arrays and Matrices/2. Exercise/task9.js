function solve(matrix) {

    matrix = matrix
    .map(x => x.split(/\s+/).map(Number))

    const leftDiagonal = matrix.reduce((a, _, i) => a + matrix[i][i], 0)
    const rightDiagonal = matrix.reduce((a, _, i) => a + matrix[i][matrix.length - 1 - i], 0)

    if(leftDiagonal !== rightDiagonal){
        return matrix.map(x => x.join(' ')).join('\n')
    }
    
    matrix.forEach((x, i, arr) => {
        x.forEach((_, j) => {
            if(j !== i && j !== arr.length - 1 - i){
                matrix[i][j] = leftDiagonal;
            }
        })
    });

    return matrix.map(x => x.join(' ')).join('\n')
}

console.log(solve([
    '5 3 12 3 1',
    '11 4 23 2 5',
    '101 12 3 21 10',
    '1 4 5 2 2',
    '5 22 33 11 1'
]
))