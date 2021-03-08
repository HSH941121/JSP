package service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;
import service.Action;

public class BoardModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

}
