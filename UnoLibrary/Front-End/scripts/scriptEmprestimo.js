function generateDate() {
    const today = new Date(); // Get the current date
    const nextWeek = new Date(today.getTime() + 7 * 24 * 60 * 60 * 1000); // Add 7 days in milliseconds
  
    const data = formatDate(nextWeek);
    console.log(data);
    document.getElementById("data_devolucao").value = data;
}

function formatDate(date) {
    const day = String(date.getDate()).padStart(2, '0');
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const year = date.getFullYear();
    return `${day}/${month}/${year}`;
}

function limpa(){
    document.getElementById("cpf_cliente").value = "";
    document.getElementById("cod_livro").value = "";
    document.getElementById("data_devolucao").value = "";
    document.getElementById("nome_cliente").value = "";
    document.getElementById("nome_livro").value = "";
    document.getElementById("status").value = "";
}

function gravar() {
    event.preventDefault();
    const dados = new FormData(document.getElementById("formEmprestimo"));
    dados.append("func_id", 1);
    dados.append("status", document.getElementById("status").value)
    fetch("http://localhost:8080/api/emprestimo/cadastrar", { method: 'post', body: dados })
        .then(response => response.text())
        .then(mens => {
            if (mens === "ok") {
                exibirAlerta("Emprestimo efetuado com sucesso !")
            }
            else {
                alert(mens);
                console(mens);
            }
        })
        .catch(error => error);
   
}

async function buscaCpf(cpf) {
    try {
        const response = await fetch(`http://localhost:8080/api/busca-cliente-cpf?cpf=${cpf}`);
        if (!response.ok) {
            alert("Cliente não encontrado");
        }
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Ocorreu um erro:', error);
        throw error;
    }
}

async function verificaCliente(){
    event.preventDefault();
    const cpf = document.getElementById("cpf_cliente").value;
    buscaCpf(cpf)
     .then(async data => {
        console.log(data)
        const response = await fetch(`http://localhost:8080/api/emprestimo/verifica/cliente?id=${data.id}`);
        console.log(response)
        if(!response.ok){
            alert("Cliente com pendências")
            document.getElementById("status").value = "NEGADO"
        }
        else {
            document.getElementById("nome_cliente").value = data.nome;
            document.getElementById("status").value = "LIBERADO"
        }
     })
     .catch(error => error);
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