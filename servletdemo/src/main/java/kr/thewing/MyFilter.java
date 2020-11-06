package kr.thewing;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter  implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter");
        chain.doFilter(request,response); //Filter를 연결하도록 체이닝을 해준다.
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init");
    }

    @Override
    public void destroy() {
        System.out.println("Filter Destory");
    }
}
