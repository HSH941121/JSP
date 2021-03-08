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
 * Servlet implementation class BoardModifyServlet
 */
@WebServlet("/board_modify.do")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardDAO dao = BoardDAO.getInstance();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardVO vo = dao.boardSelect(idx);
		
		request.setAttribute("page", page);
		request.setAttribute("board", vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Board/board_modify.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		BoardVO vo = new BoardVO();
		BoardDAO dao = BoardDAO.getInstance();
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		vo.setPass(request.getParameter("pass"));
		vo.setEmail(request.getParameter("email"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		int row = dao.boardModify(vo);
		request.setAttribute("page", page);
		request.setAttribute("row", row);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Board/board_modify_pro.jsp");
		dispatcher.forward(request, response);
	}

}
