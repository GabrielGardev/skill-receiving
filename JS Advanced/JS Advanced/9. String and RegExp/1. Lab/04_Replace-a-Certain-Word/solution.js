function solve() {
    let word = document.getElementById('word').value;
    let text = JSON.parse(document.getElementById('text').value);
    let result = document.getElementById('result');
    let wordToReplace = (String(text[0]).split(' ')[2]).toUpperCase();
    let replace = new RegExp(wordToReplace, 'gi');

    Replace(word, text, result, replace);

    function Replace(word, text, result, replace){
        
        for(let element of text){
            console.log(element);
            let current = element.replace(replace, word)
            let p = document.createElement('p');
            p.innerHTML = current;
            result.appendChild(p);
        }
    }
}