function encodeAndDecodeMessages() {
    let textAreas = document.getElementsByTagName('textarea');
    let sendArea = textAreas[0];
    let reciverArea = textAreas[1];

    let buttons = [...document.getElementsByTagName('button')];

    buttons[0].addEventListener('click', encode);
    buttons[1].addEventListener('click', decode);

    let encodedWord;
    function encode(){
        encodedWord = [...sendArea.value]
        .reduce((acc, b) => {
            acc += String.fromCharCode(b.charCodeAt(0) + 1);
            return acc
        }, '')
        reciverArea.value = encodedWord;
        sendArea.value = '';
    }

    function decode(){
        reciverArea.value = [...encodedWord]
        .reduce((acc, b) => {
            acc += String.fromCharCode(b.charCodeAt(0) - 1);
            return acc
        }, '');
    }
}