function solve() {
   let textArea = document.getElementById("chat_input");
   let chatDiv = document.getElementById("chat_messages");

   function sentMessage() {
      let messageDiv = document.createElement('div')
      messageDiv.setAttribute('class', 'message my-message')
      messageDiv.innerHTML = textArea.value;
      chatDiv.appendChild(messageDiv);

      textArea.value = "";
   }

   let button = document.getElementById('send')
   button.addEventListener('click', sentMessage)
}