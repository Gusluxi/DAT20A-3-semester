fetch(baseURL + "/artists")
    .then(response => response.json())
    .then(result => {
        result.map(createArtistCard);
    });

const artistsGalleryWrapper = document.getElementById("artists-gallery");

function createArtistCard(artist) {
    const artistElement = document.createElement("div");
    artistElement.innerHTML = `
    <div>${escapeHTML(artist.name)}</div>
    <img src="${artist.artistImage}"
    `

    artistsGalleryWrapper.appendChild(artistElement);
}

function createNewArtist() {
    const name = document.getElementById("create-artist-name").value;
    const age = document.getElementById("create-artist-age").value;
    const artistImage = document.getElementById("create-artist-image").value;
    const gender = document.getElementById("create-artist-gender").value;

    const newArtist = {
        name: name,
        age: age,
        artistImage: artistImage,
        gender: gender
    };

    fetch("http://localhost:8080/artists", {
        method: "POST",
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(newArtist)
    })
        .then(response => {
            console.log(response);
            if (response.status === 200) {
                createArtistCard(newArtist);
            } else {
                console.log("Artist not created", response.status);
            }
        })
        .catch(error => console.log("Network related error")); //Her kan man gøre noget der siger at serveren er nede
}


document.getElementById("create-artist-btn").addEventListener("click", createNewArtist);

