function solution(command) {
    let totalScore = this.upvotes - this.downvotes;
    let totalVotes = this.upvotes + this.downvotes;

    let commands = {
        upvote: () => this.upvotes++,
        downvote: () => this.downvotes++,
        score: () => {
            let upVotes = this.upvotes;
            let downVotes = this.downvotes;


            if (totalVotes > 50) {
                let valueToAdd = Math.ceil(Math.max(upVotes, downVotes) * 0.25);
                upVotes += valueToAdd;
                downVotes += valueToAdd;
            }

            return [upVotes, downVotes, totalScore, getRating.call(this)];

            function getRating() {
                if (totalVotes < 10) {
                    return 'new';
                }
                if (this.upvotes > (this.upvotes + this.downvotes) * 0.66) {
                    return 'hot';
                } else if (totalScore >= 0 && (this.upvotes > 100 || this.downvotes > 100)) {
                    return 'controversial';
                } else if (this.upvotes < this.downvotes) {
                    return "unpopular";
                } else {
                    return 'new';
                }
            }
        }
    };


    return commands[command]();
}


let post = {
    id: '3',
    author: 'emil',
    content: 'wazaaaaa',
    upvotes: 100,
    downvotes: 100
};

solution.call(post, 'upvote');
solution.call(post, 'downvote');
let score = solution.call(post, 'score'); // [127, 127, 0, 'controversial']
for (let i = 0; i < 50; i++) {
    solution.call(post, 'downvote');
}       // (executed 50 times)}
score = solution.call(post, 'score');     // [139, 189, -50, 'unpopular']