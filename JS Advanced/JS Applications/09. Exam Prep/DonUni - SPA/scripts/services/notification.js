export function triggerSuccessNotification(message) {

    const notification = document.getElementById('successNotification');
    triggerNotification(notification, message);
}

export function triggerFailNotification(message) {

    const notification = document.getElementById('errorNotification');
    triggerNotification(notification, message);
}

export function triggerLoadingNotification() {

    const notification = document.getElementById('loadingNotification');
    triggerNotification(notification);
}

function triggerNotification(notification, message) {

    notification.innerText = message;
    notification.style.display = 'block'

    setTimeout(() => {
        notification.style.display = 'none'
    }, 5000)
}