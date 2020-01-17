function solve(arr){
    let curentNum = 1;
    let result = [];

    function commands(cmd) {
        if (cmd === 'add') {
            result.push(curentNum++)
        }else{
            result.pop() 
            curentNum++
        }
    }

    arr.forEach(cmd => {
        commands(cmd)
    });

    if(result.length < 1){
        console.log('Empty')
    }else {
        console.log(result.join('\n'))
    }
}

solve(['add', 
'add', 
'remove', 
'add', 
'add'])