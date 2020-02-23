function attachGradientEvents() {
    let result = document.getElementById('result')
    let gradient = document.getElementById('gradient')

    function move(e) {
        let power = e.offsetX / (e.target.clientWidth - 1);
        power = Math.trunc(power * 100);

        result.textContent = power + "%";
    }

    gradient.addEventListener('mousemove', move)
}