function solve(data) {
    let cars = data.reduce((acc, b) => {
        let [make, model, produced] = b.split(' | ') 

        if(!acc[make]){
            acc[make] = { [model]: +produced }
        }else {
            if(!acc[make][model]){
                acc[make][model] = +produced
            }else{
                acc[make][model] += +produced
            }
        }

        return acc
    }, {})

    function formatValues(obj){
        return Object.keys(obj).reduce((acc, b) => {
            acc.push(`###${b} -> ${obj[b]}`)
            return acc;
        }, []).join('\n')
    }

    return Object.keys(cars).reduce((acc, b) => {
        acc.push(b)
        acc.push(formatValues(cars[b])) 
        return acc
    }, []).join('\n')
}

console.log(
    solve(
        ['Audi | Q7 | 1000',
'Audi | Q6 | 100',
'BMW | X5 | 1000',
'BMW | X6 | 100',
'Citroen | C4 | 123',
'Volga | GAZ-24 | 1000000',
'Lada | Niva | 1000000',
'Lada | Jigula | 1000000',
'Citroen | C4 | 22',
'Citroen | C5 | 10']
    )
)