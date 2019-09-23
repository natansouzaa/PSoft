URL = 'https://lab01-projsw-ufcg.herokuapp.com/api/disciplinas';
let $disciplinas = document.querySelector("#disciplinas");
let $createButton = document.querySelector("#criarDisciplina");
$createButton.addEventListener('click', cadastrarDisciplina);

function fetch_disciplinas() {

    fetch(URL)
    .then(response => response.json())
    .then(dados => {
        window.disciplinas = dados;
        inserirDisciplinas(dados);
    });
    
}

function inserirDisciplinas(d) {

    d.forEach(elemento => {
        let p = document.createElement("p");
        p.innerText = "Id:" +elemento.id + "\nNome: " + elemento.nome + "\nNota: " + elemento.nota;
        let d = document.createElement("button");
        d.innerText = "Remover Disciplina";
        d.addEventListener('click', _ => {
            removerDisciplina(elemento.id)
        });
        p.appendChild(document.createElement("p"));
        p.appendChild(d);
        $disciplinas.appendChild(p);
    });

}

function cadastrarDisciplina() {

    let nome = document.querySelector("#novaDisciplinaNome");
    let nota = document.querySelector("#novaDisciplinaNota");
    fetch(URL, {
        'method': 'POST',
        'body': `{"nome": "${nome.value}", "nota": ${nota.value}}`,
        'headers': {'Content-Type': 'application/json'}
    })
    .then(r => r.json())
    .then(d => {
        console.log("Disciplina cadastrada com sucesso!");
        disciplinas.push(d);
        fetch_disciplinas(disciplinas);
    });

}

function removerDisciplina(id) {

    fetch(URL + "/" + id, {
        'method': 'DELETE',
        'headers': {'Content-Type': 'application/json'}
    })
    .then(r => r.json())
    .then(d => {
        console.log("Disciplina removida com sucesso!");
        fetch_disciplinas(disciplinas);
    });

}

fetch_disciplinas();