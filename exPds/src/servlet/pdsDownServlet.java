package servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pdsDownServlet
 */
@WebServlet("/pds_down")
public class pdsDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pdsDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String filename = request.getParameter("filename");
		
		String path = request.getRealPath("/") + "Pds/upload/";
		File file = new File(path+filename);
		
		String Agent = request.getHeader("USER-AGENT");
		response.setContentType("application/unknown");
		response.setHeader("Content-Disposition", "attachmentvalue);filename="+URLEncoder.encode(filename));
		
		try {
			byte b[] = new byte[5*1024*1024];
			if(file.isFile()) {
				BufferedInputStream bis =  new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
				
				
				try {
					int read = 0;
					while((read =bis.read(b)) != -1){
						bos.write(b,0,read);
					}
					bos.flush();
					bos.close();
					bis.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
