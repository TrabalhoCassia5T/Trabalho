window.addEventListener('load', function () {
    buscar();
});

function buscar() {

    const endp = `http://localhost:8080/api/exemplar/buscar`;

    const token = localStorage.getItem('token');

    fetch(endp, {
        method: 'GET',
        headers: {
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
        const dataEntrada = new Date(exemplar.dataEntrada);
        const options = { day: '2-digit', month: '2-digit', year: 'numeric' };
        dataEntradaCell.textContent = dataEntrada.toLocaleDateString('pt-BR', options);
        tituloCell.textContent = exemplar.titulo.nome;

        row.appendChild(idCell);
        row.appendChild(statusCell);
        row.appendChild(dataEntradaCell);
        row.appendChild(tituloCell);

        tbody.appendChild(row);
    });
}

function buscarBtn() {
    // Obter os valores dos campos de entrada
    event.preventDefault();
    const dataInicio = document.getElementById('data').value;
    const dataFim = document.getElementById('data2').value;
    const titulo = document.getElementById('titulo').value;

    if(titulo != ""){
        if(dataInicio && dataFim){
            const url = `http://localhost:8080/api/exemplar/buscar_titulo_data/${titulo}/${dataInicio}/${dataFim}`;
            fetch(url, {
                method: 'GET',
                headers: {
                    'Origin': 'http://127.0.0.1:5500' 
                }
            })
            .then(response => response.json())
            .then(data => {
                updateTable(data);
            })
            .catch(error => console.error('Error:', error));
        }
        else{
            const url = `http://localhost:8080/api/exemplar/buscar_titulo/${titulo}`;
            fetch(url, {
                method: 'GET',
                headers: {
                    'Origin': 'http://127.0.0.1:5500' 
                }
            })
            .then(response => response.json())
            .then(data => {
                updateTable(data);
            })
            .catch(error => console.error('Error:', error));
        }
    } else{
        if(dataInicio && dataFim){
            const url = `http://localhost:8080/api/exemplar/buscar_data/${dataInicio}/${dataFim}`;
            fetch(url, {
                method: 'GET',
                headers: {
                    'Origin': 'http://127.0.0.1:5500' 
                }
            })
            .then(response => response.json())
            .then(data => {
                updateTable(data);
            })
            .catch(error => console.error('Error:', error));
        }
        else{
            const endp = `http://localhost:8080/api/exemplar/buscar`;

            const token = localStorage.getItem('token');
        
            fetch(endp, {
                method: 'GET',
                headers: {
                    'Origin': 'http://127.0.0.1:5500' 
                }
            })
            .then(response => response.json())
            .then(data => {
                updateTable(data);
            })
            .catch(error => console.error('Error:', error));
        }
    }
        
    
}