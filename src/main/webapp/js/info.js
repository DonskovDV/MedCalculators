function start() {
    const pageTitle = window.location.search;
    let url;
    let text = document.getElementById("text");
    if (pageTitle === "?IMT") {
        url = "/calculator/IMT/info";
    }
    if (pageTitle === "?ApacheII") {
        url = "/calculator/ApacheII/info";
    }
    if (pageTitle === "?Has-Bled") {
        url = "/calculator/Has-Bled/info";
    }
    fetch(url)
        .then(response => response.json())
        .then(data => text.innerHTML = data.info)
        .catch(error => console.error(error));
}

start();

