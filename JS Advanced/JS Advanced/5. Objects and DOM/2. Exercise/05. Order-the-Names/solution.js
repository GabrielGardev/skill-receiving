function solve() {
    let input = document.getElementsByTagName("input")[0];
    let button = document.querySelector("button");
    let ol = document.querySelector("ol");

    const capitalize = (s) => {
        if (typeof s !== 'string') return ''
        return s.charAt(0).toUpperCase() + s.slice(1)
      }

    button.addEventListener('click', () => {
        let word = input.value.toLowerCase();
        let position = word.charCodeAt(0) - 97;
        let currentNames = ol.children[position].innerHTML;

        let currentValues = []
        if(currentNames !== ""){
            currentValues = currentNames.split(', ')
        }
        currentValues.push(capitalize(word))
        ol.children[position].innerHTML = currentValues.join(', ')

        input.value = ''
    })
}