function solve(data) {

    let specialSymbols = {
        '&': '&amp;',
        '<': '&lt;',
        '>': '&gt;',
        '\"': '&quot;',
        '\'': '&#39;'
    }

    function formatSpecialSymbols(text) {
        return text
            .split("&").join(specialSymbols["&"])
            .split("<").join(specialSymbols["<"])
            .split(">").join(specialSymbols[">"])
            .split("\"").join(specialSymbols["\""])
            .split("\'").join(specialSymbols["'"])
    }

    let result = [];

    result.push('<table>')
    result.push('  <tr><th>name</th><th>score</th></tr>')

    JSON.parse(data)
        .forEach(x => {
            result.push(`   <tr><td>${formatSpecialSymbols(x['name'])}</td><td>${x['score']}</td></tr>`)
        });

    result.push('</table>')

    return result.join('\n')
}

console.log(
    solve([
        '[{"name":"Pencho Penchev","score":0},{"name":"<script>alert(\\"Wrong!\\")</script>","score":1}]'
    ]))
