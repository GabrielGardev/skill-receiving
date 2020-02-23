function solve() {
   let creator = document.getElementById('creator');
   let title = document.getElementById('title');
   let category = document.getElementById('category');
   let content = document.getElementById('content');
   let createBtn = document.getElementsByClassName('btn create')[0];
   let articles = document.querySelector('main section');
   let archiveUl = document.querySelector('.archive-section ul');

   createBtn.addEventListener('click', createBlog);

   function createBlog(e){
      e.preventDefault();

      let article = document.createElement('article');
      let h1Title = document.createElement('h1');
      let pCategory = document.createElement('p');
      let strongCategory = document.createElement('strong');
      let pCreator = document.createElement('p');
      let strongCreator = document.createElement('strong');
      let pContent = document.createElement('p');
      let divBtns = document.createElement('div');
      let btnDel = document.createElement('button');
      let btnArchive = document.createElement('button');

      h1Title.textContent = title.value;

      pCategory.textContent = 'Category:';
      strongCategory.textContent = category.value;
      pCategory.appendChild(strongCategory);

      pCreator.textContent = 'Creator:';
      strongCreator.textContent = creator.value;
      pCreator.appendChild(strongCreator);

      pContent.innerText = content.value;

      btnDel.classList.add('btn');
      btnDel.classList.add('delete');
      btnDel.innerText = 'Delete';

      btnDel.addEventListener('click', () => {
         articles.removeChild(article);
      });

      btnArchive.classList.add('btn');
      btnArchive.classList.add('archive');
      btnArchive.innerText = 'Archive';

      btnArchive.addEventListener('click', archiveHandler);

      divBtns.classList.add('buttons');
      divBtns.appendChild(btnDel);
      divBtns.appendChild(btnArchive);

      article.appendChild(h1Title);
      article.appendChild(pCategory);
      article.appendChild(pCreator);
      article.appendChild(pContent);
      article.appendChild(divBtns);

      articles.appendChild(article);
   }

   function archiveHandler(e) {
      let section = e.target.parentNode.parentNode;
      let liContent = section.children[0].textContent;

      let li = document.createElement('li');
      li.textContent = liContent;

      e.target.parentNode.parentNode.style.display = 'none';
      archiveUl.appendChild(li);

      let elements = document.querySelectorAll('.archive-section ul li');

      let elementContents = Array.from(elements)
          .map(x => x.textContent)
          .sort((a, b) => a.localeCompare(b));

      for (const e of elements) {
          archiveUl.removeChild(e);
      }

      for (let e of elementContents) {
          let li = document.createElement('li');
          li.textContent = e;
          archiveUl.appendChild(li);
      }
  }
}
