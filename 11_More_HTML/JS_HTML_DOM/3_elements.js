const headerElement = document.getElementsByTagName("h1");
console.log(headerElement[0].innerHTML +" "+ headerElement[1].innerHTML);

const classElement = document.getElementsByClassName("classA");
console.log(classElement[0].innerHTML +" "+ classElement[1].innerHTML);

document.getElementById("firstHeader").innerHTML = "now this text is modified";
document.getElementById("firstHeader").style.color = "orange";