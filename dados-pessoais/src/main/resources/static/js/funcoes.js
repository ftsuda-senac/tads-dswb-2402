function obterParametro(paramName) {  
  const queryString = window.location.search;
  const urlParams = new URLSearchParams(queryString);
  const paramValue = urlParams.get(paramName);
  return paramValue;
}

function mostrarMensagem(tipo, mensagem) {
  const elAlerta = document.getElementById('alerta');
  elAlerta.classList.add('d-none');
  elAlerta.classList.remove('alert-success', 'alert-error', 'alert-info');

  let classAlerta;
  switch (tipo) {
    case 'sucesso':
      classAlerta = 'alert-success';
      break;
    case 'erro':
      classAlerta = 'alert-error';
      break;
    case 'info':
      classAlerta = 'alert-info';
      break;
  }
  elAlerta.classList.add(classAlerta);
  elAlerta.classList.remove('d-none');
  elAlerta.textContent = mensagem;
}

async function obterDados(url) {
  const httpResp = await fetch(url);
  if (!httpResp.ok) {
    return {
      sucesso: false,
      codigoErro: httpResp.status,
      mensagem: 'Erro ao buscar dados'
    };
  }
  const dados = await httpResp.json();
  return {
    sucesso: true,
    conteudo: dados
  }
}
