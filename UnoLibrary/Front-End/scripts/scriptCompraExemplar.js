async function buscar() 
{
  
  if (document.getElementById("nome").value !== "" && document.getElementById("genero").value !== "" && document.getElementById("edicao").value !== "") 
  {
    
      try {
          event.preventDefault();
          const data = await buscaTodos();
          let ac = "";
          fetch("http://localhost:8080/api/verificar-login", { method: 'post', body: dados })

          for (let res of data) {
              ac += `<tr><td>${res.id}</td> <td>${res.nome}</td>
              <td>${res.cnpj}</td> <td>${res.telefone}</td></tr>`;
          }

          var TableBody = document.getElementById("tb");
          TableBody.innerHTML = ac;
          document.querySelector('.quantidade-container').style.display = 'block';


      } catch (error) {
          console.error('Ocorreu um erro:', error);
      }
  }
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


window.addEventListener('load', async function() {
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

function navegarParaOutraPagina() {
  // Adicione aqui o código para redirecionar para a outra página
  // Exemplo: window.location.href = "outra_pagina.html";
}