function solve(data){
        const sortData = (a, b) => {
            let curr = Object.keys(parsedData[b]).length - Object.keys(parsedData[a]).length
            if(curr === 0){
                return a.localeCompare(b)
            }
            return curr
        }

        let parsedData = data.reduce((db, componentData) => {
            let [systemName, componentName, subName] = componentData.split('|').map(x => x.trim())

            !db[systemName] ? db[systemName] = { [componentName]: [subName] }
            : !db[systemName][componentName] ? db[systemName][componentName] = [subName]
            : db[systemName][componentName] = [...db[systemName][componentName], subName]

            return db
        }, {})

        function formatSubComp(arr){
            return arr.reduce((acc, b) => {
                acc.push(`||||||${b}`)
                return acc;
            }, []).join('\n')
        }

        function formatComp(obj){
            return Object.keys(obj)
            .sort((a, b) => Object.keys(obj[a]) > Object.keys(obj[b]) ? -1 : 1)
            .reduce((acc, b, _, arr) => {
                acc.push(`|||${b}`)
                acc.push(formatSubComp(obj[b]))
                return acc;
            }, []).join('\n')
        }

        return Object.keys(parsedData)
        .sort(sortData)
        .reduce((acc, b) => {
            acc.push(b)
            acc.push(formatComp(parsedData[b]))
            return acc
        }, []).join('\n')
    
}

console.log(
    solve(
        ['SULS | Main Site | Home Page',
'SULS | Main Site | Login Page',
'SULS | Main Site | Register Page',
'SULS | Judge Site | Login Page',
'SULS | Judge Site | Submittion Page',
'Lambda | CoreA | A23',
'SULS | Digital Site | Login Page',
'Lambda | CoreB | B24',
'Lambda | CoreA | A24',
'Lambda | CoreA | A25',
'Lambda | CoreC | C4',
'Indice | Session | Default Storage',
'Indice | Session | Default Security']
    )
)