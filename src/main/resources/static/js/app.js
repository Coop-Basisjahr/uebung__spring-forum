const baseUrl = window.location + "/api";
const rest = RestService(baseUrl);
const dom = DomController()

// Init on load
const username = getUsername()
dom.setUsername(username)
rest.get("/threads", dom.addThreads)

// On Form submit
document.getElementById("submit-form").addEventListener("click", (e) => {
    e.preventDefault();
    const titleField = document.getElementById("title");
    const textField = document.getElementById("text");
    const thread = {
        user: {
            username: username,
        },
        title: titleField.value,
        text: textField.value,
        comments: []
    }
    rest.post("/threads", thread, dom.addThread)
    titleField.value = ""
    textField.value = ""
})

// On Comment submit
document.getElementById("submit-comment").addEventListener("click", (e) => {
    e.preventDefault();
    const commentField = document.getElementById("comment-input");
    const comment = {
        user: {
            username: username
        },
        text: commentField.value
    }
    rest.post(`/threads/${encodeURIComponent(dom.getCurrentThread().title)}/comment`, comment, dom.updateComments)
    commentField.value = ""
})