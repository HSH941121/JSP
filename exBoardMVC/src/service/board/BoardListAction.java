package service.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;
import service.Action;
import util.PageIndex;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("board_list.jsp");
		BoardDAO DAO = BoardDAO.getInstance();
		String sql = "", search = "",key="";
		int totcount = 0; //게시글 총 수
		
		//검색이 있을경우
		if(request.getParameter("key") != null) {
			key = request.getParameter("key");
			search = request.getParameter("search");
			sql = search + " like '%" + key + "%'";
			totcount = DAO.boardCount(sql);
		}
		//검색이 없을경우
		else {
			totcount = DAO.boardCount();
		}
		
		int nowpage = 1;
		int maxlist = 10;
		int totpage = 1;
		
		//총페이지수 계산
		if(totcount % maxlist == 0) {
			totpage = totcount / maxlist;
		}
		else {
			totpage = (totcount / maxlist) + 1;
		}
		
		//페이지번호가 입력될 경우
		if(request.getParameter("page") != null) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
		
		int startpage = (nowpage-1)*maxlist + 1;
		int endpage = nowpage * maxlist;
		int listcount = totcount -(nowpage-1)*maxlist;
		
		List<BoardVO> list = null;
		if(key.equals("")) {
			list = DAO.boardList(startpage, endpage);
		}
		else {
			list = DAO.boardList(startpage,endpage,sql);
		}
		
		String pageSkip = "";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, "Board?cmd=board_list", "");
		}
		else {
			pageSkip = PageIndex.pageListHan(nowpage, totpage, "Board?cmd=board_list", search, key);
		}
		
		request.setAttribute("page", nowpage);
		request.setAttribute("totcount", totcount);
		request.setAttribute("listcount", listcount);
		request.setAttribute("totpage", totpage);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Board/board_list.jsp");
		dispatcher.forward(request, response);
	}

}
