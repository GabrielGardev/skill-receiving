function attachEventsListeners() {
    let hoursInDay = 24;
    let minutesInDay = 1440;
    let secondsInDay = 86400;

    let $days = document.getElementById('days');
    let $hours = document.getElementById('hours');
    let $mins = document.getElementById('minutes');
    let $seconds = document.getElementById('seconds');

    let dayButton = document.getElementById('daysBtn');
    dayButton.addEventListener('click', function () {
        let days = $days.value;
        let hours = Number(days) * hoursInDay;
        let minutes = Number(days) * minutesInDay;
        let seconds = Number(days) * secondsInDay;

        $hours.value = hours;
        $mins.value = minutes;
        $seconds.value = seconds;
    });


    let hourButton = document.getElementById('hoursBtn');
    hourButton.addEventListener('click', function () {
        let hours = $hours.value;


        let days = Number(hours) / hoursInDay;
        let minutes = days * minutesInDay;
        let seconds = days * secondsInDay;

        $days.value = days;
        $mins.value = minutes;
        $seconds.value = seconds;
    });


    let minuteButton = document.getElementById('minutesBtn');
    minuteButton.addEventListener('click', function () {
        let minutes = $mins.value;

        let seconds = Number(minutes) * 60;
        let hours = Number(minutes) / 60;

        $days.value = hours / hoursInDay;
        $hours.value = hours;
        $seconds.value = seconds;
    });

    let secondsButton = document.getElementById('secondsBtn');
    secondsButton.addEventListener('click', function () {
        let seconds = $seconds.value;

        let minutes = seconds / 60;
        let hours = minutes / 60;
        let days = hours / 24;

        $days.value = days;
        $hours.value = hours;
        $mins.value = minutes;
    });
}