function loadRepos() {
   const req = new XMLHttpRequest();
   req.onreadystatechange = function () {
      if (this.readyState === 4 && this.status === 200) {
         document.querySelector("#res").textContent = this.responseText;
      }
   };
   req.open("GET", "https://api.github.com/users/testnakov/repos");
   req.send();
}