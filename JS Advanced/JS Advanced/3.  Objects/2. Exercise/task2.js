function solve(data){
    let parsedData = data.map(x => JSON.parse(x))

    let createTable = content => `<table>\n${content}</table>`
    let createRow = content => `\t<tr>\n${content}\t</tr>\n`
    let createTableData = content => `\t\t<td>${content}</td>\n`

    let result = parsedData.reduce((accRow, row) => {

        let tdForPerson = Object.values(row).reduce((tdAcc, td) => tdAcc + createTableData(td), '')

        return accRow + createRow(tdForPerson)
    }, '')

    return createTable(result)
}

console.log(
    solve(['{"name":"Pesho","position":"Promenliva","salary":100000}',
    '{"name":"Teo","position":"Lecturer","salary":1000}',
    '{"name":"Georgi","position":"Lecturer","salary":1000}'])
)