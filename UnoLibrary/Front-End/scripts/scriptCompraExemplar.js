function buscar() {
  console.log("oi");
  buscaTodos()
    .then(data => {

      console.log(data);
      //   let ac = "";
      // for (let res of data) 
      // {
      //   ac += `<tr><td>${res.id}</td> 
      //           <td>${res.nome}</td>
      //           </tr>`
      // }
    })
    .catch(error => console.error('Erro:', error));
}

async function buscaTodos() 
{
 
  try {
    const response = await fetch("http://localhost:8080/fornecedor/busca-fornecedores");
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
