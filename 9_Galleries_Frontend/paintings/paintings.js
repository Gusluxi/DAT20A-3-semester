const paintingsGalleryDiv = document.getElementById("painting-gallery");

fetch(baseURL + "/paintings")
    .then(response => response.json())
    .then(paintings => {
        paintings.map(createAPaintingCard);
    });

function createAPaintingCard(painting) {
    const paintingCardDiv = document.createElement("div");

    paintingsGalleryDiv.appendChild(paintingCardDiv);

    constructPaintingCard(paintingCardDiv, painting);
}

function constructPaintingCard(divElement, painting) {
    divElement.innerHTML = `
        <h2>${escapeHTML(painting.title)}</h2>
        <h3>${"$"+escapeHTML(painting.price.toString())}</h3>
        <h3>${escapeHTML(painting.genre)}</h3>
        <h3>${escapeHTML(painting.year.toString())}</h3>
    `;

}

function createPainting() {

}

document.getElementById("create-painting-button").addEventListener("click", createPainting);