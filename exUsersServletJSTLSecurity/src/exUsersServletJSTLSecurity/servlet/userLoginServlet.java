package exUsersServletJSTLSecurity.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exUsersServletJSTLSecurity.model.UserDAO;
import exUsersServletJSTLSecurity.model.UserVO;

/**
 * Servlet implementation class userLoginServlet
 */
@WebServlet("/user_login")
public class userLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		
		
		//db����
		UserDAO dao = UserDAO.getInstance();
		int row = dao.userLogin(userid, passwd);
		
		request.setAttribute("row", row);
		if(row==1) {
			UserVO vo = dao.userSelect(userid);
			HttpSession session = request.getSession(); //���� ��ü ����
			//session.setAttribute("userid", userid); //���� �������
			session.setAttribute("userid", vo); //���� �������
			session.setMaxInactiveInterval(1800); // 30��
		}
		request.setAttribute("userid", userid);
		RequestDispatcher rd = request.getRequestDispatcher("Users/userlogin_ok.jsp");
		rd.forward(request, response);
	}

}
