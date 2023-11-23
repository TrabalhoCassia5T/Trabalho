window.addEventListener('load', function () {
    buscar();
});

function buscar() {

    const endp = `http://localhost:8080/api/baixa/buscar`;

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

function updateTable(baixas) {
    const tbody = document.getElementById("tb");

    tbody.innerHTML = '';

    baixas.forEach(baixa => {
        const row = document.createElement("tr");
        const idCell = document.createElement("td");
        const motivoCell = document.createElement("td");
        const descricaoCell = document.createElement("td");
        const dataCell = document.createElement("td");
        const exemplarCell = document.createElement("td");

        idCell.textContent = baixa.id;
        motivoCell.textContent = baixa.motivo;
        descricaoCell.textContent = baixa.desc;
        console.log(baixa.descricao)
        // Formatação da data (assumindo que 'data' é um campo Date)
        const data = new Date(baixa.data);
        const options = { day: '2-digit', month: '2-digit', year: 'numeric' };
        dataCell.textContent = data.toLocaleDateString('pt-BR', options);

        exemplarCell.textContent = baixa.exemplar.id;  // Ajuste conforme a estrutura do objeto baixa

        row.appendChild(idCell);
        row.appendChild(motivoCell);
        row.appendChild(descricaoCell);
        row.appendChild(dataCell);
        row.appendChild(exemplarCell);

        tbody.appendChild(row);
    });
}

function buscarBtn() {
    // Obter os valores dos campos de entrada
    event.preventDefault();
    const dataInicio = document.getElementById('data').value;
    const dataFim = document.getElementById('data2').value;
    const motivo = document.getElementById('motivo').value;

    if(motivo != "Todas"){
        if(dataInicio && dataFim){
            const url = `http://localhost:8080/api/baixa/buscar_motivo_data/${motivo}/${dataInicio}/${dataFim}`;
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
            const url = `http://localhost:8080/api/baixa/buscar_motivo/${motivo}`;
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
            const url = `http://localhost:8080/api/baixa/buscar_data/${dataInicio}/${dataFim}`;
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
            const endp = `http://localhost:8080/api/baixa/buscar`;

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

function Exclusao(){
    event.preventDefault();

    var codigoBaixa = document.getElementById("cod").value;

    const endp = `http://localhost:8080/api/baixa/buscar_id/${codigoBaixa}`;

    const token = localStorage.getItem('token');

    fetch(endp, {
        method: 'GET',
        headers: {
            'Origin': 'http://127.0.0.1:5500' 
        }
    })
    .then(response => response.json())
    .then(data => {
        if (data) {
            preencherDiv(data);
        } else {
            alert('Baixa não encontrado. Verifique o código e tente novamente.');
        }
    })
    .catch(error => console.error('Error:', error));
    
}

function preencherDiv(dado) {
    document.getElementById("lmotivo").textContent = 'Motivo:'
    document.getElementById("motivo").textContent =  dado.motivo;
    document.getElementById("ldesc").textContent = 'Descrição:'
    document.getElementById("desc").textContent = dado.desc;
    document.getElementById("ldata").textContent = 'Data:'
    document.getElementById("data").textContent = formatarData(dado.data);
    document.getElementById("lexemplar").textContent = 'Exemplar:'
    document.getElementById("exemplar").textContent = dado.exemplar.id;
    document.getElementById("btnSim").style.display = 'block';
    document.getElementById("btnNao").style.display = 'block';
}

function formatarData(data) {
    var options = { day: '2-digit', month: '2-digit', year: 'numeric' };
    return new Date(data).toLocaleDateString('pt-BR', options);
}

function limparFormulario() {
    document.getElementById("cod").value = '';
    document.getElementById("lmotivo").textContent = ''
    document.getElementById("motivo").textContent =  '';
    document.getElementById("ldesc").textContent = ''
    document.getElementById("desc").textContent = '';
    document.getElementById("ldata").textContent = ''
    document.getElementById("data").textContent = '';
    document.getElementById("lexemplar").textContent = ''
    document.getElementById("exemplar").textContent = '';
    document.getElementById("btnSim").style.display = 'none';
    document.getElementById("btnNao").style.display = 'none';
}

function ExclusaoTermina(){
    var codigoBaixa = document.getElementById("cod").value;

    const endp = `http://localhost:8080/api/baixa/excluir/${codigoBaixa}`;

    const token = localStorage.getItem('token');

    fetch(endp, {
        method: 'GET',
        headers: {
            'Origin': 'http://127.0.0.1:5500'
        }
    })
    .then(response => response.text())
    .then(mens => {
        alert(mens)
    })
    .catch(error => console.error('Error:', error));
    limparFormulario()
}