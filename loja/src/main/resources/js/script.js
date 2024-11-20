   function cadastrarCategoria() {
        const categoria = {
            categoria_id: document.getElementById('categoria_id').value,
            nome: document.getElementById('nome').value,
            descricao: document.getElementById('descricao').value
        };

        fetch('http://localhost:8080/home/cadastrar-categorias', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(categoria)
        })
        .then(response => {
            if (response.ok) {
                alert('Categoria cadastrada com sucesso!');
                return response.json();
            } else {
                alert('Erro ao cadastrar categoria.');
            }
        })
        .catch(error => alert('Erro ao conectar ao servidor.'));
    }