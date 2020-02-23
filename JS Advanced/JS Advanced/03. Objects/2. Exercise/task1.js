function solve(data){
    return JSON.stringify(
        data.reduce((acc, heroString) => {
            let [name, level, items] = heroString.split(' / ');
            acc.push({ name, level: Number(level), items: items ? items.split(', ') : []})
            return acc;
        }, [])
    )
}