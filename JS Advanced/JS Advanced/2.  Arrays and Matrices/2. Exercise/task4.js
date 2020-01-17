function solve(arr){
    let rotations = +arr.pop()
    rotations = rotations % arr.length

    for (let i = 0; i < rotations; i++) {
        let num = arr.pop()

        arr.unshift(num)
    }

    return arr.join(' ')
}