function growingWord() {
  const colorMap = ['blue', 'green', 'red']


  let word = document.getElementById('exercise').lastElementChild;

  if (word === null) {
    throw new Error("Error..")
  }

  let fontSize = word.style.fontSize.replace('px', '') || 2;

  word.style.fontSize = fontSize === 2 ? '2px' : (fontSize * 2) + 'px'


  let color = word.style.color;

  if (color === '') {
    word.style.color = colorMap[0]
  } else if (color === colorMap[0]) {
    word.style.color = colorMap[1]
  } else if (color === colorMap[1]) {
    word.style.color = colorMap[2]
  } else if (color === colorMap[2]) {
    word.style.color = colorMap[0]
  }
}