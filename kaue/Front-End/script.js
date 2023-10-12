function gravar() {
    if (document.getElementById("login").value !== "" && document.getElementById("senha").value !== "") {
      event.preventDefault();
      const dados = new FormData(document.getElementById("formlogin"));
      fetch("http://localhost:8080/api/verificar-login", { method: 'post', body: dados })
        .then(response => response.text())
        .then(mens => {
          if (mens === "Não existe Cadastro") {
            exibirAlerta(mens); // Exibe o alerta com a mensagem
          } 
          else 
          {
            alert("Login bem sucedido"); // Mensagem de sucesso
          }
        })
        .catch(error => document.getElementById("feedback").innerHTML = error);
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
    mensagemDiv1.textContent = mensagem;

    const mensagemDiv2 = document.createElement("p");
    mensagemDiv2.className = "alert-message";
    mensagemDiv2.textContent = "Deseja Cadastrar?";

    // Criar a div para os botões
    const botoesDiv = document.createElement("div");
    botoesDiv.className = "botoes-container";

    // Criar botões Sim e Não
    const botaoSim = document.createElement("button");
    botaoSim.textContent = "Sim";
    botaoSim.addEventListener("click", function () {
        // Redirecionar para "telaCadEmpresa.html" se o usuário clicar em "Sim"
        window.location.href = "telaCadEmpresa.html";
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

    // Adicionar mensagens e div de botões ao alerta
    alertDiv.appendChild(mensagemDiv1);
    alertDiv.appendChild(mensagemDiv2);
    alertDiv.appendChild(botoesDiv);

    // Adicionar o alerta ao corpo da página
    document.body.appendChild(alertDiv);
}








  
  
  
  
  
  
  
  
  
  
  
  
  
  