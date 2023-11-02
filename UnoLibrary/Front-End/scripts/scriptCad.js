function gravar1() {

    event.preventDefault();
    const dados = new FormData(document.getElementById("formlogin2"));
    fetch("http://localhost:8080/api/cadastro", { method: 'post', body: dados })
        .then(response => response.text())
        .then(mens => {
            if (mens === "ok") {
                alert("Cadastrou com Sucesso"); // Exibe o alerta com a mensagem
            }
            else {
                alert(mens); 
                console(mens);// Mensagem de sucesso
            }
        })
        .catch(error => error);

}