function solve() {
    let ul = document.getElementById('dropdown-ul');
    let dropdownBtn = document.getElementById('dropdown');
    let box = document.getElementById('box');


    dropdownBtn.addEventListener('click', drop);
    ul.addEventListener('click', color);

    function color(e){
        let color = e.target.textContent;

        box.style.backgroundColor = color;
        box.style.color = 'black';
    }

    function drop(){
        if (ul.style.display === "block") {
            ul.style.display = "none"
            box.style.backgroundColor = 'black';
            box.style.color = 'white';
        } else {
            ul.style.display = "block"
        }
    }  
}