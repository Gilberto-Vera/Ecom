package br.edu.tads.fsa.ifg.BEAN;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.tads.fsa.ifg.DAO.CategoriaDAOJPA;
import br.edu.tads.fsa.ifg.MODEL.Categoria;

@ManagedBean
@SessionScoped
public class CategoriaBean implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1654313513513511L;
	private Categoria categoria = new Categoria();
	private List<Categoria> categorias = null;
	private Categoria categoriaSelecionada;
	
	public void novoCadastroCategoria() {
		categoria = new Categoria();
	}
	
	public void cadastraCategoria() {
		CategoriaDAOJPA.cadastrarCategoria(categoria);
		FacesMessage mensagem = new FacesMessage("Categoria Cadastrada");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
	
	public void alteraCategoria() {
		CategoriaDAOJPA.alteraCategoria(categoriaSelecionada);
		FacesMessage mensagem = new FacesMessage("Categoria Alterada com Sucesso");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
	
	public void removeCategoria() {
		CategoriaDAOJPA.excluiCategoria(categoriaSelecionada.getId_categoria());
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		this.categorias = CategoriaDAOJPA.listaCategoria();
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria getCategoriaSelecionada() {
		return categoriaSelecionada;
	}

	public void setCategoriaSelecionada(Categoria categoriaSelecionada) {
		this.categoriaSelecionada = categoriaSelecionada;
	}

}
