package br.edu.tads.fsa.ifg.MODEL;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.edu.tads.fsa.ifg.DAO.UsuarioDAOJPA;

@Entity
@Table (name="usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = -2193583360414619488L;

	@Id
	@GeneratedValue
	private int id_usuario;
	
	private String nome = "";
	
	private String login = "";
	
	private String senha = "";
	
	private String tipo = "";
	
	@Transient
	public static String ADMIN = "admin";
	@Transient
	public static String CLIENTE = "cliente";
	
	@Transient
	private boolean logado = false;
	
	public boolean isLogado() {
		return logado;
	}
	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	public int getId() {
		return id_usuario;
	}
	public void setId(int id) {
		this.id_usuario = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPapel() {
		return tipo;
	}
	public void setPapel(String tipo) {
		this.tipo = tipo;
	}
	
	public boolean logar(String papel){
		System.out.println(this);
		Usuario usuarioBD = UsuarioDAOJPA.buscaUsuarioLogin(this.getLogin());
		if(usuarioBD!=null){
			if(usuarioBD.getSenha().equals(this.getSenha()) && papel.equals(usuarioBD.getPapel())){
				this.setId(usuarioBD.getId());
				this.setNome(usuarioBD.getNome());
				this.setPapel(usuarioBD.getPapel());
				return true;
			}
		}
		return false;
	}
	
	

}
