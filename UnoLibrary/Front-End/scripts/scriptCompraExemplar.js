function compraExemplar()
{
    event.preventDefault();
    const dados = new FormData(document.getElementById("pesquisa"));
    fetch("http://localhost:8080/fornecedor/busca-fornecedor", { method: 'post', body: dados })
        .then(response => response.text())
        .then(mens => {
          if (mens === "Não existe fornecedor" ) 
          {
            alert("Não possui fornecedor");
            
          } 
          else 
          {
            createTable(response)
          }
        })
        .catch(error => document.getElementById("feedback").innerHTML = error);
}

function createTable(responseData) {
    var nomes = responseData.nomes;

    var table = document.createElement('table');

    var headerRow = table.insertRow(0);
    var headerCell = headerRow.insertCell(0);
    headerCell.textContent = 'Nome';
    var radioCell = headerRow.insertCell(1);
    radioCell.textContent = 'Selecionar';

    for (var i = 0; i < nomes.length; i++) {
      var nome = nomes[i];

      var row = table.insertRow(i + 1);

      var cellNome = row.insertCell(0);
      cellNome.textContent = nome;

      var cellRadio = row.insertCell(1);
      var radioBtn = document.createElement('input');
      radioBtn.type = 'radio';
      radioBtn.name = 'nomeRadio';
      radioBtn.value = nome;
      cellRadio.appendChild(radioBtn);
    }

    var tableContainer = document.getElementById('table-container');
    tableContainer.innerHTML = ''; // Limpa o conteúdo anterior
    tableContainer.appendChild(table);
  }
