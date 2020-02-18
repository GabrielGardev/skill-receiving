class Forum {
    constructor() {
        this._users = [];
        this._questions = [];
        this._id = 1;
        this._loggedUsers = [];
    }

    register(username, password, repeatPassword, email) {
        if (!username || !password || !repeatPassword || !email) {
            throw new Error("Input can not be empty");
        }

        if (password !== repeatPassword) {
            throw new Error("Passwords do not match");
        }

        if (this._users.find(x => x.username === username) || this._users.find(x => x.email === email)) {
            throw new Error("This user already exists!");
        }

        this._users.push({
            username,
            password,
            email
        })
        return `${username} with ${email} was registered successfully!`
    }

    login(username, password) {
        let user = this._users.find(x => x.username === username);

        if (!user) {
            throw new Error("There is no such user");
        }

        if (user.password === password) {
            this._loggedUsers.push(user);
            return "Hello! You have logged in successfully";
        }
    }

    logout(username, password) {
        let user = this._users.find(x => x.username === username);

        if (!user) {
            throw new Error("There is no such user");
        }

        if (user.password === password) {
            let userIndex = this._users.indexOf(user);
            this._loggedUsers.splice(userIndex, 1);
            return "You have logged out successfully";
        }
    }

    postQuestion(username, question) {
        let user = this._users.find(x => x.username === username);
        let userLoggedIn = this._loggedUsers.includes(user);

        if (!user || !userLoggedIn) {
            throw new Error("You should be logged in to post questions");
        }

        if (question === "") {
            throw new Error("Invalid question");
        }

        this._questions.push({
            id: this._id++,
            username,
            question,
            answers: []
        });

        return "Your question has been posted successfully";
    }

    postAnswer(username, questionId, answer) {
        let user = this._users.find(x => x.username === username);
        let userLoggedIn = this._loggedUsers.includes(user);

        if (!user || !userLoggedIn) {
            throw new Error("You should be logged in to post answers");
        }

        if (answer === "") {
            throw new Error("Invalid answer");
        };

        let currentQuestion = this._questions.find(x => x.id === questionId);
        if (!currentQuestion) {
            throw new Error("There is no such question");
        };

        currentQuestion.answers.push({
            username,
            answer
        });

        return "Your answer has been posted successfully";
    }

    showQuestions() {
        return this._questions.reduce((acc, b) => {
            acc += `Question ${b.id} by ${b.username}: ${b.question}\n`
            acc += b.answers.reduce((a, v) => {
                a += `---${v.username}: ${v.answer}\n`;
                return a;
            }, '')
            return acc;
        }, '').trim();
    }
}