function gravar1() {

    event.preventDefault();
    const dados = new FormData(document.getElementById("formlogin2"));
    fetch("http://localhost:8080/api/cadastro", { method: 'post', body: dados })
        .then(response => response.text())
        .then(mens => {
            if (mens === "Cadastrou com Sucesso") {
                alert("Cadastrou com Sucesso"); // Exibe o alerta com a mensagem
            }
            else {
                alert(mens); // Mensagem de sucesso
            }
        })
        .catch(error => document.getElementById("feedback").innerHTML = error);

}