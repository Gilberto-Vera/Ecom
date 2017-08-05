package br.edu.tads.fsa.ifg.BEAN;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.edu.tads.fsa.ifg.MODEL.Usuario;

/**
 * Servlet Filter implementation class FiltroAdmin
 */
@WebFilter("/admin/*")
public class FiltroAdmin implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroAdmin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		if(usuario!=null&&usuario.isLogado()&&usuario.getTipo().equals(Usuario.ADMIN)){
			chain.doFilter(request, response);
			
		}else{
			request.setAttribute("msg","Você não está logado no sistema!");
			RequestDispatcher view = request.getRequestDispatcher("../loginAdm.xhtml");
			view.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
