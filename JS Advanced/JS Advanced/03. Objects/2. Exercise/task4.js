function solve(data){
    let store = data.reduce((acc, product) => {
        let firstLetter = product.charAt(0)
                                                         //acc[firstLetter].push(product)
        !acc[firstLetter] ? acc[firstLetter] = [product] : acc[firstLetter] = [...acc[firstLetter], product]
        
        return acc
    }, {})

    return Object.keys(store).sort().reduce((acc, b) => {
        acc += `${b}\n  ${store[b]
            .map(x => x.split(' : ').join(': '))
            .sort()
            .join('\n  ')}\n`
        return acc
    },'')
}

console.log(
    solve(
        ['Appricot : 20.4',
'Fridge : 1500',
'TV : 1499',
'Deodorant : 10',
'Boiler : 300',
'Apple : 1.25',
'Anti-Bug Spray : 15',
'T-Shirt : 10']
    )
)