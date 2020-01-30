function validate() {
    let regex = /^([\w\-.]+)@([a-z]+)(\.[a-z]+)+$/;

    function changeStyle(event){
        if(!regex.test(event.target.value)){
            event.target.classList.add('error')
        }else{
            event.target.classList.remove('error')
        }
    }

    document.querySelector('#email')
            .addEventListener('change', changeStyle);
}