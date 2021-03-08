package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PdsDAO;

/**
 * Servlet implementation class pdsDeleteServlet
 */
@WebServlet("/pds_delete")
public class pdsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pdsDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Pds/pds_delete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String pass = request.getParameter("pass");
		PdsDAO DAO = PdsDAO.getInstance();
		String filename = DAO.getFilename(idx);
		int row = DAO.pdsDelete(idx, pass);
		
		if(row == 1) {
			ServletContext context = getServletContext();
			//파일 저장 경로
			String path = context.getRealPath("Pds/upload/");
			File file = new File(path+filename);
			if(file.exists()) {
				file.delete();
			}
		}
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Pds/pds_delete_pro.jsp");
		dispatcher.forward(request, response);
	}

}
