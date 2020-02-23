function solve() {
  document.getElementsByTagName('button')[0].addEventListener('click', generateItems);
  document.getElementsByTagName("button")[1].addEventListener('click', listPurchaseInfo);

  function generateItems() {
      let furnitureListElement = document.querySelector('#exercise textarea');
      let table = document.getElementsByClassName('table')[0];
      let furniture = JSON.parse(furnitureListElement.value);

      for (let item of furniture) {
          let tr = document.createElement('tr');
          let imageTd = document.createElement("td");
          let nameTd = document.createElement("td");
          let priceTd = document.createElement("td");
          let decorationFactorTd = document.createElement("td");

          let img = document.createElement("img");
          img.src = item['img'];
          imageTd.appendChild(img);
          tr.appendChild(imageTd);

          let nameP = document.createElement("p");
          nameP.innerHTML = item["name"];
          nameTd.appendChild(nameP);
          tr.appendChild(nameTd);

          let priceP = document.createElement("p");
          priceP.innerHTML = item["price"];
          priceTd.appendChild(priceP);
          tr.appendChild(priceTd);

          let decorationFactorP = document.createElement("p");
          decorationFactorP.innerHTML = item["decFactor"];
          decorationFactorTd.appendChild(decorationFactorP);
          tr.appendChild(decorationFactorTd);

          let tdCheckbox = document.createElement("td");
          let inputCheckbox = document.createElement("input");
          inputCheckbox.type = "checkbox";
          tdCheckbox.appendChild(inputCheckbox);

          tr.appendChild(tdCheckbox);
          table.getElementsByTagName("tbody")[0].appendChild(tr);
      }
  }

  function listPurchaseInfo() {
      let cartInfo = generateCartInfo();
      let boughtItemsInfoTextAreaElement = document.getElementsByTagName("textarea")[1];

      boughtItemsInfoTextAreaElement.value = cartInfo;
  }

  function generateCartInfo() {
      let boughtItems = document.getElementsByTagName("tr");
      boughtItems = Array.from(boughtItems).slice(1)
          .filter(x => x.getElementsByTagName("td")[4].getElementsByTagName("input")[0].checked === true);

      let cartInfo = "Bought furniture: ";

      let productNames = boughtItems.map(x => x.querySelector("td p").innerHTML).join(', ');
      cartInfo += productNames;
      cartInfo += "\nTotal price: ";

      let productsTotalPrice = boughtItems.map(x => +x.querySelectorAll("tr td p")[1].innerHTML)
          .reduce((x1, x2) => x1 + x2).toFixed(2);
      cartInfo += productsTotalPrice;
      cartInfo += "\nAverage decoration factor: ";

      let avgDecorationFactor = boughtItems.map(x => +x.querySelectorAll("tr td p")[2].innerHTML)
          .reduce((x1, x2) => x1 + x2) / boughtItems.length;
      cartInfo += avgDecorationFactor;

      return cartInfo;
  }
}