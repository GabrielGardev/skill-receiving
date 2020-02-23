function solve(steps, stepLength, speed){
    let totalDis = (steps * stepLength);
    let totalRest = Math.floor(totalDis / 500);

    let totaltime = totalDis / speed / 1000 * 60;
    totaltime = Math.ceil((totaltime + totalRest) * 60);

    let result = new Date(null, null, null, null, null, totaltime)
    console.log(result.toTimeString().split(' ')[0]);
}

console.log(solve(4000, 0.60, 5))