package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import pojo.House;
import service.HouseService;

/**
 * Servlet implementation class HouseServlet
 */
@WebServlet("/HouseServlet")
public class HouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HouseService service = new HouseService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HouseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		String method=request.getParameter("method");
		if (method.equals("select")) {
			List<House> list = service.select(getHouse(request,response));
			String jsonString = JSON.toJSONString(list);
			out.print(jsonString);
		}else if (method.equals("selectCount")) {
			int count=service.selectCount(getHouse(request,response))%4;
			if(count==0) {
				count=service.selectCount(getHouse(request,response))/4;
			}else {
				count=service.selectCount(getHouse(request,response))/4+1;
			}
			String jsonString="{\"count\":\""+count+"\"}";
			out.print(jsonString);
		}else if (method.equals("selectId")) {
			House house =service.selectId(Integer.valueOf(request.getParameter("id")));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dateString =format.format(house.getPubdate());
			house.setDateString(dateString);
			String jsonString = JSON.toJSONString(house);
			out.print(jsonString);
		}else if (method.equals("selectUserid")) {
			int userId=Integer.valueOf(request.getParameter("userId"));//获取用户id
			int index=Integer.valueOf(request.getParameter("index"));//获取当前页面
			House house=new House();
			house.setUser_id(userId);
			house.setIndex((index-1)*4);
			List<House> list=service.selectUserid(house);
			String jsonString=JSON.toJSONString(list);
			out.print(jsonString);
		}else if (method.equals("selectUseridCount")) {
			int id=Integer.valueOf(request.getParameter("userId"));
			int count=service.selectUserIdCount(id)%4;
			if(count==0) {
				count=service.selectUserIdCount(id)/4;
			}else {
				count=service.selectUserIdCount(id)/4+1;
			}
			String jsonString="{\"count\":\""+count+"\"}";
			out.print(jsonString);
		}else if (method.equals("delete")) {
			int id=Integer.valueOf(request.getParameter("id"));
			String jsonString="{\"dele\":\""+service.delete(id)+"\"}";
			out.print(jsonString);
		}else if (method.equals("insert")) {
			String jsonString="{\"insert\":\""+service.insert(getHouse1(request, response))+"\"}";
			out.print(jsonString);
		}else if (method.equals("update")) {
			House house=getHouse1(request, response);
			house.setId(Integer.valueOf(request.getParameter("id")));
			String jsonString="{\"update\":\""+service.update(house)+"\"}";
			out.print(jsonString);
		}
		
	}

	/**
	 * 添加和修改的获取值
	 * @param request
	 * @param response
	 * @return
	 */
	private House getHouse1(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("标题"+request.getParameter("title"));
		System.out.println("用户id"+request.getParameter("uid"));
		System.out.println("房型id"+request.getParameter("type_id"));
		System.out.println("面积"+request.getParameter("floorage"));
		System.out.println("价格"+request.getParameter("price"));
		System.out.println("街道id"+request.getParameter("street_id"));
		System.out.println("电话"+request.getParameter("contact"));
		System.out.println("描述"+request.getParameter("description"));
		System.out.println("日期"+request.getParameter("fcz"));
		House house=new House();
		house.setTitle(request.getParameter("title"));	
		house.setUser_id(Integer.valueOf(request.getParameter("uid")));
		house.setType_id(Integer.valueOf(request.getParameter("type_id")));
		house.setFloorage(Integer.valueOf(request.getParameter("floorage")));
		house.setPrice(Integer.valueOf(request.getParameter("price")));
		house.setStreet_id(Integer.valueOf(request.getParameter("street_id")));
		house.setContact(request.getParameter("contact"));
		house.setDescription(request.getParameter("description"));		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String dateString=request.getParameter("fcz");
		try {
			house.setPubdate(format.parse(dateString));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return house;
	}

	/**
	 * 获取值
	 * @param request
	 * @param response
	 * @return
	 */
	private House getHouse(HttpServletRequest request, HttpServletResponse response) {
		String titleString=request.getParameter("title");//标题
		int did=Integer.valueOf(request.getParameter("did"));//区县id
		int streid=Integer.valueOf(request.getParameter("street_id"));//街道id
		int tid=Integer.valueOf(request.getParameter("type_id"));//房型id
		int price=Integer.valueOf(request.getParameter("price"));//价格区间
		int flor=Integer.valueOf(request.getParameter("floorage"));//面积区间
		int index=Integer.valueOf(request.getParameter("index"));//获取当前页面
		House house=new House();
		house.setTitle(titleString);
		house.setDid(did);
		house.setStreet_id(streid);
		house.setType_id(tid);
		house.setPrice(price);
		house.setFloorage(flor);
		house.setIndex((index-1)*4);
		return house;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
