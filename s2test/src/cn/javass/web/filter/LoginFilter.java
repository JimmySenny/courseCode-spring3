package cn.javass.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {
    
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("=================myFilter init" + this);
    }

    @Override
    public void destroy() {
        System.out.println("=================myFilter destroy" + this);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        
        //1.Ԥ����
        HttpServletRequest request = (HttpServletRequest) req;
        //2.�������е���һ������Filter��Servlet��
        //2.1ǰ�������жϣ���¼��飩
        boolean ok = true;
        Object o = request.getSession().getAttribute("user");
        if(o == null) {
            ok=false;
        }
        
        String path = request.getServletPath();
        System.out.println("===============" + path);
        if("/admin/login.jsp".equals(path)) {
            ok=true;
        }
        if("/admin/nologin.jsp".equals(path)) {
            ok=true;
        }
        if(!ok) {
            //������
            request.getRequestDispatcher("/admin/nologin.jsp").forward(req, resp);
            //��Ϊ�����ˣ������ٽ��к���
            return;
        }
        else {
            chain.doFilter(req, resp);    
        }
        //3.����
        
    }

}
