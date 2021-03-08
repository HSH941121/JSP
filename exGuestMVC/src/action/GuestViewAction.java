package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GuestDAO;
import model.GuestVO;

public class GuestViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		GuestDAO DAO = GuestDAO.getInstance();
		GuestVO vo = new GuestVO();
		DAO.geustHits(idx);
		vo = DAO.guestSelect(idx);
		
		request.setAttribute("guest", vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Guest/guest_view.jsp");
		dispatcher.forward(request, response);

	}

}
