const characterGalleryDiv = document.getElementById("character-gallery")
let characters;
let filteredCharacters;

fetch("https://rickandmortyapi.com/api/character")
.then(response => response.json())
.then(result => {
    console.log(result);
    characters = result.results;
    filteredCharacters = characters;
    characters.map(character => createCharacterCard(character));
    // kan også være: characters.map(createCharacterCard);
});

function createCharacterCard(character) {
    const cardElement = document.createElement("div");

    cardElement.innerHTML = `
        <div>${escapeHTML(character.name)}</div>
        <div>${escapeHTML(character.status)}</div>
        <img src="${escapeHTML(character.image)}">
    `
    characterGalleryDiv.appendChild(cardElement);
}
function handleSearchName(event) {
    characterGalleryDiv.innerHTML = "";
    filteredCharacters.filter(character => character.name.toLowerCase().includes(event.target.value.toLowerCase())).map(createCharacterCard);
}

document.getElementById("name-search").addEventListener("input", handleSearchName);

document.getElementById("search-button").addEventListener("click", () => {
    const selectedStatus = document.getElementById("status-selection");
    console.log(selectedStatus);

    characterGalleryDiv.innerHTML = "";
    if (selectedStatus === "All") {
        filteredCharacters = characters.map(createCharacterCard);
    } else {
        filteredCharacters = characters.filter(character => character.status === selectedStatus).map(createCharacterCard);
    }
});
