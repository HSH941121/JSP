package service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import service.Action;

public class BoardDeleteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String pass = request.getParameter("pass");
		
		BoardDAO dao = BoardDAO.getInstance();
		int row = dao.boardDelete(idx,pass);
		
		request.setAttribute("page", page);
		request.setAttribute("row", row);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Board/board_delete_pro.jsp");
		dispatcher.forward(request, response);
	}

}
