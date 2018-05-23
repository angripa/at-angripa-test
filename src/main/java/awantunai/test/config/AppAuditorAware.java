package awantunai.test.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(Integer.MIN_VALUE)
public class AppAuditorAware extends OncePerRequestFilter implements AuditorAware<String> {

	private String defaultAuditor;

	@Override
	public String getCurrentAuditor() {
		return getDefaultAuditor();
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (null != request.getUserPrincipal()) {
			String authUsername = request.getUserPrincipal().getName();
			setDefaultAuditor(authUsername);
		} else {
			setDefaultAuditor("SYSTEM");
		}

		filterChain.doFilter(request, response);
	}

	public String getDefaultAuditor() {
		return defaultAuditor;
	}

	public void setDefaultAuditor(String defaultAuditor) {
		this.defaultAuditor = defaultAuditor;
	}

}
