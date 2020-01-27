function solve(matrix) {
    //rows
    const getRowSum = (a, b) => a + b;
    const aggregateHaveEqualRowSum = (acc, curr, index) => acc && curr.reduce(getRowSum, 0) === matrix[index + 1].reduce(getRowSum, 0)
    const rowsHaveEqualSum = () => matrix.slice(0, matrix.length - 1).reduce(aggregateHaveEqualRowSum, true)

    //cols
    const getColumnSum = i => matrix.reduce((a, b) => a + b[i], 0)
    const aggregateHaveEqualColSum = (a, _, row) => a && getColumnSum(row) === getColumnSum(row + 1)
    const colsHaveEqualSum = () => matrix.slice(0, matrix.length - 1).reduce(aggregateHaveEqualColSum, true)

    return rowsHaveEqualSum() && colsHaveEqualSum()
}


console.log(solve(
    [
        [4, 5, 6],
        [6, 5, 4],
        [5, 5, 5]
    ]
))