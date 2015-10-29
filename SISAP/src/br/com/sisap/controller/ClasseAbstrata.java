package br.com.sisap.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class ClasseAbstrata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5350743353241300596L;

	public void reportarMensagemDeErro(String detalhe) {
		reportarMensagem(true, detalhe);

	}

	public void reportarMensagemDeSucesso(String detalhe) {
		reportarMensagem(false, detalhe);
	}

	public void reportarMensagem(boolean isErro, String detalhe) {
		String tipo = "Sucesso!";
		Severity severity = FacesMessage.SEVERITY_INFO;
		if (isErro) {
			tipo = "Erro!";
			severity = FacesMessage.SEVERITY_ERROR;
			FacesContext.getCurrentInstance().validationFailed();
		}

		FacesMessage msg = new FacesMessage(severity, tipo, detalhe);

		Flash flash = FacesContext.getCurrentInstance().getExternalContext()
				.getFlash();
		flash.setKeepMessages(false);
		flash.setRedirect(true);
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

}
