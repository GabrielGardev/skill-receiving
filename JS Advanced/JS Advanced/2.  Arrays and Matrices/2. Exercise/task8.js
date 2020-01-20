function solve(playersMoves) {
    let matrix = [
        [false, false, false],
        [false, false, false],
        [false, false, false]
    ];

    let result = [];

    const switchPlayers = (p) => p === 'X' ? 'O' : 'X'; 
    const isAnyFreeSpace = () => matrix.flat(1).includes(false);
    const isCurrentFieldFree = (row, col) => matrix[row][col] === false;
    const addDashboardToResult = () => matrix.forEach(x => result.push(x.join('\t')))

    
    const getColumnConcatData = i => matrix.reduce((a, b) => a + b[i], '')

    const haveFilledRow = symbol => matrix.map(x => x.reduce((acc, cur) => acc + cur, '')).some(x => x === `${symbol}${symbol}${symbol}`)
    const haveFilledCow = symbol => matrix.reduce((acc, _, index) => acc || getColumnConcatData(index) === `${symbol}${symbol}${symbol}`, false)
    const someoneWin = x => haveFilledRow(x) || haveFilledCow(x)


    let playerSymbol = 'X';

    for (let i = 0; i < playersMoves.length; i++) {

        let currentMove = playersMoves[i].split(' ').map(Number);
        let row = currentMove[0];
        let col = currentMove[1];

        if (!isAnyFreeSpace()) {
            console.log("The game ended! Nobody wins :(")
            return;
        }

        if (!isCurrentFieldFree(row, col)) {
            result.push("This place is already taken. Please choose another!");
            continue;
        }

        matrix[row][col] = playerSymbol;
        
        if (someoneWin(playerSymbol)) {
            result.push(`Player ${playerSymbol} wins`)
            addDashboardToResult();
            break;
        }

        playerSymbol = switchPlayers(playerSymbol);
    }

    return result.join('\n');
}

console.log(solve(
    ["0 0",
 "0 0",
 "1 1",
 "0 1",
 "1 2",
 "0 2",
 "2 2",
 "1 2",
 "2 2",
 "2 1"]
))