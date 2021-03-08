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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.PdsDAO;
import model.PdsVO;

/**
 * Servlet implementation class pdsModifyServlet
 */
@WebServlet("/pds_modify")
public class pdsModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pdsModifyServlet() {
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
		
		PdsDAO DAO = PdsDAO.getInstance();
		PdsVO vo = new PdsVO();
		vo = DAO.pdsSelect(idx);
		
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Pds/pds_modify.jsp");
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
		String path = context.getRealPath("Pds/upload/");
		String encType = "utf-8";
		int sizeLimit = 2*1024*1024; //파일 최대 용량 설정
		
		MultipartRequest multi = new MultipartRequest(request,path,sizeLimit,encType, new DefaultFileRenamePolicy());
		//파일 중복시 자동 이름 변경
		PdsVO vo = new PdsVO();
		int page = Integer.parseInt(multi.getParameter("page"));
		String oldfilename = multi.getParameter("oldfilename");
		vo.setIdx(Integer.parseInt(multi.getParameter("idx")));
		vo.setName(multi.getParameter("name"));
		vo.setEmail(multi.getParameter("email"));
		vo.setSubject(multi.getParameter("subject"));
		vo.setContetns(multi.getParameter("contents"));
		vo.setPass(multi.getParameter("pass"));
		vo.setFilename(multi.getFilesystemName("filename"));
		
		//첨부파일이 있는 지 검사
		if(vo.getFilename() == null) {
			vo.setFilename(oldfilename);
		}
		else {
			//변경 파일 삭제
			File file = new File(path+oldfilename);
			if(file.exists()) {
				file.delete();
			}
		}
		
		PdsDAO DAO = PdsDAO.getInstance();
		int row = DAO.pdsModify(vo);
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Pds/pds_modify_pro.jsp");
		dispatcher.forward(request, response);
	}

}
