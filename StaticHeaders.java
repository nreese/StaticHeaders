import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class StaticHeaders implements Filter {
  private Map<String, String> staticParams = new HashMap<String, String>();

  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletResponse response = (HttpServletResponse) res;
    for (String paramName : staticParams.keySet()) {
      response.setHeader(paramName, staticParams.get(paramName));
    }
    chain.doFilter(req, res);
  }

  public void init(FilterConfig config) throws ServletException {
    Enumeration<String> params = config.getInitParameterNames();
    while (params.hasMoreElements()) {
      String name = params.nextElement();
      String value = config.getInitParameter(name);
      staticParams.put(name, value);
    }
  }

  public void destroy() {};
}