package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.GuestListAction;
import action.GuestViewAction;
import action.GuestWriteProAction;
import action.GuestWrtiteAction;

/**
 * Servlet implementation class GuestController
 */
@WebServlet("/Guest")
public class GuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//클라이언트 요청 받기
		String cmd = request.getParameter("cmd");
		System.out.println("요청 받음을 확인 : " + cmd);
		Action action = null;
		if(cmd.equals("guest_list")) {
			//리스트 수행
			action = new GuestListAction();
		}
		else if(cmd.equals("guest_write")) {
			//등록폼
			action = new GuestWrtiteAction();
		}
		else if(cmd.equals("guest_write_pro")) {
			//등록처리
			action = new GuestWriteProAction();
		}
		else if(cmd.equals("guest_view")) {
			action = new GuestViewAction();
		}
		action.execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
