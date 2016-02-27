package com.demo.dtable;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServerProcessing
 */
@WebServlet("/ServerProcessing")
public class ServerProcessing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerProcessing() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		System.out.println("获取到提交的参数如下：");
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()){
			String name = e.nextElement();
			//屏蔽列信息输出
			if(!name.startsWith("columns")){
				System.out.println(name + " =>["+request.getParameter(name)+"]");
			}
		}
		
		int length = Integer.parseInt(request.getParameter("length"));
		int start = Integer.parseInt(request.getParameter("start"));
		
		StringBuilder sb = new StringBuilder();
		//{"data":[["a","b",...],[....],[.....]]}
		/*
		 * "draw": 1,"recordsTotal": 57,"recordsFiltered": 57,
		 * */
		int total = 57;
		sb.append("{\"draw\": "+(request.getParameter("draw"))+",\"recordsTotal\": "+total+",\"recordsFiltered\": "+total+",\"data\":[");
		int count = 0,i = 0;
		while(count++<length){
			i = start + count;
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
