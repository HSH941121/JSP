package exUser_servlet.sevlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exUser_servlet.model.UserDAO;
import exUser_servlet.model.UserVO;
import exUser_servlet.util.SHA256Util;

/**
 * Servlet implementation class exUserInsertServlet
 */
@WebServlet("/exUserInsertServlet")
public class exUserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public exUserInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Users/user_insert.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserVO vo = new UserVO();
		vo.setName(request.getParameter("name"));
		vo.setName(request.getParameter("userid"));
		vo.setPass(SHA256Util.getEncSHA256(request.getParameter("passwd")));
		
		UserDAO DAO = UserDAO.getInstance();
		int row = DAO.userInsert(vo);
	}

}
