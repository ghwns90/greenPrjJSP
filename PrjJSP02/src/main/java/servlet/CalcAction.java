package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.Calc;

@WebServlet("/calcaction")
public class CalcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		//넘어오는 값 처리
		request.setCharacterEncoding("utf-8");
		String in_v1 = request.getParameter("v1");
		String in_v2 = request.getParameter("v2");
		String op    = request.getParameter("op");
		
		int v1       = Integer.parseInt(in_v1);
		int v2       = Integer.parseInt(in_v2);
		
		Calc c1      = new Calc();
		int v        = 0;
		
		switch(op) {
		case "+" : v = c1.add(v1, v2); break;
		case "-" : v = c1.subtract(v1, v2); break;
		case "*" : v = c1.multiply(v1, v2); break;
		case "/" : v = c1.divide(v1, v2); break;
		}
		
		// html 출력
		String fmt   = "";
		fmt         += "<h2>계산결과</h2>";
		fmt         += "<p> v1 : %d </p>";
		fmt         += "<p> v2 : %d </p>";
		fmt         += "<p> 결과 : %d </p>";
		String html  = String.format(fmt, v1, v2, v);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(html);
		out.flush();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		doGet(request, response);
	}

}
