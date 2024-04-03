package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet으로 서블릿 등록, URL 매핑
@WebServlet(name = "second", urlPatterns = "/second.do")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SecondServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println(request.getContextPath());
    	System.out.println(request.getServletPath());
    	System.out.println(request.getServerPort());
    	// -Djava.net.preferIPv4Stack=true
    	System.out.println(request.getRemoteAddr()); 
    	
    	response.setContentType("text/html;charset=UTF-8");
    	
    	PrintWriter out = response.getWriter();
    	
    	out.write("<html>");
    	out.write("<body>");
    	out.write("<h2>두 번째 서블릿이 반환한 내용</h2>");
    	out.write("</body>");
    	out.write("</html>");
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
}
