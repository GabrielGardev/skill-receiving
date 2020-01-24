function solve(...args) {
    let obj = args
    .reduce((acc, b) => {
        !acc[typeof b] 
        ? acc[typeof b] = [typeof b === 'object' ? JSON.stringify(b) : b]
        : acc[typeof b].push(`${b}`)
        return acc
    }, {})

    let str = Object.keys(obj)
        .forEach(b => {
                obj[b].forEach(x => console.log(`${b}: ${x}`))
        })

    let str2 = Object.keys(obj)
            .sort((a, b) => obj[b].length - obj[a].length)
            .forEach(b => console.log(`${b} = ${obj[b].length}`))
    
    return str + str2
}


    solve(
        { name: 'bob'}, 3.333, 9.999
    )