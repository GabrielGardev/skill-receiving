function Spy(target, method){
    let original = target[method];

    let result = {
        count: 0
    }

    target[method] = function () {
        result.count++
        return original.apply(this, arguments);
    }

    return result;
}

let obj = {
    method:()=>"invoked"
}
let spy1 = Spy(obj,"method");

obj.method();
obj.method();
obj.method();

console.log(spy1) // { count: 3 }


let spy2 = Spy(console,"log");

console.log(spy2); // { count: 1 }
console.log(spy2); // { count: 2 }
console.log(spy2); // { count: 3 }