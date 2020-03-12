function attachEvents() {
    let loadBtn = document.getElementById('btnLoadPosts');
    let viewBtn = document.getElementById('btnViewPost');
    let postsSelectElement = document.getElementById('posts');
    let h1Element = document.getElementById('post-title');
    let postPElement = document.getElementById('post-body');
    let postsUlElement = document.getElementById('post-comments');

    let url = 'https://blog-apps-c12bf.firebaseio.com';

    loadBtn.addEventListener('click', loadPosts);

    function loadPosts() {
        fetch(url + '/posts.json')
            .then((response) => response.json())
            .then((data) => {
                let fragment = document.createDocumentFragment();

                for (const post in data) {
                    let optionElement = document.createElement('option');
                    optionElement.value = post;
                    optionElement.textContent = data[post].title;
                    fragment.appendChild(optionElement);
                }
                postsSelectElement.appendChild(fragment);
                viewBtn.addEventListener('click', viewPosts)
            });
    }

    function viewPosts() {
        postsUlElement.innerHTML = "";

        let postId = postsSelectElement.options[postsSelectElement.selectedIndex].value;
        let commentsId = '';
        fetch(`${url}/posts/${postId}.json`)
            .then((response) => response.json())
            .then((data) => {
                commentsId = data.id;
                let h1Text = data.title;
                let pText = data.body;
                h1Element.textContent = h1Text;
                postPElement.textContent = pText;
            });

        fetch(`${url}/comments.json`)
            .then((response) => response.json())
            .then((data) => {

                let fragment = document.createDocumentFragment();
                for (const comment in data) {
                    if (data[comment].postId === commentsId) {
                        let liItem = document.createElement('li');
                        liItem.textContent = data[comment].text;
                        fragment.appendChild(liItem);
                    }
                }
                postsUlElement.appendChild(fragment);
            })
    }
}

attachEvents();