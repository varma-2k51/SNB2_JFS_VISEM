// Data for inventors: change image paths to your own images in the "images" folder
const inventors = {
    gosling: {
        photo: "images/gosling.jpg",
        text: "James Gosling created the Java programming language at Sun Microsystems in the early 1990s."
    },
    guido: {
        photo: "images/guido.jpg",
        text: "Guido van Rossum developed the Python programming language and released its first version in 1991."
    },
    ritchie: {
        photo: "images/ritchie.jpg",
        text: "Dennis Ritchie developed the C programming language at Bell Labs in the early 1970s."
    },
    bjarne: {
        photo: "images/bjarne.jpg",
        text: "Bjarne Stroustrup designed and implemented C++, an extension of C that adds object-oriented features."
    },
    eich: {
        photo: "images/eich.jpg",
        text: "Brendan Eich created JavaScript in 1995 while working at Netscape, enabling dynamic and interactive web pages."
    },
    lerdorf: {
        photo: "images/lerdorf.jpg",
        text: "Rasmus Lerdorf originally created PHP in 1994 as a set of CGI scripts to track visits to his website."
    },
    matsumoto: {
        photo: "images/matsumoto.jpg",
        text: "Yukihiro 'Matz' Matsumoto designed Ruby with a focus on programmer happiness and productivity."
    },
    hejlsberg: {
        photo: "images/hejlsberg.jpg",
        text: "Anders Hejlsberg is the chief architect of C#, developed by Microsoft as part of the .NET initiative."
    },
    hopper: {
        photo: "images/hopper.jpg",
        text: "Grace Hopper was a pioneer of computer programming and led the development of the COBOL language."
    },
    mccarthy: {
        photo: "images/mccarthy.jpg",
        text: "John McCarthy created Lisp and is recognized as one of the founders of the field of Artificial Intelligence."
    }
};

const selectEl = document.getElementById("inventorSelect");
const imgEl = document.getElementById("inventorPhoto");
const descEl = document.getElementById("inventorDesc");

selectEl.addEventListener("change", function () {
    const key = this.value;

    if (!key) {
        descEl.textContent = "Select an inventor from the list above to see their photo and details.";
        return;
    }

    const inv = inventors[key];
    imgEl.src = inv.photo;
    descEl.textContent = inv.text;
});
