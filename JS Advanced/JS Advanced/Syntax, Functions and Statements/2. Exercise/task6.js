function solve([speed, area]){
    let calculateOverTheLimit = (limit, speed) => {

        if (limit >= speed) {
            console.log();
            return;
        }

        let overLimit = speed - limit;

        if (overLimit <= 20) {
                console.log('speeding');
        }else if (overLimit <= 40){
                console.log('excessive speeding')
        }else if(overLimit > 40){
            console.log('reckless driving')
        }
    };

    switch(area) {
        case 'motorway':
            calculateOverTheLimit(130, speed)
        break;
        case 'interstate':
            calculateOverTheLimit(90, speed)

        break;
        case 'city':
            calculateOverTheLimit(50, speed)

        break;
        case 'residential':
            calculateOverTheLimit(20, speed)

        break;
        default:
            break;
    }
}

(solve([40, 'city']));