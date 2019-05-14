package filters;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SessaoMB;

@WebFilter(urlPatterns = { "/admin/*", "/login/*" })
public class ControleAcessoFilter implements Filter {

	@Inject
	protected SessaoMB sessao;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("entrando no filtro");
		if (!sessao.isLogado()) {
			redireciona("/../vendas/indexx.jsf", response);
			}
		
		chain.doFilter(request, response);
	
		}
	

	@Override
	public void destroy() {

	}

	private void redireciona(String url, ServletResponse response) throws IOException {
		HttpServletResponse res = (HttpServletResponse) response;
		res.sendRedirect(url);
	}
	
}
