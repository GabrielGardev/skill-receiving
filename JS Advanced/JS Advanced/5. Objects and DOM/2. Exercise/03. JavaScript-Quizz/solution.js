function solve() {
  let quizzie = document.getElementById('quizzie')
  let h1 = document.querySelector(".results-inner h1")
  let ui = document.getElementById("results")

  console.log(h1)

  const corectAnswers = [
    'onclick',
    'JSON.stringify()',
     'A programming API for HTML and XML documents'
  ]
  let userAnswers = 0;
  let index = 1;

  quizzie.addEventListener('click', (e) => {
    
    if (e.target.className === 'answer-text') {

      if (corectAnswers.includes(e.target.innerHTML)) {
        userAnswers++
      }

      if (index >= corectAnswers.length) {
        ui.style.display = "block";

        if (userAnswers === 3) {
          h1.innerHTML = "You are recognized as top JavaScript fan!"
        }else {
          h1.innerHTML = `You have ${userAnswers} right answers`
        }
      }

      quizzie.children[index++].setAttribute('style', 'display: none')
      quizzie.children[index].setAttribute('class', '')
    }
  })
}
