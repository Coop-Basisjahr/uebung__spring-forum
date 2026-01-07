const DomController = () => {
    let currentThread = null;

    const container = document.querySelector(".threads-container");
    const threadTemplate = document.getElementById("thread-template");
    const commentTemplate = document.getElementById("comment-template");
    const modal = document.getElementById("thread-modal");
    const commentSection = modal.querySelector(".comment-section");


    const openModal = thread => {
        currentThread = thread;
        modal.classList.remove("hidden");
        modal.querySelector(".thread-modal__title").textContent = thread.title;
        modal.querySelector(".thread-modal__user").textContent = thread.user.username;
        modal.querySelector(".thread-modal__text").textContent = thread.text;

        thread.comments.reverse().forEach(comment => {
            const commentElement = document.importNode(commentTemplate.content, true);
            commentElement.querySelector(".comment__user").textContent = comment.user.username;
            commentElement.querySelector(".comment__text").innerHTML += comment.text;
            commentSection.appendChild(commentElement)
        })
    }

    const closeModal = () => {
        currentThread = null;
        modal.classList.add("hidden");
        commentSection.innerHTML = "";
    }
    modal.querySelector(".modal-background").addEventListener("click", closeModal)


    const addThread = (thread) => {
        const element = document.importNode(threadTemplate.content, true);
        element.querySelector(".thread__title").textContent = thread.title;
        element.querySelector(".thread__text").textContent = thread.text;
        element.querySelector(".thread__user").textContent = thread.user.username;
        element.querySelector(".thread").addEventListener("click", () => openModal(thread))
        container.prepend(element);
    }

    const addThreads = (threads) => {
        threads.forEach(addThread)
    }

    const updateComments = thread => {
        closeModal();
        openModal(thread);
    }

    const setUsername = username => {
        document.querySelector(".username").textContent = username
    }

    return {
        addThread,
        addThreads,
        setUsername,
        updateComments,
        getCurrentThread: () => currentThread
    }
}