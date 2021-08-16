package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import pojo.Street;
import service.StreetService;

/**
 * Servlet implementation class StreetServlet
 */
@WebServlet("/StreetServlet")
public class StreetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StreetService service = new StreetService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StreetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String method = request.getParameter("method");
		if (method.equals("selectId")) {
			System.out.println("ÇøÏØid"+request.getParameter("id"));
			int id=Integer.valueOf(request.getParameter("id"));
			List<Street> list=service.selectId(id);
			String jsonString=JSON.toJSONString(list);
			out.print(jsonString);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
