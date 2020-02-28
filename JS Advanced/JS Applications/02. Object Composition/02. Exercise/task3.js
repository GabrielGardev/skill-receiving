function solve(input) {
    let obj = {
        model: input.model,
        engine: setEngine(input),
        carriage: setCarriage(input),
        wheels: setWheels(input)
    }
    
    function setEngine({ power }) {
        const engines = [
            { power: 90, volume: 1800 },
            { power: 120, volume: 2400 },
            { power: 200, volume: 3500 }
        ]
        return engines.find(e => power <= e.power)
    }
    function setCarriage({ carriage, color }) {
        return { type: carriage,  color};
    }
    function setWheels({ wheelsize }) {
        let arr = new Array(4);
        wheelsize % 2 === 0
            ? arr.fill(wheelsize - 1)
            : arr.fill(wheelsize)
            return arr;
    }
    return obj;
}

console.log(
    solve(
        {
            model: 'VW Golf II',
            power: 90,
            color: 'blue',
            carriage: 'hatchback',
            wheelsize: 14
        }
    ),
    solve(
        {
            model: 'Opel Vectra',
            power: 110,
            color: 'grey',
            carriage: 'coupe',
            wheelsize: 17
        }
    )
)