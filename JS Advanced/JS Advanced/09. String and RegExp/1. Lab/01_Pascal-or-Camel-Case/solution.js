function solve() {
  function pascalOrCamelCase(input, currentCase) {
    let split = input.toLowerCase().split(' ').filter(a => a !== '');
    let output = '';

    if (currentCase === 'Pascal Case') {
      for (let word of split) {
        if (word[0] !== word[0].toUpperCase()) {
          word = word.replace(word[0], word[0].toUpperCase());
        }
        output += word;
      }
    }
    else if (currentCase === 'Camel Case') {
      for (let word of split) {
        if (word[0] !== word[0].toUpperCase()) {
          word = word.replace(word[0], word[0].toUpperCase());
        }
        output += word;
      }
      output = output.replace(output[0], output[0].toLowerCase());
    }
    else{
      output = 'Error!';
    }
    document.getElementById('result').innerHTML = output;
  }
  let text = document.getElementById('text').value;
  let namingConvention = document.getElementById('naming-convention').value;
  pascalOrCamelCase(text, namingConvention)
}