function solve(input) {

    const compareByLengthAscending = (a, b) => a.length - b.length

    const compareByValueDescending = (a, b) => b - a

    const format = x => `[${JSON.parse(x).join(', ')}]`

    const toSortedArray = x => JSON.parse(x)
        .map(Number)
        .sort(compareByValueDescending)

    const aggregateResultArray = (a, b) => {
        a.push(format(b))
        return a
    }

    return [...new Set(input.map(toSortedArray)
        .sort(compareByLengthAscending)
        .map(x => JSON.stringify(x)))]
        .reduce(aggregateResultArray, [])
        .join('\n')
}

console.log(solve(["[-3, -2, -1, 0, 1, 2, 3, 4]",
    "[10, 1, -17, 0, 2, 13]",
    "[4, -3, 3, -2, 2, -1, 1, 0]"]
))