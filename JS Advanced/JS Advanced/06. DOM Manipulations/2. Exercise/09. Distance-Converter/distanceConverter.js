function attachEventsListeners() {
    let button = document.getElementById('convert');
    button.addEventListener('click', convert);

    let units = [1000, 1, 0.01, 0.001, 1609.34, 0.9144, 0.3048, 0.0254];

    function convert() {
        let input = document.getElementById('inputDistance').value;

        let number = Number(input);
        let inputUnit = document.getElementById('inputUnits').selectedIndex;
        let outputUnit = document.getElementById('outputUnits').selectedIndex;

        let inValue = number * units[inputUnit];
        document.getElementById('outputDistance').value = inValue / units[outputUnit];
    }
}