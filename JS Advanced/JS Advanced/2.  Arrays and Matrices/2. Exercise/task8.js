function solve(playersMoves) {
    let matrix = [
        [false, false, false],
        [false, false, false],
        [false, false, false]
    ];

    let result = [];

    const switchPlayers = (p) => p === 'X' ? 'O' : 'X'; 
    const isAnyFreeSpace = () => matrix.flat(1).some(x => x === false);
    const isCurrentFieldFree = (row, col) => matrix[row][col] === false;
    const addDashboardToResult = () => matrix.forEach(x => result.push(x.join('\t')))

    
    const getColumnConcatData = i => matrix.reduce((a, b) => a + b[i], '')

    const haveFilledRow = symbol => matrix.map(x => x.reduce((acc, cur) => acc + cur, '')).some(x => x === `${symbol}${symbol}${symbol}`)
    const haveFilledCow = symbol => matrix.reduce((acc, _, index) => acc || getColumnConcatData(index) === `${symbol}${symbol}${symbol}`, false)

    const leftDiagonalIsFilled = symbol => matrix.reduce((a, _, i) => a + matrix[i][i], '') === `${symbol}${symbol}${symbol}`
    const rightDiagonalIsFilled = symbol => matrix.reduce((a, _, i) => a + matrix[i][matrix.length - 1 - i], '') === `${symbol}${symbol}${symbol}`
    const haveFilledDiagonal = x => leftDiagonalIsFilled(x) || rightDiagonalIsFilled(x)

    const someoneWin = x => haveFilledRow(x) || haveFilledCow(x) || haveFilledDiagonal(x)


    let playerSymbol = 'X';

    for (let i = 0; i < playersMoves.length; i++) {

        let [row, col] = playersMoves[i].split(' ')

        if (!isCurrentFieldFree(row, col)) {
            result.push('This place is already taken. Please choose another!');
            continue;
        }

        matrix[row][col] = playerSymbol;
        
        if (someoneWin(playerSymbol)) {
            result.push(`Player ${playerSymbol} wins!`)
            addDashboardToResult();
            break;
        }

        if (!isAnyFreeSpace()) {
            result.push('The game ended! Nobody wins :(')
            addDashboardToResult();
            break;
        }
         
        playerSymbol = switchPlayers(playerSymbol);
    }

    return result.join('\n');
}

