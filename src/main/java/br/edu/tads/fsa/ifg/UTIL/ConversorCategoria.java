package br.edu.tads.fsa.ifg.UTIL;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.tads.fsa.ifg.DAO.*;
import br.edu.tads.fsa.ifg.MODEL.*;

@FacesConverter(value="conversorCategoria",forClass = Categoria.class)
public class ConversorCategoria implements Converter {

	private Categoria categoria = new Categoria();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !"".equals(value)) {
			categoria = CategoriaDAOJPA.buscaCategoria(Integer.parseInt(value));
		}
		return categoria;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Categoria categoria = ((Categoria) value);
			return categoria.getId_categoria() == 0 ? null : categoria.getId_categoria()+"";
		}
		return null;
	}
}