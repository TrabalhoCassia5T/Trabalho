async function gravar() {
    event.preventDefault();
  
    const loginInput = document.getElementById("login").value;
    const senhaInput = document.getElementById("senha").value;
  
    if (loginInput !== "" && senhaInput !== "") {
        try {
            const token = await obterToken(loginInput, senhaInput);
            console.log('Token obtido:', token);
  
            validarToken(token);
  
            window.location.href = '../Front-End/views/home/index.html'
        } catch (error) {
            document.getElementById("feedback").innerHTML = `Erro: ${error.message}`;
        }
    }
}
  
async function obterToken(login, senha) {
    const endp = `http://localhost:8080/security/login/${login}/${senha}`;
  
    try {
        const response = await fetch(endp, {
            method: 'GET',
            headers: {
              'Content-Type': 'application/json',
            },
        });
  
        if (!response.ok) {
            throw new Error(`Erro na solicitação: ${response.statusText}`);
        }
  
        const token = await response.text();
        return token;
    } catch (error) {
        throw new Error(`Erro ao obter o token: ${error.message}`);
    }
}
  
  function validarToken(token) {
    const endp = 'http://localhost:8080/security/validar-token';
  
    fetch(endp, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        },
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Erro na validação do token: ${response.statusText}`);
        }
        return response.json();
    })
    .then(data => {
        console.log('Token válido:', data);
    })
    .catch(error => {
        console.error(`Erro ao validar o token: ${error.message}`);
    });
}
  