fetch("https://pokeapi.co/apt/v2/pokemon")
.then(response => response.json())
.then(result => {
    console.log(result);
    result.result.map((character) => {
        console.log(character)
    })
})