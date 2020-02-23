function solve(name, age, weight, heightCm) {
    let output = {
        name,
        personalInfo: {
            age,
            weight,
            height: heightCm
        }
    }
    let heightMt = heightCm / 100;
    let bmi = Math.round(weight / (heightMt ** 2));
    output['BMI'] = bmi;

    let status = '';
    if (bmi < 18.5) {
        status = 'underweight'
    } else if (bmi < 25) {
        status = 'normal'
    } else if (bmi < 30) {
        status = 'overweight'
    } else {
        status = 'obese'
        output.recommendation = 'admission required'
    }

    output.status = status

    return output
}