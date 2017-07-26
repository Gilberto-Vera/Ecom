package br.edu.tads.fsa.ifg.MODEL;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="categoria")

public class Categoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 156103575010843185L;
	
	@Id
	@GeneratedValue
	private int id_categoria;
	private String nome;
	
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof Categoria))
			return false;
		Categoria other = (Categoria)obj;
		if(id_categoria == 0) {
			if(other.id_categoria != 0)
				return false;
		}else if(id_categoria!=other.id_categoria)
			return false;
		return true;
		
	}
	

}
