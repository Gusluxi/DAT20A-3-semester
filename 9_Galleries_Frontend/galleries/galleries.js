const galleryDisplayElement = document.getElementById("gallery-display");

fetch(baseURL + "/galleries")
    .then(response => response.json())
    .then(galleries => {
        galleries.map(addGalleryToTable);
    });

function addGalleryToTable(gallery) {
    const galleryTRElement = document.createElement("tr");
    galleryTRElement.id = gallery.id;
    galleryDisplayElement.appendChild(galleryTRElement)
    constructGalleryTableRow(galleryTRElement, gallery)

}


function constructGalleryTableRow(galleryTableRow, gallery) {
    galleryTableRow.innerHTML = `

            <td>
            <a href="./gallery.html?galleryId=${gallery.id}">
                <p class="row-gallery-name">${escapeHTML(gallery.name)}</p>
            </a>p
            </td>
            <td>
                <p class="row-gallery-owner">${escapeHTML(gallery.owner)}</p>
            </td>
            <td>
                <p class="row-gallery-location">${escapeHTML(gallery.location)}</p>
            </td>
            <td>
                <p class="row-gallery-square-feet">${escapeHTML(gallery.squareFeet.toString())}</p>
            </td>
            <td>
                <button id="update-button-${gallery.id}">UPDATE</button>
            </td>
            <td>
                <button onclick="deleteGallery(${gallery.id})" >DELETE</button>
            </td>
            `;
    document.getElementById(`update-button-${gallery.id}`)
        .addEventListener("click", () => updateGallery(gallery));
}

function deleteGallery(galleryId) {
    console.log(galleryId);
    fetch(baseURL + "/galleries/" + galleryId, {
        method: 'DELETE',
    })
        .then(response => {
            if (response.status === 200) {
                document.getElementById(galleryId).remove();
            } else {
                console.log(response.status)
            }
        });
}


