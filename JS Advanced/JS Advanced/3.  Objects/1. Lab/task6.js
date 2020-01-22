function solve(data) {
    let towns = data.reduce((acc, pair) => {
            let [town, popul] = pair.split('<->').map(x => x.trim())

            !acc[town] ? acc[town] = +popul : acc[town] += +popul
            
            return acc;
        }, {})

        return Object.keys(towns).reduce((acc, curr) => acc + `${curr} : ${towns[curr]}\n` , '')
}

console.log(
    solve(
        ['Sofia <-> 1200000',
'Montana <-> 20000',
'New York <-> 10000000',
'Washington <-> 2345000',
'Las Vegas <-> 1000000']
    )
)