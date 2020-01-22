function solve(data){
    const sortNames = (a,b) => a.length - b.length || a.localeCompare(b)
    


    return [...new Set(data
        .sort(sortNames))].join('\n')
}

console.log(
    solve(
        ['Ashton',
'Kutcher',
'Ariel',
'Lilly',
'Keyden',
'Aizen',
'Billy',
'Braston']
    )
)