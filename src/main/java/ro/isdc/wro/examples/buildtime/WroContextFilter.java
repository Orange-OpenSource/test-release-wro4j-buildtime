package ro.isdc.wro.examples.buildtime;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.isdc.wro.config.Context;

/**
 * This filter is responsible for setting the {@link Context} to the current request cycle. This is required if you want
 * to use {@link ServletContextAttributeHelper} in order to access wro related attributes from within a tag or a
 * servlet. Usually this filter will be mapped to all requests:
 * 
 * <pre>
 *  <filter-mapping>
 *     <filter-name>wroContextFilter</filter-name>
 *     <url-pattern>/*</url-pattern>
 *  </filter-mapping>
 * 
 * </pre>
 * 
 * This will be in next wro4j release.
 */
public class WroContextFilter implements Filter {
	private FilterConfig filterConfig;

	public void init(final FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	/**
	 * {@inheritDoc}
	 */
	public final void doFilter(final ServletRequest req,
			final ServletResponse res, final FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) res;
		try {
			// add request, response & servletContext to thread local
			Context.set(Context.webContext(request, response, filterConfig));
			chain.doFilter(req, res);
		} finally {
			Context.unset();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void destroy() {
		Context.destroy();
	}
}