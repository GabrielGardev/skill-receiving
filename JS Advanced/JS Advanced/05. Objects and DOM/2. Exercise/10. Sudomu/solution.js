function solve() {
    function hasDuplicates(array) {
        return (new Set(array)).size !== array.length;
    }

    function isSodomuRight(matrix) {
        for(const arr of matrix){
            if (hasDuplicates(arr) || arr.length !== 3) {
                return false
            }
        }

        //rows
        const getRowSum = (a, b) => a + b;
        const aggregateHaveEqualRowSum = (acc, curr, index) => acc && curr.reduce(getRowSum, 0) === matrix[index + 1].reduce(getRowSum, 0)
        const rowsHaveEqualSum = () => matrix.slice(0, matrix.length - 1).reduce(aggregateHaveEqualRowSum, true)
    
        //cols
        const getColumnSum = i => matrix.reduce((a, b) => a + b[i], 0)
        const aggregateHaveEqualColSum = (a, _, row) => a && getColumnSum(row) === getColumnSum(row + 1)
        const colsHaveEqualSum = () => matrix.slice(0, matrix.length - 1).reduce(aggregateHaveEqualColSum, true)
    
        return rowsHaveEqualSum() && colsHaveEqualSum()
    }

    function positiveChange(){
        table.setAttribute('style', 'border: 2px solid green')
        checkP.setAttribute('style', 'color: green')
        checkP.innerHTML = 'You solve it! Congratulations!'
    }

    function negativeChange(){
        table.setAttribute('style', 'border: 2px solid red')
        checkP.setAttribute('style', 'color: red')
        checkP.innerHTML = 'NOP! You are not done yet...'
    }

    let quickCheck = document.querySelector('tfoot tr td button')
    let clear = document.querySelector('tfoot tr td').children[1]
    let table = document.querySelector('table')
    let checkP = document.querySelector('#check p')
    let arr = document.querySelectorAll('input')

    let matrix = [];
    
    quickCheck.addEventListener('click', () => {
        let currArray = [];

        for (let i = 0; i < arr.length; i++) {
            if (i % 3 === 0 && i !== 0) {
                matrix.push(currArray)
                currArray = []
            }
            currArray.push(+arr[i].value)
            if(i === arr.length - 1){
                matrix.push(currArray)
            }
        }

        if(isSodomuRight(matrix)){
            positiveChange()
        }else{
            negativeChange()
        }
    })

    clear.addEventListener('click', () => {
        table.setAttribute('style', 'border: none')
        checkP.innerHTML = ''
        for(const x of arr){
            x.value = ''
        }
    })
}