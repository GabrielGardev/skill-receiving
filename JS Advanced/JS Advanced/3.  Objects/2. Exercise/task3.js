function solve(data) {
    const aggregateResult = (a, b) => a += `${b} => ${data.completeBotels[b]}\n`

    data = data
        .map(x => x.split(' => '))
        .reduce((acc, b) => {
            let [name, quantity] = b;

            if (!acc.curentBotels[name]) {
                acc.curentBotels[name] = 0
            }
            acc.curentBotels[name] = acc.curentBotels[name] + +quantity

            let bottelQ = Math.floor(acc.curentBotels[name] / 1000)
            if (bottelQ) {
                acc.completeBotels[name] = bottelQ
            }
            return acc;
        }, { completeBotels: {}, curentBotels: {} })
        
    return Object.keys(data.completeBotels).reduce(aggregateResult, '')
}

console.log(
    solve(['Orange => 2000',
        'Peach => 1432',
        'Banana => 450',
        'Peach => 600',
        'Strawberry => 549'])
)