function solve(arr){
    arr.sort((a, b) => 
        a.length - b.length || a.toLowerCase().localeCompare(b.toLowerCase())
    )

    return arr.join('\n');
}


console.log(solve(['Isacc', 
'Theodor', 
'Jack', 
'Harrison', 
'George']))