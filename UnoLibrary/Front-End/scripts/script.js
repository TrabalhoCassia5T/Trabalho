function gravar() {
    if (document.getElementById("login").value !== "" && document.getElementById("senha").value !== "") {
      event.preventDefault();
      const dados = new FormData(document.getElementById("formlogin"));
      fetch("http://localhost:8080/api/verificar-login", { method: 'post', body: dados })
        .then(response => response.text())
        .then(mens => {
          if (mens === "Não existe Cadastro" ) 
          {
            alert("Não possui cadastro");
            window.location.href = "empresa/telaCadEmpresa.html" // Exibe o alerta com a mensagem
          } 
          else 
          {
            window.location.href = "home/index.html"
          }
        })
        .catch(error => document.getElementById("feedback").innerHTML = error);
    }
  }







  
  
  
  
  
  
  
  
  
  
  
  
  
  