package graphpkg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import MonitorStats.Datagram;
import graphpkg.DataplanePolicy;
import graphpkg.DataplanePolicyDescription;

/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paths = "C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\graphText.txt";

		File fileObject = new File(paths);

		BufferedReader br = new BufferedReader(new FileReader(paths));
		StringBuffer message=new StringBuffer();
		String line =br.readLine();
		message.append(line);
		line=br.readLine();
		while(line!=null){
				message.append(line);
				if((line=br.readLine())!=null)
					message.append(",");
			
			
		}
			
			
			
		
		
		
		PrintWriter out = response.getWriter();
        out.println(message.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
