function solve(data){
    let towns = data.reduce((acc, row) => {
        let [town, product, other] = row.split(' -> ');
        let [sales, price] = other.split(' : ');

        !acc[`Town - ${town}`] ? acc[`Town - ${town}`] = [`$$$${product} : ${+sales * +price}`] 
        : acc[`Town - ${town}`].push(`$$$${product} : ${+sales * +price}`)
        
        return acc
    }, {})


    return Object.keys(towns).reduce((a, b) => {
            a.push(b)
            towns[b].forEach(x => a.push(x))
            return a
        },[]).join('\n')
}

console.log(
    solve(
        ['Sofia -> Laptops HP -> 200 : 2000',
'Sofia -> Raspberry -> 200000 : 1500',
'Sofia -> Audi Q7 -> 200 : 100000',
'Montana -> Portokals -> 200000 : 1',
'Montana -> Qgodas -> 20000 : 0.2',
'Montana -> Chereshas -> 1000 : 0.3']
    )
)