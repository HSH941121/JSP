package service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;
import service.Action;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardDAO DAO = BoardDAO.getInstance();
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		//쿠키검사 및 생성
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int i = 0; i < cookies.length; i++) {
			info = cookies[i];
			if(info.getName().equals("Board" + idx)) {
				bool = true;
				break;
			}
		}
		
		String newValue = "" + System.currentTimeMillis();
		if(!bool) {
			DAO.boardHits(idx); //조회수 증가
			info = new Cookie("Board" + idx,newValue);
			info.setMaxAge(60*60);
			response.addCookie(info);
		}
		
		BoardVO vo = DAO.boardSelect(idx);
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		
		request.setAttribute("board", vo);
		request.setAttribute("page", page);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Board/board_view.jsp");
		dispatcher.forward(request, response);

	}

}
