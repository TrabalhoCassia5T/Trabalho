window.addEventListener('load', function () {
    buscar();
});

function buscar() {

    const endp = `http://localhost:8080/api/exemplar/buscar`;

    const token = localStorage.getItem('token');

    fetch(endp, {
        method: 'GET',
        headers: {
            'Authorization': token,
            'Origin': 'http://127.0.0.1:5500' 
        }
    })
    .then(response => response.json())
    .then(data => {
        updateTable(data);
    })
    .catch(error => console.error('Error:', error));
}

function updateTable(exemplars) {
    const tbody = document.getElementById("tb");

    tbody.innerHTML = '';
    exemplars.forEach(exemplar => {
        const row = document.createElement("tr");
        const idCell = document.createElement("td");
        const statusCell = document.createElement("td");
        const dataEntradaCell = document.createElement("td");
        const tituloCell = document.createElement("td");

        idCell.textContent = exemplar.id;
        statusCell.textContent = exemplar.status;
        dataEntradaCell.textContent = exemplar.dataEntrada;
        tituloCell.textContent = exemplar.titulo;

        row.appendChild(idCell);
        row.appendChild(statusCell);
        row.appendChild(dataEntradaCell);
        row.appendChild(tituloCell);

        tbody.appendChild(row);
    });
}