package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest requests, ServletResponse responses, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入了字符编码过滤器===========================");
        //FilterChain：链
        /*过滤中的所有代码，在过滤特定请求的时候会执行
         * 必须让过滤器继续运行，因为可能还有其他过滤器*/
        requests.setCharacterEncoding("utf-8");
        responses.setCharacterEncoding("utf-8");
        responses.setContentType("text/html;charset=UTF-8");

        //filterChain是让我们的请求继续执行下去，如果不写，程序到这里就会被停止
        //匹配过滤器后每次请求都会执行一次
        chain.doFilter(requests, responses);


    }

    public void destroy() {

    }
}
