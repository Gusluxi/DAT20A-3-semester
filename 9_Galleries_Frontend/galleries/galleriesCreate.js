const galleryDivElement = document.getElementById("create-gallery-form")
const createGalleryForm = `
    <div>
    <lable>Name</lable>
    <input id="input-name">
    <label>Owner</label>
    <input id="input-owner">
    <label>Square Feet</label>
    <input id="input-squareFeet">
    <lable>Location</lable>
    <input id="input-location">
    <button onclick="createNewGallery()">Submit</button>
    </div>
    <button onclick="hideGalleryForm()" >Gallery - </button>
    `

function showGalleryForm() {
    galleryDivElement.innerHTML = createGalleryForm;
    document.getElementById("expand-gallery-form").style.display = "none";
}

function hideGalleryForm() {
    galleryDivElement.innerHTML = "";
    document.getElementById("expand-gallery-form").style.display = "block";
}

function createNewGallery() {
    const newGallery = {
        name: document.getElementById("input-name").value,
        owner: document.getElementById("input-owner").value,
        squareFeet: document.getElementById("input-squareFeet").value,
        location: document.getElementById("input-location").value
    }



    fetch(baseURL+"/galleries", {
        method: "POST",
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(newGallery)
    })
        .then(response => {
            console.log(response);
            if (response.status === 200) {
                addGalleryToTable(newGallery);
            } else {
                console.log("Gallery not created", response.status);
            }
        })
        .catch(error => console.log("Network related error: " + error)); //Her kan man gøre noget der siger at serveren er nede
}

document.getElementById("expand-gallery-form").addEventListener("click",
    showGalleryForm);