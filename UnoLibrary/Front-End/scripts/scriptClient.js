function gravar() {

    event.preventDefault();
    const dados = new FormData(document.getElementById("formCadCliente"));
    fetch("http://localhost:8080/api/cadastro-cliente", { method: 'post', body: dados })
        .then(response => response.text())
        .then(mens => {
            if (mens === "Cadastrou com Sucesso") {
                alert("Cliente cadastrado com sucesso !");
            }
            else {
                alert(mens);
                console(mens);
            }
        })
        .catch(error => error);

}