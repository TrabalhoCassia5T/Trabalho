window.addEventListener('load', function () {
    buscar();
});

window.addEventListener('load', function () {
    verificarCampoPreenchido();
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
        const generoCell = document.createElement("td")

        idCell.textContent = exemplar.id;
        statusCell.textContent = exemplar.status;
        const dataEntrada = new Date(exemplar.dataEntrada);
        const options = { day: '2-digit', month: '2-digit', year: 'numeric' };
        dataEntradaCell.textContent = dataEntrada.toLocaleDateString('pt-BR', options);
        tituloCell.textContent = exemplar.titulo.nome;
        generoCell.textContent = exemplar.titulo.genero;
        

        row.appendChild(idCell);
        row.appendChild(statusCell);
        row.appendChild(dataEntradaCell);
        row.appendChild(tituloCell);
        row.appendChild(generoCell);

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

function Exclusao(){
    event.preventDefault();

    var codigoExemplar = document.getElementById("cod").value;

    const endp = `http://localhost:8080/api/exemplar/buscar_id/${codigoExemplar}`;

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
            alert('Exemplar não encontrado. Verifique o código e tente novamente.');
        }
    })
    .catch(error => console.error('Error:', error));
    
}

function preencherDiv(dado) {
    document.getElementById("lstatus").textContent = 'Status:'
    document.getElementById("status").textContent =  dado.status;
    document.getElementById("ldata").textContent = 'Data:'
    document.getElementById("data").textContent = formatarData(dado.dataEntrada);
    document.getElementById("ltitulo").textContent = 'Titulo:'
    document.getElementById("titulo").textContent = dado.titulo.nome;
    document.getElementById("btnSim").style.display = 'block';
    document.getElementById("btnNao").style.display = 'block';
}

function formatarData(data) {
    var options = { day: '2-digit', month: '2-digit', year: 'numeric' };
    return new Date(data).toLocaleDateString('pt-BR', options);
}

function limparFormulario() {
    document.getElementById("cod").value = '';
    document.getElementById("lstatus").textContent = ''
    document.getElementById("status").textContent =  '';
    document.getElementById("ldata").textContent = ''
    document.getElementById("data").textContent = '';
    document.getElementById("ltitulo").textContent = ''
    document.getElementById("titulo").textContent = '';
    document.getElementById("btnSim").style.display = 'none';
    document.getElementById("btnNao").style.display = 'none';
}

function ExclusaoTermina(){
    var codigoExemplar = document.getElementById("cod").value;

    const endp = `http://localhost:8080/api/exemplar/excluir/${codigoExemplar}`;

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


function cadastrarLivro() {
    event.preventDefault();
    var status = document.getElementById('status').value;
    var tituloNome = document.getElementById('titulo').value;
    var data = document.getElementById('data').value;

    if(status && tituloNome && data){
        const endp = `http://localhost:8080/api/exemplar/cadastrar/${status}/${data}/${tituloNome}`;

        fetch(endp, {
            method: 'POST',
            headers: {
                'Origin': 'http://127.0.0.1:5500' 
            },
        })
        .then(response => response.text())
        .then(msg => {
            alert(msg)
            if(msg==="Cadastrado com sucesso!"){
                limparFormularioCadastro()
            }
        })
        .catch(error => console.error('Erro ao cadastrar livro:', error));
    }
    else{
        alert('Complete o formulário!')
    }
    
}


function verificarCampoPreenchido() {
    var valorCampo = document.getElementById('titulo').value;

    // Verifica se o campo está preenchido
    if (valorCampo) {
        const url = `http://localhost:8080/api/titulo/buscar_titulo/${valorCampo}`;
            fetch(url, {
                method: 'GET',
                headers: {
                    'Origin': 'http://127.0.0.1:5500' 
                }
            })
            .then(response => response.json())
            .then(data => {
                updateTableTitulo(data);
            })
            .catch(error => console.error('Error:', error));
        
    } else {
        const endp = `http://localhost:8080/api/titulo/buscar`;

        const token = localStorage.getItem('token');

        fetch(endp, {
            method: 'GET',
            headers: {
                'Origin': 'http://127.0.0.1:5500' 
            }
        })
        .then(response => response.json())
        .then(data => {
            updateTableTitulo(data);
        })
        .catch(error => console.error('Error:', error));
    }
}

function updateTableTitulo(Titulo) {
    const tbody = document.getElementById("tbC");

    tbody.innerHTML = '';
    Titulo.forEach(titulo => {
        const row = document.createElement("tr");
        const idCell = document.createElement("td");
        const statusCell = document.createElement("td");
        const dataEntradaCell = document.createElement("td");
        const tituloCell = document.createElement("td");
        const generoCell = document.createElement("td")

        idCell.textContent = titulo.id;
        statusCell.textContent = titulo.nome;
        dataEntradaCell.textContent = titulo.qtde;
        tituloCell.textContent = titulo.edicao;
        generoCell.textContent = titulo.genero;
        

        row.appendChild(idCell);
        row.appendChild(statusCell);
        row.appendChild(dataEntradaCell);
        row.appendChild(tituloCell);
        row.appendChild(generoCell);

        tbody.appendChild(row);
    });
}

function limparFormularioCadastro(){
    document.getElementById('status').value = '';
    document.getElementById('titulo').value = '';
    document.getElementById('data').value = '';
}