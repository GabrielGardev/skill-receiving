function solve(data, criteria) {
    let [key, value] = criteria.split('-')

    return JSON.parse(data)
        .filter(x => x[key] === value)
        .reduce((a, b, i) => {
            a.push(`${i}. ${b["first_name"]} ${b["last_name"]} - ${b["email"]}`)
            return a;
        }, []).join('\n')
}

console.log(
    solve(
        `[{
            "id": "1",
            "first_name": "Kaylee",
            "last_name": "Johnson",
            "email": "k0@cnn.com",
            "gender": "Female"
          }, {
            "id": "2",
            "first_name": "Kizzee",
            "last_name": "Johnson",
            "email": "kjost1@forbes.com",
            "gender": "Female"
          }, {
            "id": "3",
            "first_name": "Evanne",
            "last_name": "Maldin",
            "email": "emaldin2@hostgator.com",
            "gender": "Male"
          }, {
            "id": "4",
            "first_name": "Evanne",
            "last_name": "Johnson",
            "email": "ev2@hostgator.com",
            "gender": "Male"
          }]`,
         'all'
    )
)
