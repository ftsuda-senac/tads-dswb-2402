
for (let i = 1; i <= 1000; i++) {
    let conteudo = (i % 2 === 0) ? `<p>Texto ${i}</p>` : `<p class="paragrafo-impar">Texto ${i}</p>`;
    document.getElementById('resultado').insertAdjacentHTML('beforeend', conteudo);
}
document.querySelectorAll('#resultado > p:nth-child(3n)').forEach(el => {
    el.insertAdjacentHTML('beforeend', '<span class="badge text-bg-primary">pin</span>');
});
document.querySelector('#resultado > p:first-child').style.color = 'red';
const json = `{
    "nome": "Fernando Tsuda",
    "email": "fernando.tsuda@sp.senac.br",
    "telefone": "(11) 99999-1234",
    "dataNascimento": "1982-10-20",
    "githubUrl": "https://github.com/ftsuda-senac",
    "linkedinUrl": "https://br.linkedin.com/in/ftsuda"
}`
let dados = JSON.parse(json);
document.getElementById('nome').textContent = dados.nome;
document.getElementById('email').textContent = dados.email;
document.getElementById('telefone').textContent = dados.telefone;
document.getElementById('dataNascimento').textContent = new Date(dados.dataNascimento).toLocaleDateString();
document.getElementById('linkedin').href = dados.linkedinUrl;
document.getElementById('linkedin').textContent = dados.linkedinUrl;
document.getElementById('github').href = dados.githubUrl;
document.getElementById('github').textContent = dados.githubUrl;
