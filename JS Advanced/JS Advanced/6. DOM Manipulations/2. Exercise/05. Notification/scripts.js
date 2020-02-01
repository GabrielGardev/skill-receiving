function notify(message) {
    let div = document.getElementById('notification');
    div.textContent = message;
    div.style.display = 'block';
    setTimeout(function () {
        div.style.display = 'none';
    }, 2000);
}