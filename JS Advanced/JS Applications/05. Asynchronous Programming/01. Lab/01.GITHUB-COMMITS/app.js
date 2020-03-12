function loadCommits() {
    let username = document.getElementById('username').value;
    let repository = document.getElementById('repo').value;
    let ulElement = document.getElementById('commits');
    ulElement.innerHTML = '';

    let url = `https://api.github.com/repos/${username}/${repository}/commits`;

    fetch(url)
        .then(response => response.json()
            .then((data) => loadListItems(data))
            .catch(() => {
                let liElement = document.createElement('li');
                liElement.textContent = `Error: ${response.status} (${response.statusText})`;
                ulElement.appendChild(liElement);
            }));

    function loadListItems(data) {
        let fragment = document.createDocumentFragment();

        for (const item of data) {
            let name = item.commit.author.name;
            let message = item.commit.message;
            let liElement = document.createElement('li');
            liElement.textContent = `${name}: ${message}`;
            fragment.appendChild(liElement);
        }

        ulElement.appendChild(fragment);
    }
}