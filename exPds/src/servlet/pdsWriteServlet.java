package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.PdsDAO;
import model.PdsVO;

/**
 * Servlet implementation class pdsWriteServlet
 */
@WebServlet("/pds_write")
public class pdsWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pdsWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Pds/pds_write.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		ServletContext context = getServletContext();
		//파일 저장 경로
		String path = context.getRealPath("Pds/upload");
		String encType = "utf-8";
		int sizeLimit = 2*1024*1024; //파일 최대 용량 설정
		
		MultipartRequest multi = new MultipartRequest(request,path,sizeLimit,encType, new DefaultFileRenamePolicy());
		//파일 중복시 자동 이름 변경
		
		PdsVO vo = new PdsVO();
		vo.setName(multi.getParameter("name"));
		vo.setEmail(multi.getParameter("email"));
		vo.setSubject(multi.getParameter("subject"));
		vo.setContetns(multi.getParameter("contents"));
		vo.setPass(multi.getParameter("pass"));
		vo.setFilename(multi.getFilesystemName("filename"));
		
		PdsDAO DAO = PdsDAO.getInstance();
		
		int row = DAO.pdsWrite(vo);
		
		request.setAttribute("row", row);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Pds/pds_write_pro.jsp");
		dispatcher.forward(request, response);
	}

}
