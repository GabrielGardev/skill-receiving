function solve() {
   let rows = document.querySelectorAll('tbody tr')
   let input = document.getElementById('searchField')
   let search = document.getElementById('searchBtn')

   search.addEventListener('click', () => {
      for (const x of rows) {
         x.removeAttribute('class')
         if (x.textContent.includes(input.value)) {
            x.setAttribute('class', 'select')
         }
      }
      input.value = ''
   })
}