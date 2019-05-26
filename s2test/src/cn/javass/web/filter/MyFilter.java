package cn.javass.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter implements Filter {
    
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
        System.out.println("===================Ԥ����ʼ");
        System.out.println("===================Ԥ�������");
        HttpServletRequest request = (HttpServletRequest) req;
        //2.�������е���һ������Filter��Servlet��
        //2.1ǰ�������жϣ���¼��飩
        boolean ok = true;
        if(!ok) {
            //������
//            request.getRequestDispatcher("/helloworld.jsp").forward(req, resp);
            //��Ϊ�����ˣ������ٽ��к���
            return;
        }
        else {
            chain.doFilter(req, resp);    
        }
        //3.����
        System.out.println("===================����ʼ");
        System.out.println("===================�������");
        
    }

}
