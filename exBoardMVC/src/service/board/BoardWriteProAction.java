package service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;
import service.Action;

public class BoardWriteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
