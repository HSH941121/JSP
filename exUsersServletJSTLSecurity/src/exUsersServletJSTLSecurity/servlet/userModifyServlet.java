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
import exUsersServletJSTLSecurity.util.SHA256Util;

/**
 * Servlet implementation class userModifyServlet
 */
@WebServlet("/user_modify")
public class userModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* 세션설정이 없을경우 
		String userid = request.getParameter("userid");
		UsersDAO dao = UsersDAO.getInstance();
		UsersVO vo = dao.userSelect(userid);
		request.setAttribute("user", vo);
		*/
		/*세션설정값을 이용하는 경우
		HttpSession session = request.getSession();
		UsersVO vo = (UsersVO)session.getAttribute("user");
		request.setAttribute("user", vo);
		*/
		
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_modify.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String newpasswd = SHA256Util.getEncSHA256(request.getParameter("newpasswd"));
		String tel = request.getParameter("tel");
		HttpSession session = request.getSession();
		UserVO vo = (UserVO)session.getAttribute("userid");
		vo.setTel(tel);
		vo.setPasswd(newpasswd);
		UserDAO dao = UserDAO.getInstance();
		int row = dao.userModify(vo);
		
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Users/user_modify_pro.jsp");
		rd.forward(request, response);
	}

}
