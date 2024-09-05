"use strict"

window.onload = initPage;

function initPage() {
	let form = document.getElementById('form1');
	form.noValidate = true;
	form.addEventListener('submit', function(e) {
		let valid = processValidity(this);
		if (!valid) {
			e.preventDefault();
		}
	});
	let CardNumber = form.elements['IdCartao'];
	CardNumber.addEventListener('keyup', function(e) {
		CardNumber.value = mcc(CardNumber.value);
	});
}

function processValidity(form) {
	let valid;
	validateCardNumber(form);
	valid = applyValidity(form);
	return valid;
}

function validateCardNumber(form) {
	let CardNumber = form.elements['IdCartao'];
	if (password.value != confirmPassword.value) {
		password.setCustomValidity
			('Valores de senha e confirmação de senha diferentes.');
	} else {
		password.setCustomValidity('');
	}
}

function mcc(v) {
	v = v.replace(/\D/g, ""); // Permite apenas dígitos
	v = v.replace(/(\d{4})/g, "$1."); // Coloca um ponto a cada 4 caracteres

	return v;
}