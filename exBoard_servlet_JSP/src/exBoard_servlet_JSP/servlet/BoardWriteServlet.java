package exBoard_servlet_JSP.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exBoard_servlet_JSP.model.BoardDAO;
import exBoard_servlet_JSP.model.BoardVO;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/board_write.do")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("page", page);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Board/board_write.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		BoardDAO DAO = BoardDAO.getInstance();
		BoardVO vo = new BoardVO();
		vo.setName(request.getParameter("name"));
		vo.setPass(request.getParameter("pass"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		int row = DAO.BoardWrite(vo);
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		
		//response.sendRedirect("guest_list?page="+page);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Board/board_write_pro.jsp");
		dispatcher.forward(request, response);
	}

}
