function solve() {
  let input = document.getElementById('input')
  let output = document.getElementById('output')

  input.innerHTML
    .split('.')
    .map(x => x += '.')
    .reduce((acc, b, i, arr) => {
      if (i % 3 === 0 || i === arr.length - 1) {
        let p = document.createElement('p')
        p.innerHTML = acc;
        output.appendChild(p);
        acc = ''
      }
      return acc += b
    }, '')
}