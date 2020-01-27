function solve() {
  function clickEvent() {
      let textElement = this.parentNode.children[1];
      let text = textElement.innerHTML;
      let number = text.match(/\d+/gm)[0];
      text = text.replace(number, (+number + 1).toString());
      textElement.innerHTML = text;
  }
  //add event to links
  let linkElements = document.getElementsByTagName('a');

  for (let linkElement of linkElements){
      linkElement.addEventListener('click', clickEvent);
  }
}

