function create(words) {
   for (const word of words) {
      let div = document.createElement('div');
      let par = document.createElement('p');

      par.textContent = word;
      par.style.display = 'none';

      div.appendChild(par);
      div.addEventListener('click',function (event) {
          event.target.children[0].style.display = 'inline-block'
      });

      document.getElementById('content').appendChild(div);
  }
}