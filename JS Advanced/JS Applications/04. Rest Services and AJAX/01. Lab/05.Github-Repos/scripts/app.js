function loadRepos() {
	const repos = document.querySelector("#repos");
	const username = document.querySelector("#username");

	const baseURL = `https://api.github.com/users/${username.value}/repos`;
	[repos.textContent, username.value] = ["", ""];

	const a = document.createElement("a");
	const li = document.createElement("li");

	fetch(baseURL)
		.then(res => {
			if (res.ok) {
				return res.json();
			} else {
				throw res;
			}
		})
		.then(data => displayRepos(data))
		.catch(err => handleError(err));

	function displayRepos(data) {
		data.forEach(repo => {
			const aClone = a.cloneNode();
			const liClone = li.cloneNode();

			aClone.href = repo.html_url;
			aClone.textContent = repo.full_name;

			liClone.appendChild(aClone);
			repos.appendChild(liClone);
		});
	}

	function handleError(err) {
		const liClone = li.cloneNode();
		liClone.textContent = `Error: ${err.status} (${err.statusText})`;
		repos.appendChild(liClone);
	}
}