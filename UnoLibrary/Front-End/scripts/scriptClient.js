function gravar() {

    event.preventDefault();
    const dados = new FormData(document.getElementById("formCadCliente"));
    dados.append("id", 0);
    fetch("http://localhost:8080/api/cadastro-cliente", { method: 'post', body: dados })
        .then(response => response.text())
        .then(mens => {
            if (mens === "ok") {
                exibirAlerta("Cliente cadastrado com sucesso !")
            }
            else {
                alert(mens);
                console(mens);
            }
        })
        .catch(error => error);

}

function limparForm() {
    document.getElementById("nome").value = "";
    document.getElementById("sobrenome").value = "";
    document.getElementById("cpfForm").value = "";
    document.getElementById("cpf").value = "";
    document.getElementById("dataNasc").value = "";
    document.getElementById("email").value = "";
    document.getElementById("telefone").value = "";
    document.getElementById("endereco").value = "";
    document.getElementById("uf").value = "";
    document.getElementById("cep").value = "";
    document.getElementById("cidade").value = "";
}

function gravarAlteracao() {

    event.preventDefault();
    const dados = new FormData(document.getElementById("formAltCliente"));
    dados.append("id", 0);
    fetch("http://localhost:8080/api/alterar-cliente", { method: 'put', body: dados })
        .then(response => response.text())
        .then(mens => {
            if (mens === "Cliente alterado") {
                exibirAlerta("Cliente alterado com sucesso !")
            }
            else {
                alert(mens);
                console(mens);
            }
        })
        .catch(error => error);
}


function buscar() {
    //verificar se tem filtro para saber qual busca sera chamada
    event.preventDefault();
    const nome = document.getElementById("nome").value;
    const cpf = document.getElementById("cpf").value;
    console.log(nome);
    console.log(cpf);
    if (nome !== null && nome !== undefined && nome !== "") { // busca pelo nome
        buscaNome(nome)
            .then(data => {
                console.log('Resultado da busca por nome:', data);
                let ac = "";
                for (let res of data) {
                    ac += `<tr><td>${res.id}</td> <td>${res.nome + " " + res.sobrenome}</td>
                    <td>${res.cpf}</td> <td>${res.email}</td>
                    <td>${res.telefone}</td>
                    <td>${res.endereco + "-" + res.cidade}</td></tr>`
                }
                var TableBody = document.getElementById("tb");
                TableBody.innerHTML = ac;
            })
            .catch(error => {
                console.error('Ocorreu um erro:', error);
            });
    }
    else {
        if (cpf !== null && cpf !== undefined && cpf !== "") { // busca pelo cpf
            buscaCpf(cpf)
                .then(data => {
                    console.log('Resultado da busca por cpf:', data);
                    let ac = "";
                    for (let res of data) {
                        ac += `<tr><td>${res.id}</td> <td>${res.nome + " " + res.sobrenome}</td>
                    <td>${res.cpf}</td> <td>${res.email}</td>
                    <td>${res.telefone}</td>
                    <td>${res.endereco + "-" + res.cidade}</td></tr>`
                    }
                    var TableBody = document.getElementById("tb");
                    TableBody.innerHTML = ac;
                })
                .catch(error => {
                    console.error('Ocorreu um erro:', error);
                });
        }
        else { // busca todos os clientes 
            buscaTodos()
                .then(data => {
                    console.log('Resultado da busca de todos:', data);
                    let ac = "";
                    for (let res of data) {
                        ac += `<tr><td>${res.id}</td> <td>${res.nome + " " + res.sobrenome}</td>
                    <td>${res.cpf}</td> <td>${res.email}</td>
                    <td>${res.telefone}</td>
                    <td>${res.endereco + "-" + res.cidade}</td></tr>`
                    }
                    var TableBody = document.getElementById("tb");
                    TableBody.innerHTML = ac;
                })
                .catch(error => {
                    console.error('Ocorreu um erro:', error);
                });
        }
    }
}

async function buscaCpf(cpf) {
    try {
        const response = await fetch(`http://localhost:8080/api/busca-cliente-cpf?cpf=${cpf}`);
        if (!response.ok) {
            throw new Error('Não foi possível obter os dados.');
        }
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Ocorreu um erro:', error);
        throw error;
    }
}

async function buscaNome(nome) {
    try {
        const response = await fetch(`http://localhost:8080/api/busca-cliente-nome?nome=${nome}`);
        if (!response.ok) {
            throw new Error('Não foi possível obter os dados.');
        }
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Ocorreu um erro:', error);
        throw error;
    }
}

async function buscaTodos() {
    try {
        const response = await fetch("http://localhost:8080/api/busca-clientes");
        if (!response.ok) {
            throw new Error('Não foi possível obter os dados.');
        }
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Ocorreu um erro:', error);
        throw error;
    }
}

function exibirAlerta(mensagem) {
    // Criar um div para o alerta
    const alertDiv = document.createElement("div");
    alertDiv.className = "alert-container";

    // Adicionar estas propriedades CSS para centralizar o alert
    alertDiv.style.display = "flex";
    alertDiv.style.flexDirection = "column"; // Alterado para exibir as mensagens em coluna
    alertDiv.style.justifyContent = "center";
    alertDiv.style.alignItems = "center";
    alertDiv.style.position = "fixed";
    alertDiv.style.top = "0";
    alertDiv.style.left = "0";
    alertDiv.style.width = "100%";
    alertDiv.style.height = "100%";
    alertDiv.style.backgroundColor = "rgba(0, 0, 0, 0.5)";
    alertDiv.style.zIndex = "9999";

    // Criar os elementos para as mensagens
    const mensagemDiv1 = document.createElement("p");
    mensagemDiv1.className = "alert-message";
    mensagemDiv1.style.color = "white"
    mensagemDiv1.textContent = mensagem;

    // Criar a div para os botões
    const div = document.createElement("div");
    div.className = "container";
    div.style.display = "flex";
    div.style.flexDirection = "column";
    div.style.justifyContent = "center";
    div.style.alignItems = "center";

    const botao = document.createElement("button");
    botao.textContent = "Ok";
    botao.addEventListener("click", function () {
        document.body.removeChild(alertDiv); // Remover o alerta
    });

    div.appendChild(mensagemDiv1);
    div.appendChild(botao);

    // Adicionar mensagens e div de botões ao alerta
    alertDiv.appendChild(div);

    // Adicionar o alerta ao corpo da página
    document.body.appendChild(alertDiv);
}

function BuscaAlteracao() {
    event.preventDefault();
    const cpf = document.getElementById("cpf").value;
    buscaCpf(cpf)
        .then(data => {
            console.log('Resultado da busca por cpf:', data);
            document.getElementById("nome").value = data[0].nome;
            document.getElementById("sobrenome").value = data[0].sobrenome;
            document.getElementById("cpfForm").value = data[0].cpf;
            document.getElementById("dataNasc").value = data[0].data_nasc;
            document.getElementById("email").value = data[0].email;
            document.getElementById("telefone").value = data[0].telefone;
            document.getElementById("endereco").value = data[0].endereco;
            document.getElementById("uf").value = data[0].estado;
            document.getElementById("cep").value = data[0].cep;
            document.getElementById("cidade").value = data[0].cidade;
        })
        .catch(error => {
            console.error('Ocorreu um erro:', error);
        });
}

function Exclusao() {
    event.preventDefault();
    const cpf = document.getElementById("cpf").value;

    buscaCpf(cpf)
        .then(data => {
            if (data[0] !== undefined) {
                exibirAlertaExclusao(`Certeza que deseja excluir o cliente ${data[0].nome} da sua 
            base de dados ?`, data)
            }
            else {
                alert(mens);
                console(mens);
            }
        })
}

function exclusaoConfirmada(data) {
    fetch(`http://localhost:8080/api/apagar-cliente/${data[0].id}`)
        .then(response => response.text())
        .then(mens => {
            if (mens === "ok") {
                exibirAlerta("Cliente excluido com sucesso !")
            }
            else {
                alert(mens);
                console(mens);
            }
        })
        .catch(error => error);
}

function exibirAlertaExclusao(mensagem, data) {
    // Criar um div para o alerta
    const alertDiv = document.createElement("div");
    alertDiv.className = "alert-container";

    // Adicionar estas propriedades CSS para centralizar o alert
    alertDiv.style.display = "flex";
    alertDiv.style.flexDirection = "column"; // Alterado para exibir as mensagens em coluna
    alertDiv.style.justifyContent = "center";
    alertDiv.style.alignItems = "center";
    alertDiv.style.position = "fixed";
    alertDiv.style.top = "0";
    alertDiv.style.left = "0";
    alertDiv.style.width = "100%";
    alertDiv.style.height = "100%";
    alertDiv.style.backgroundColor = "rgba(0, 0, 0, 0.5)";
    alertDiv.style.zIndex = "9999";

    // Criar os elementos para as mensagens
    const mensagemDiv1 = document.createElement("p");
    mensagemDiv1.className = "alert-message";
    mensagemDiv1.style.color = "white"
    mensagemDiv1.textContent = mensagem;

    // Criar a div para os botões
    const div = document.createElement("div");
    div.className = "container";
    div.style.display = "flex";
    div.style.flexDirection = "column";
    div.style.justifyContent = "center";
    div.style.alignItems = "center";

    const botoesDiv = document.createElement("div");
    botoesDiv.className = "botoes-container";

    // Criar botões Sim e Não
    const botaoSim = document.createElement("button");
    botaoSim.textContent = "Sim";
    botaoSim.addEventListener("click", function () {
        exclusaoConfirmada(data);
        document.body.removeChild(alertDiv); // Remover o alerta
    });

    const botaoNao = document.createElement("button");
    botaoNao.textContent = "Não";
    botaoNao.addEventListener("click", function () {
        document.body.removeChild(alertDiv); // Remover o alerta
    });

    // Adicionar botões à div de botões
    botoesDiv.appendChild(botaoSim);
    botoesDiv.appendChild(botaoNao);

    div.appendChild(mensagemDiv1);
    div.appendChild(botoesDiv);

    // Adicionar mensagens e div de botões ao alerta
    alertDiv.appendChild(div);

    // Adicionar o alerta ao corpo da página
    document.body.appendChild(alertDiv);
}