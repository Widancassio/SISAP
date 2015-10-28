package br.com.sisap.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "usuario")
@RequestScoped
public class Usuario {

	private String login;
	private String senha;

	public String efetuarLogin() {
		if (login.equals(Enderecos.PEDAGOGO) && senha.equals(Enderecos.SENHA)) {
			return Enderecos.PAGINA_INICIAL_PEDAGOGO;
		} else if (login.equals(Enderecos.PROFESSOR)
				&& senha.equals(Enderecos.SENHA)) {
			return Enderecos.PAGINA_INICIAL_PROFESSOR;
		}
		return Enderecos.PAGINA_LOGIN;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}