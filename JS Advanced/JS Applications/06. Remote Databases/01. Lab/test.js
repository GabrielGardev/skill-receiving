function test() {
    let email = "Gosho@abv.bg";
    let password = "123456"

    firebase.auth().createUserWithEmailAndPassword(email, password)
        .catch((error) => {
            // Handle Errors here.
            let errorCode = error.code;
            let errorMessage = error.message;

            console.log(errorCode, errorMessage)
            // ...
        });

    firebase.auth().signInWithEmailAndPassword(email, password)
        .catch((error) => {
            // Handle Errors here.
            let errorCode = error.code;
            let errorMessage = error.message;
            // ...
            console.log(errorCode, errorMessage)
        });

    firebase.auth().onAuthStateChanged((user) => {
        if (user) {
            // User is signed in.
            let displayName = user.displayName;
            let email = user.email;
            let emailVerified = user.emailVerified;
            let isAnonymous = user.isAnonymous;
            let uid = user.uid;

            console.log(displayName, email)
            // ...
        } else {
            // User is signed out.
            // ...
        }
    });

    firebase.auth().signOut()
    .then(() => {
        console.log('Sign-out successful.')
    })
    .catch((error) => {
        console.log('An error happened.')
    });


}

test()