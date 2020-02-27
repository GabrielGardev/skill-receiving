function solve(input) {
    let inner = [];

    const actions = {
        add: element => {
            inner.push(element);
        },
        remove: element => {
            inner = inner.filter(x => x !== element);
        },
        print: () => {
            console.log(inner.join(","));
        }
    }

    input.forEach(tokens => {
        const [command, string] = tokens.split(/\s+/);
        actions[command](string);
    });
}


solve(
    ['add hello', 'add again', 'remove hello', 'add again', 'print']
)
