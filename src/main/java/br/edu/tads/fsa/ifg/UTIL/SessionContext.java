package br.edu.tads.fsa.ifg.UTIL;

import java.util.HashMap;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.edu.tads.fsa.ifg.MODEL.Usuario;

public class SessionContext {

	private static SessionContext instance;

	public static SessionContext getInstance() {
		if (instance == null) {
			instance = new SessionContext();
		}
		return instance;
	}

	private ExternalContext currentExternalContext() {
		if (FacesContext.getCurrentInstance() == null) {
			throw new RuntimeException("O FacesContext não pode ser chamado fora de uma requisição HTTP");
		} else {
			return FacesContext.getCurrentInstance().getExternalContext();
		}
	}

	@SuppressWarnings("unchecked")
	public HashMap<Integer, Integer> getCarrinho() {
		return (HashMap<Integer, Integer>) getAttribute("carrinho");
	}

	public void setCarrinho(HashMap<Integer, Integer> carrinho) {
		setAttribute("carrinho", carrinho);
	}

	public Usuario getUsuarioLogado() {
		return (Usuario) getAttribute("usuario");
	}

	public void setUsuarioLogado(Usuario usuario) {
		setAttribute("usuario", usuario);
	}

	public void encerrarSessao() {
		currentExternalContext().invalidateSession();
	}

	public Object getAttribute(String nome) {
		return currentExternalContext().getSessionMap().get(nome);
	}

	public void setAttribute(String nome, Object valor) {
		currentExternalContext().getSessionMap().put(nome, valor);
	}
}