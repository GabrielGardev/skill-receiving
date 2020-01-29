function solve() {
   let addButtons = document.querySelectorAll('.add-product');
   let textArea = document.querySelector('textarea');
   let checkOutButton = document.querySelector('.checkout');

   checkOutButton.addEventListener('click', checkout);

   for (let button of addButtons) {
      button.addEventListener('click', onClick);
   }

   let productList = new Set();
   let totalPrice = 0;

   function onClick() {
      let currentProductPrice = this.parentElement.parentElement.getElementsByClassName('product-line-price')[0].textContent;
      let currentProductName = this.parentElement.parentElement.querySelector('div.product-title').textContent;
      let textToAppend = `Added ${currentProductName} for ${currentProductPrice} to the cart.\n`;
      textArea.textContent += textToAppend;
      totalPrice += Number(currentProductPrice);
      productList.add(currentProductName);
   }

   function checkout() {
      textArea.textContent += `You bought ${Array.from(productList).join(', ')} for ${totalPrice.toFixed(2)}.\n`;

      for (let button of addButtons) {
         button.disabled = true;
      }

      checkOutButton.disabled = true;
   }
}