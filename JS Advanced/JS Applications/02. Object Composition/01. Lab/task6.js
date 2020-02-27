function solve(inputList) {
    const carsList = {};

    const commandsList = {
        create: function ([name, inherits, parentName]) {
            if (!carsList[name]) {
                carsList[name] = {};
            }

            if (inherits && parentName) {
                carsList[name] = Object.create(carsList[parentName]);
            }
        },
        set: function ([name, key, value]) {
            carsList[name][key] = value;
        },
        print: function ([name]) {
            const propertiesList = [];

            for (const key in carsList[name]) {
                propertiesList.push(`${key}:${carsList[name][key]}`);
            }

            console.log(propertiesList.join(", "));
        }
    };

    inputList.forEach(element => {
        const paramsList = element.split(" ");
        const command = paramsList.shift();
        commandsList[command](paramsList);
    });
}

solve(
    ['create c1',
        'create c2 inherit c1',
        'set c1 color red',
        'set c2 model new',
        'print c1',
        'print c2']
)