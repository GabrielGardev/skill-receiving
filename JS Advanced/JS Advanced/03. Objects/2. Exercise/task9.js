function getGladiatorStatistics(array) {
    let gladiators = new Map();

    for (const string of array) {
        if ("Ave Cesar" === string) {
            break
        }
        if (/[^\s]+\s+-> [^\s]+ ->\s+[0-9]+/.test(string)) {
            let [gladiator, technique, skill] = string.split(" -> ");
            addGladiators(skill, gladiator, technique);
        } else if (/[^\s]+ vs [^\s]+/.test(string)) {
            let [gladiatorOne, gladiatorTwo] = string.split(" vs ");
            gladiatorDuel(gladiatorOne, gladiatorTwo);
        }
    }

    Array.from(gladiators.keys())
        .sort((g1, g2) => {
            let index = getTotalSkills(g2) - getTotalSkills(g1);
            return index !== 0 ? index : g1.localeCompare(g2);
        })
        .forEach(gladiator => {
            console.log(`${gladiator}: ${getTotalSkills(gladiator)} skill`);
            Array.from(gladiators.get(gladiator).keys())
                .sort((item1, item2) => {
                    let index = gladiators.get(gladiator).get(item2) - gladiators.get(gladiator).get(item1);
                    return index !== 0 ? index : item1.localeCompare(item2);
                })
                .forEach(technique => {
                    console.log(`- ${technique} <!> ${gladiators.get(gladiator).get(technique)}`);
                });
        });


    function gladiatorDuel(gladiatorOne, gladiatorTwo) {
        if (gladiators.has(gladiatorOne) && gladiators.has(gladiatorTwo) && haveTechniqueInCommon(gladiatorOne, gladiatorTwo)) {
            let gladiatorOneSkills = getTotalSkills(gladiatorOne);
            let gladiatorTwoSkills = getTotalSkills(gladiatorTwo);

            if (gladiatorOneSkills > gladiatorTwoSkills) {
                gladiators.delete(gladiatorTwo);
            } else if (gladiatorOneSkills < gladiatorTwoSkills) {
                gladiators.delete(gladiatorOne);
            }
        }
    }

    function haveTechniqueInCommon(gladiatorOne, gladiatorTwo) {
        let gladiatorOneTechniques = Array.from(gladiators.get(gladiatorOne).keys());
        let gladiatorTwoTechniques = Array.from(gladiators.get(gladiatorTwo).keys());

        for (const technique of gladiatorOneTechniques) {
            if (gladiatorTwoTechniques.includes(technique)) {
                return true;
            }
        }
        return false;
    }

    function addGladiators(skill, gladiator, technique) {
        skill = Number(skill);
        if (!gladiators.has(gladiator)) {
            gladiators.set(gladiator, new Map())
        }
        if (!gladiators.get(gladiator).has(technique) || gladiators.get(gladiator).get(technique) < skill) {
            gladiators.get(gladiator).set(technique, skill);
        }
    }

    function getTotalSkills(gladiator) {
        return Array.from(gladiators.get(gladiator).values()).reduce((a, b) => a + b);
    }
}


getGladiatorStatistics(
    [
        "Pesho -> BattleCry -> 400",
        "Gosho -> PowerPunch -> 300",
        "Stamat -> Duck -> 200",
        "Stamat -> Tiger -> 250",
        "Ave Cesar",
    ]
);