window.addEventListener('load', function () {
    buscar();
});

window.addEventListener('load', function () {
    verificarCampoPreenchido();
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

function Cadastra() {
    event.preventDefault();
    var status = document.getElementById('desc').value;
    var tituloNome = document.getElementById('status').value;
    var data = document.getElementById('data').value;
    var id_exe = document.getElementById('id_exe').value;

    if(status && tituloNome && data && id_exe){
        const endp = `http://localhost:8080/api/baixa/cadastrar/${tituloNome}/${status}/${data}/${id_exe}`;

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
                limparFormularioCad();
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
        const url = `http://localhost:8080/api/exemplar/buscar_titulo/${valorCampo}`;
            fetch(url, {
                method: 'GET',
                headers: {
                    'Origin': 'http://127.0.0.1:5500' 
                }
            })
            .then(response => response.json())
            .then(data => {
                updateTableExemplar(data);
            })
            .catch(error => console.error('Error:', error));
        
    } else {
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
            updateTableExemplar(data);
        })
        .catch(error => console.error('Error:', error));
    }
}

function updateTableExemplar(Exemplar) {
    const tbody = document.getElementById("tbC");

    tbody.innerHTML = '';
    Exemplar.forEach(exemplar => {
        const row = document.createElement("tr");
        const idCell = document.createElement("td");
        const statusCell = document.createElement("td");
        const dataEntradaCell = document.createElement("td");
        const tituloCell = document.createElement("td");

        idCell.textContent = exemplar.id;
        statusCell.textContent = exemplar.status;
        const data = new Date(exemplar.dataEntrada);
        const options = { day: '2-digit', month: '2-digit', year: 'numeric' };
        dataEntradaCell.textContent = data.toLocaleDateString('pt-BR', options);
        tituloCell.textContent = exemplar.titulo.nome;
        

        row.appendChild(idCell);
        row.appendChild(statusCell);
        row.appendChild(dataEntradaCell);
        row.appendChild(tituloCell);

        tbody.appendChild(row);
    });
}

function limparFormularioCad() {
    document.getElementById('desc').value = '';
    document.getElementById('status').value = '';
    document.getElementById('data').value = '';
    document.getElementById('id_exe').value = '';
    document.getElementById('titulo').value = '';
}



function limparFormularioAlter(){
    document.getElementById('codigo').value ='';
    document.getElementById('motivo').value = 'Perda';
    document.getElementById('data').value = '';
    document.getElementById('desc').value = '';
    document.getElementById('exemplarid').value = '';
}

function BuscaAlteracao(){
    event.preventDefault();
    var codigo = document.getElementById("codigo").value;

    if(codigo != ""){
        const url = `http://localhost:8080/api/baixa/buscarId/${codigo}`;

        fetch(url, {
            method: 'GET',
            headers: {
                'Origin': 'http://127.0.0.1:5500'
            }
        })
        .then(response => {
            if(!response.ok){
                alert('Baixa nao cadastrado!')
            }
            return response.json();
        })
        .then(exemplar => {
            const dataFormatada = new Date(exemplar.data).toISOString().split('T')[0];
            document.getElementById('motivo').value = exemplar.motivo;
            document.getElementById('data').value =  dataFormatada;
            document.getElementById('desc').value =  exemplar.desc;
            document.getElementById('exemplarid').value = exemplar.exemplar.id;
        })
        .catch(error => {
            // Ocorreu um erro ou o exemplar não foi encontrado
            console.error('Erro:', error.message);
            console.log("errro 1")
        });
    }
}

function gravarAlteracao(){
    event.preventDefault();
    var cod = document.getElementById('codigo').value;
    var status = document.getElementById('motivo').value;
    var data = document.getElementById('data').value;
    var desc = document.getElementById('desc').value;
    var tituloid = document.getElementById('exemplarid').value;

    if(cod!='' && status!='' && data!='' && tituloid!='' && desc!=''){
        const url = `http://localhost:8080/api/baixa/alterar/${cod}/${status}/${desc}/${data}/${tituloid}`;
        fetch(url, {
            method: 'POST',
            headers: {
                'Origin': 'http://127.0.0.1:5500'
            }
        })
        .then(response => {
            return response.text();
        })
        .then(exemplar => {
            alert(exemplar)
            if(exemplar==="Alteracao realizada com sucesso!") limparFormularioAlter();
        })
        .catch(error => {
            // Ocorreu um erro ou o exemplar não foi encontrado
            console.error('Erro:', error.message);
            console.log("errro 1")
        });

    }
    else{
        alert('Complete Formulario')
    }
}
