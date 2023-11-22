function gravar() {
  if (document.getElementById("login").value !== "" && document.getElementById("senha").value !== "") {
    event.preventDefault();
    const dados = new FormData(document.getElementById("formlogin"));

    const usuario = dados.get("login");
    const senha = dados.get("senha");
    
    const endp = `http://localhost:8080/security/login/${usuario}/${senha}`;

    const token = localStorage.getItem('token');
    localStorage.setItem('redirectUrl', '../Front-End/views/home/index.html');

    fetch(endp, { method: 'GET', 
        headers: {
          'Authorization': token
        }
      })
      .then(response => response.text())
      .then(token => {
        localStorage.setItem('token', token);
        
        const redirectUrl = localStorage.getItem('redirectUrl');
        window.location.href = redirectUrl;
      })
      .catch(error => document.getElementById("feedback").innerHTML = error);
  }
}
