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
  
  
  window.addEventListener('load', async function() {
    try {
        const response = await fetch("http://localhost:8080/api/verificar");
  
        const data = await response.text();
        console.log(data)
        if(data === 'Não existe Cadastro') {
          window.location.href = "empresa/telaCadEmpresa.html" // MUDAR O CAMINHO
        }
    } catch (error) {
        console.error('Ocorreu um erro:', error);
        throw error;
    }
  })