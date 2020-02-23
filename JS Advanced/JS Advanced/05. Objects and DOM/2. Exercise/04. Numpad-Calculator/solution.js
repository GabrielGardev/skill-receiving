function solve() {
    let expresion = document.getElementById('expressionOutput')
    let result = document.getElementById('resultOutput')
    let pad = document.querySelector('.keys')
    let clearButton = document.querySelector('.clear')

    let operators = {
        '/': (left, right) => left / right,
        'x': (left, right) => left * right,
        '-': (left, right) => left - right,
        '+': (left, right) => left + right
    }

    clearButton.addEventListener('click', () =>{
        expresion.innerHTML = '';
        result.innerHTML = '';
        return
    })

    pad.addEventListener('click', ({ target: {innerHTML}}) => {
        let currentSymbol = innerHTML;

        if (currentSymbol === '=') {
            let arr = expresion.innerHTML.split(' ')
            if(arr[2] === ''){
                result.innerHTML = NaN
                return
            }
            result.innerHTML = operators[arr[1]](+arr[0], +arr[2])
            return
        }
        
        if(currentSymbol >= 0 && currentSymbol <= 9 || currentSymbol === '.'){
            expresion.innerHTML += currentSymbol
            return
        }
        expresion.innerHTML += " " + currentSymbol + " ";
    })
}