function solve() {
	function BinToDec(binary) {

		return parseInt(binary, 2).toString(10);
	}

	let input = document.getElementById('input').value;
	let initialSum = input.split('1').length - 1;
	let result = document.getElementById('resultOutput');

	sum = 0;
	while (true) {
		while (initialSum) {
			sum += initialSum % 10;
			initialSum = Math.floor(initialSum / 10);
		}
		if (sum < 10) {
			break;
		}
		initialSum = sum;
		sum = 0;
	}
	console.log(sum);
	input = input.substr(sum, input.length - 2 * sum);
	console.log(input);

	let output = '';
	for (let i = 0; i < input.length; i += 8) {
		if (BinToDec(input.substr(i, 8)) === 32 
			|| (BinToDec(input.substr(i, 8)) >= 65 && BinToDec(input.substr(i, 8)) <= 90)
			|| (BinToDec(input.substr(i, 8)) >= 97 && BinToDec(input.substr(i, 8)) <= 122))
			output += String.fromCharCode(BinToDec(input.substr(i, 8)));
	}
	result.innerHTML = output;
}