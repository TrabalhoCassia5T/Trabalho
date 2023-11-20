function buscar() {
  event.preventDefault();
  buscaTodos()
    .then(data => {
      console.log('Resultado da busca de todos:', data[0].nome);
      let ac = "";
      for (let res of data) {
          ac += `<tr><td>${res.id}</td> <td>${res.nome}</td>
          <td>${res.cnpj}</td> <td>${res.telefone}</td></tr>`
      }
      var TableBody = document.getElementById("tb");
      TableBody.innerHTML = ac;
    })
    .catch(error => {
      console.error('Ocorreu um erro:', error);
    });
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
