function solve(data) {
    return JSON.stringify(data
        .join('')
        .match(/\w+/gim)
        .reduce((a, b) => {
            if (typeof a[b] === 'undefined') {
                a[b] = 0
            }
            a[b]++
            return a;
        }, {}))
}

console.log(
    solve(['JS devs use Node.js for server-side JS.-- JS for devs'])
)