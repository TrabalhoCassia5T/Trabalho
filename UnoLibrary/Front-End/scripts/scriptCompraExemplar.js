function searchFornecedores() {
  // Obter o valor de pesquisa
  var searchInput = document.getElementById("searchInput").value;

  // Fazer a requisição AJAX para o Spring
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function () {
      if (xhr.readyState == 4 && xhr.status == 200) {
          // Manipular a resposta do Spring (JSON, por exemplo)
          var fornecedores = JSON.parse(xhr.responseText);
          showFornecedoresTable(fornecedores);
      }
  };
  
  // Substitua a URL abaixo pelo endpoint real do Spring que retorna os fornecedores
  xhr.open("GET", "http://localhost:8080/api/fornecedores?search=" + searchInput, true);
  xhr.send();
}

function showFornecedoresTable(fornecedores) {
  // Criar uma tabela HTML com os fornecedores
  var table = "<table border='1'><tr><th>ID</th><th>Nome</th></tr>";

  for (var i = 0; i < fornecedores.length; i++) {
      table += "<tr><td>" + fornecedores[i].id + "</td><td>" + fornecedores[i].nome + "</td></tr>";
  }

  table += "</table>";

  // Exibir a tabela na página
  document.getElementById("resultTable").innerHTML = table;
}
