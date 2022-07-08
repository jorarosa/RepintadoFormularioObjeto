function cambiaVisionClaves() {
	var campoClave = document.getElementById("clave");
	var campoConfirmarClave = document.getElementById("confirmarClave");
	 
      if (campoClave.type=="password") {
          campoClave.type="text";
		  campoConfirmarClave.type="text";
      } else {
		  campoClave.type="password";
		  campoConfirmarClave.type="password";
      }
}

function deseleccionaRadio(campo) {
	var botonesRadio = document.getElementsByName(campo);
	for ( var i = 0; i < botonesRadio.length; i++){
		botonesRadio[i].checked = false;
	}
}

function deseleccionaTodosRadios() {
	var botonesRadio = document.querySelectorAll('input[type=radio]:checked');
	for ( var i = 0; i < botonesRadio.length; i++) {
		botonesRadio[i].checked = false;
	}
}

function conmutaListaCheckboxes(campo, estado) {
	var cajasChequeo = document.getElementsByName(campo);
	for (var i = 0; i < cajasChequeo.length; i++) {
		cajasChequeo[i].checked = estado;
	}
}

function conmutaTodoCheckbox(estado) {
	var cajasChequeo = document.querySelectorAll('input[type=checkbox]:checked');
	for (var i = 0; i < cajasChequeo.length; i++) {
		cajasChequeo[i].checked = estado;
	}
}

function conmutaSelectMultiple(campo, estado) {
	var campoSelect = document.getElementsByName(campo)[0];  // devuleve una lista de elementos llamados campo
	for ( var i = 0; i < campoSelect.options.length; i++){
		campoSelect.options[i].selected = estado;
	}
}

function conmutaTodoSelectMultiple(estado) {
	var selectsMultiples = document.querySelectorAll('select[multiple=multiple]');
	for (var i = 0; i < selectsMultiples.length; i++) {
		for (var j = 0; j < selectsMultiples[i].options.length; j++) {
			selectsMultiples[i].options[j].selected = estado;
		}
	}
}

function vaciaTodosTextareas() {
	var textAreas = document.querySelectorAll('textarea');
	for ( var i = 0; i < textAreas.length; i++){
		textAreas[i].value = '';
	}
}

function vaciaFormulario(formulario) {
  var camposFormulario = formulario.elements;
//  formulario.reset();

  for (i = 0; i < camposFormulario.length; i++) {
    tipoCampo = camposFormulario[i].type.toLowerCase();
    switch (tipoCampo) {
      case "text": camposFormulario[i].value = ''; break;
      case "password": camposFormulario[i].value = ''; break;
      default: break;
    }
	deseleccionaTodosRadios();
	conmutaTodoCheckbox('');
	conmutaTodoSelectMultiple('');
	vaciaTodosTextareas();
  }
}