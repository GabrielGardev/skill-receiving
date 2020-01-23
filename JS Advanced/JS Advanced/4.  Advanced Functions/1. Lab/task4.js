function solution(){
    let str = ""

    return {
        append: (x) => str += x,
        removeStart: (x) => str = str.substring(+x),
        removeEnd: (x) => str = str.substring(0, str.length - +x),
        print: () => console.log(str)
    }
}

let secondZeroTest = solution();

secondZeroTest.append('123');
secondZeroTest.append('45');
secondZeroTest.removeStart(2);
secondZeroTest.removeEnd(1);
secondZeroTest.print();
