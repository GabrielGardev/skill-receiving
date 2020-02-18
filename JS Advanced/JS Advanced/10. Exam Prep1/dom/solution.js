function solve() {
   const [name, quantity, price] = Array.from(document.querySelectorAll('#add-new input'));
   const addButton = document.querySelector('#add-new button');
   const filterButton = document.querySelector('.filter button');
   const filterInput = document.getElementById('filter');
   const inventory = document.querySelector('#products ul');
   const myProducts = document.querySelector('#myProducts ul');
   const buyButton = document.querySelector('#myProducts button');
   const h1 = Array.from(document.querySelectorAll('h1'))[1];
   let totalPrice = 0;

   addButton.addEventListener('click', addToInventory);
   filterButton.addEventListener('click', filterInventory);
   buyButton.addEventListener('click', buy);

   function addToInventory(e) {
      e.preventDefault();

      let li = document.createElement('li');
      let spanForName = document.createElement('span');
      let strongForQuantity = document.createElement('strong');
      let div = document.createElement('div');
      let strongForPrice = document.createElement('strong');
      let clientButton = document.createElement('button');

      strongForPrice.innerText = Number(price.value).toFixed(2);
      clientButton.innerText = 'Add to Client\'s List';
      clientButton.addEventListener('click', addToMyProducts);
      div.appendChild(strongForPrice);
      div.appendChild(clientButton);

      spanForName.innerText = name.value;
      li.appendChild(spanForName);
      strongForQuantity.innerText = `Available: ${quantity.value}`;
      li.appendChild(strongForQuantity);
      li.appendChild(div);

      inventory.appendChild(li);
   }

   function filterInventory(){
      for(const item of Array.from(inventory.querySelectorAll('li span'))){
         if(!item.textContent.toLowerCase().includes(filterInput.value.toLowerCase())){
            item.parentNode.style.display = "none";
         }
      }
   }

   function addToMyProducts(e){
      let liFromInventory = Array.from(e.target.parentNode.parentNode.children);
      let li = document.createElement('li');
      li.innerText = liFromInventory[0].textContent;
      
      let strong = document.createElement('strong');
      let currentPrice = liFromInventory[2].children[0].textContent;
      strong.innerText = currentPrice;
      li.appendChild(strong);

      let currQuantity = Number(liFromInventory[1].innerText.split(': ')[1]);
      if(currQuantity > 1){
         liFromInventory[1].innerText = `Available: ${currQuantity - 1}`
      }else{
         inventory.removeChild(e.target.parentNode.parentNode);
      }

      totalPrice += Number(currentPrice);
      h1.innerText = `Total Price: ${totalPrice.toFixed(2)}`;
      myProducts.appendChild(li);
   }

   function buy(){
      h1.innerHTML = 'Total Price: 0.00';
      myProducts.innerHTML = "";
   }
}