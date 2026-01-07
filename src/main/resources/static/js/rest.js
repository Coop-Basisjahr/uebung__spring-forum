const RestService = (baseUrl) => {
    const get = (path, onResponse = () => {}) => {
        fetch(baseUrl + path)
            .then(res => res.json())
            .then(onResponse)
    }

    const post = (path, body, onResponse = () => {}) => {
        fetch(baseUrl + path, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(body)
        })
            .then(res => res.json())
            .then(onResponse)
    }

    return {
        get,
        post
    }
}