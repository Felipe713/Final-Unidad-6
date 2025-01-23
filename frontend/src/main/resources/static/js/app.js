console.log("corriendo")
function showModal(e){

    const libroTitulo = e.getAttribute('data-bookName')
    const libroDescripcion = e.getAttribute('data-bookDescription')
    const libroIsbn = e.getAttribute('data-bookIsbn')

    document.getElementById('exampleModalLabel').textContent = libroTitulo
    document.querySelector('.modal-body #descripcion-section').textContent = `Descripción: ${libroDescripcion}`
    document.querySelector('.modal-body #isbn-section').innerHTML = `<strong>ISBN:</strong> ${libroIsbn}`

    const theModal = document.querySelector("#modalDetallea")
    const myModalAlternative = new bootstrap.Modal(theModal)

    myModalAlternative.show()
    console.log("El onclick funciona...")
    // return myModalAlternative
}