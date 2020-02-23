function solve() {

      let resultSpanElements = document.querySelectorAll('#result span');
      let result = document.getElementById("result");
  
      let firstPlayerCards = document.querySelectorAll('#player1Div img');
      let secondPlayerCards = document.querySelectorAll('#player2Div img');
      let allPlayersCards = document.querySelectorAll('img');
  
      for (let i = 0; i < allPlayersCards.length; i++) {
          allPlayersCards[i].addEventListener('click', onClick);
      }
  
      function onClick() {
          this.src = "images/whiteCard.jpg";
          let parentElementId = this.parentElement.id;
  
          if (parentElementId === 'player1Div') {
              let resultFirstSpanElement = resultSpanElements[0];
              resultFirstSpanElement.textContent = this.name;
          } else {
              let resultSecondSpanElement = resultSpanElements[2];
              resultSecondSpanElement.textContent = this.name;
          }
  
          compareCards()
      }
  
      function readyForComparing() {
          return resultSpanElements[0].textContent !== '' && resultSpanElements[2].textContent !== '';
      }
  
      function compareCards() {
          if (readyForComparing()) {
              let winnerCardImg = null;
              let loserCardImg = null;
  
              if (Number(resultSpanElements[0].textContent) > Number(resultSpanElements[2].textContent)) {
                  winnerCardImg = Array.from(firstPlayerCards).filter(c => c.name === resultSpanElements[0].textContent)[0];
                  winnerCardImg.style.border = '2px solid green';
                  loserCardImg = Array.from(secondPlayerCards).filter(c => c.name === resultSpanElements[2].textContent)[0];
                  loserCardImg.style.border = '2px solid red';
  
              } else {
                  winnerCardImg = Array.from(secondPlayerCards).filter(c => c.name === resultSpanElements[2].textContent)[0];
                  winnerCardImg.style.border = '2px solid green';
                  loserCardImg = Array.from(firstPlayerCards).filter(c => c.name === resultSpanElements[0].textContent)[0];
                  loserCardImg.style.border = '2px solid red';
              }
  
              saveResultInHistory();
          }
      }
  
      function saveResultInHistory() {
          let historyElement = document.getElementById('history');
          historyElement.textContent += `[${resultSpanElements[0].textContent} vs ${resultSpanElements[2].textContent}] `;
          result.getElementsByTagName("span")[0].textContent = "";
          result.getElementsByTagName("span")[2].innerHTML = "";
      }
}