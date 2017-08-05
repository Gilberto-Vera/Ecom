package br.edu.tads.fsa.ifg.BEAN;

import java.io.Serializable;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.tads.fsa.ifg.MODEL.Usuario;
import br.edu.tads.fsa.ifg.UTIL.SessionContext;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 1505746465054859860L;
	
	private Usuario usuario = null;
	
	public UsuarioBean(){
		usuario = new Usuario();
	}
	
	public void resetaUsuario(){
		usuario.setNome(null);
		usuario.setLogado(false);
		usuario.setTipo(null);
		usuario.setId(-1);
		usuario.setLogin(null);
		usuario.setSenha(null);
	}
	
	public void cadastrar(){
		
	}
	
	public boolean logado(){
		return usuario.isLogado();
	}
	
	public void logarCliente(){
		if(usuario.logar(Usuario.CLIENTE)){
			usuario.setLogado(true);
		}
	}
	
	public void logarAdmin(){
		if(usuario.logar(Usuario.ADMIN)){
			usuario.setLogado(true);
			SessionContext.getInstance().setUsuarioLogado(usuario);
			FacesContext context = FacesContext.getCurrentInstance();
			NavigationHandler navHandler = context.getApplication().getNavigationHandler();
			navHandler.handleNavigation(context, null, "homeAdmin");
		}
	}
		
	public void logout(){
		resetaUsuario();
	}
	
	public String logoutAdmin(){
		SessionContext.getInstance().encerrarSessao();
		return "loginAdmin";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
