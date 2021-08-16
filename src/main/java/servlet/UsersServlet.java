package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import pojo.Users;
import service.UsersService;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsersService usersDao=new UsersService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				PrintWriter out=response.getWriter();
				String method=request.getParameter("method");
				if(method.equals("login")) {
					String nameString=request.getParameter("username");
					String pwdString=request.getParameter("password");
					Users bol=usersDao.login(nameString, pwdString);
					String joString=JSON.toJSONString(bol);
					out.print(joString);
				}else if (method.equals("seName")) {
					String nameString = request.getParameter("username");
					boolean bol = usersDao.seName(nameString);
					out.print("{\"message\":\""+bol+"\"}");
				}else if (method.equals("regs")) {
					String nameString=request.getParameter("username");
					String pwdString=request.getParameter("password");
					String phoneString=request.getParameter("phone");
					String nameString2=request.getParameter("name");
					Users users=new Users();
					users.setName(nameString);
					users.setPassword(pwdString);
					users.setTelephone(phoneString);
					users.setUsername(nameString2);
					boolean bol=usersDao.insertUser(users);
					out.print("{\"message\":\""+bol+"\"}");
				}
				
				out.flush();
				out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
