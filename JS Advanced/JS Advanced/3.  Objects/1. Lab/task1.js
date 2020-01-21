function solve(input) {
    function deserializaStr(str) {
        return str
            .split("|")
            .filter(x => x !== "")
            .map(x => x.trim())
            .map(x => isNaN(x) ? x : Math.round(Number(x) * 100) / 100)
    }

    let keys = deserializaStr(input[0])
    return JSON.stringify(input
        .slice(1)
        .map(deserializaStr)
        .map(x => x.reduce((res, val, i) => {
            res[keys[i]] = val
            return res;
        }, {})))
}

console.log(
    solve(
        [
            '| Town | Latitude | Longitude |',
                '| Random Town | 0.00 | 0.00 |'
        ]
    )
)