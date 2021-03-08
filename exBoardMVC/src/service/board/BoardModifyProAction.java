package service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;
import service.Action;

public class BoardModifyProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
