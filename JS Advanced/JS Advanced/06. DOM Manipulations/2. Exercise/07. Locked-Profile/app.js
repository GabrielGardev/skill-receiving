function lockedProfile() {
    const buttons = document.getElementsByTagName('button');

    for(let button of buttons){
        button.addEventListener('click', showMore)
    }

    function showMore(e){
        //is it unlock
        let parent = e.target.parentNode;
        let showDiv = document.getElementById(parent.children[9].id)

        if(parent.children[2].checked !== true){
            if(e.target.textContent === "Hide it"){
                showDiv.style.display = 'none'
                e.target.textContent = "Show more"
            }else{
                showDiv.style.display = 'block'
                e.target.textContent = "Hide it"
            }
        }
    }
}