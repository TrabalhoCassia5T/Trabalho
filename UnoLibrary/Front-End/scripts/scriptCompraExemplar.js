
async function buscar() {
  event.preventDefault();
  try {
    const data = await buscaTodos();
    let ac = "";
    for (let res of data) {
      ac += `<tr><td>${res.id}</td> <td>${res.nome}</td>
              <td>${res.cnpj}</td> <td>${res.telefone}</td></tr>`;
    }
    var TableBody = document.getElementById("tb");
    TableBody.innerHTML = ac;
  } catch (error) {
    console.error('Ocorreu um erro:', error);
  }




async function buscaTodos() {
  try {
    const response = await fetch("http://localhost:8080/api/fornecedor/busca-fornecedores");
    console.log(response)
    if (!response.ok) {
      throw new Error('Não foi possível obter os dados.');
    }
    const data = await response.json();
    console.log(data)
    return data;
  } catch (error) {
    console.error('Ocorreu um erro:', error);
    throw error;
  }
}


window.addEventListener('load', async function () {
  try {
    const response = await fetch("http://localhost:8080/api/find-logo");

    const data = await response.text();
    console.log(data)
    const imagem = document.getElementById('image');

    // Define dinamicamente a URL da imagem
    const urlDaImagem = data;
    imagem.src = urlDaImagem;
  } catch (error) {
    console.error('Ocorreu um erro:', error);
    throw error;
  }
})

async function verificaLivro() {
  event.preventDefault();
  const nome = document.getElementById("nome").value;
  const edicao = document.getElementById("edicao").value;
  //const form = new FormData(document.getElementById("formCompraLivro"));
  //form.append("qtde",document.getElementById("quantidade"));
  const response = await fetch(`http://localhost:8080/api/itempedido/verifica-livro?nome=${nome}&edicao=${edicao}`);
  if (!response.ok)
    exibirAlerta("Livro não encontrado, deseja cadastrar?");
  else
    buscar();

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
  botao.textContent = "SIM";



  const botao2 = document.createElement("button");
  botao2.textContent = "NÃO";

  botao.addEventListener("click", function () {
    window.location.href = "Exemplar/telaCadExemplar.html"
    // envia para outra tela
  });
  botao2.addEventListener("click", function () {
    document.body.removeChild(alertDiv); // Remover o alerta
  });

  div.appendChild(mensagemDiv1);
  div.appendChild(botao);
  div.appendChild(botao2);

  // Adicionar mensagens e div de botões ao alerta
  alertDiv.appendChild(div);

  // Adicionar o alerta ao corpo da página
  document.body.appendChild(alertDiv);
}


 function salvarpedido() {
  event.preventDefault();
  const dados = new FormData(document.getElementById("formCompraLivro"));
  dados.append("quantidade", document.getElementById("quantidade").value);
  fetch("http://localhost:8080/api/itempedido/salvarpedido", { method: 'post', body: dados })
    .then(response => response.text())
    .then(mens => {
      if (mens === "Sucesso") {
        exibirAlerta2("Pedido feito com sucesso !")
        limparForm();
        limparTabela()
      }
      else {
        alert(mens);
        console(mens);
      }
    })
    .catch(error => error);

}
function exibirAlerta2(mensagem) {
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
  botao.textContent = "OK";





  botao.addEventListener("click", function () {
    document.body.removeChild(alertDiv);
    limparTabela()
    // envia para outra tela
  });


  div.appendChild(mensagemDiv1);
  div.appendChild(botao);


  // Adicionar mensagens e div de botões ao alerta
  alertDiv.appendChild(div);

  // Adicionar o alerta ao corpo da página
  document.body.appendChild(alertDiv);
}

function limparForm() {
  document.getElementById("nome").value = "";
  document.getElementById("edicao").value = "";
  document.getElementById("quantidade").value = "";
}
function limparTabela() {
  var TableBody = document.getElementById("tb");
  TableBody.innerHTML = ""; // Limpa o conteúdo da tabela
}
