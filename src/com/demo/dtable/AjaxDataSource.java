package com.demo.dtable;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxDataSource
 */
@WebServlet("/AjaxDataSource")
public class AjaxDataSource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxDataSource() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// add for AJAX
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		//{"data":[["a","b",...],[....],[.....]]}
		sb.append("{\"data\":[");
		for(int i=10;i<1000;i++){
			sb.append("[");
			sb.append("\"4123456"+i+"\",");
			sb.append("\"Name"+i+"\",");
			sb.append("\""+i+"\",");
			sb.append("\"abc"+i+"@email.com\"");
			sb.append("],");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append("]}");

		System.out.println("retJson:" + sb);
		out.println(sb.toString());
		out.flush();
		out.close();
	}

}
