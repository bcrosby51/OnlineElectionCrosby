package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ListElectionDAO;

/**
 * Servlet implementation class deleteElectionServlet
 */
@WebServlet("/deleteElectionServlet")
public class deleteElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteElectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Delete Election Servlet");
		ListElectionDAO dao = new ListElectionDAO();
		String actionToPerform = request.getParameter("deleteElectionChoice");
		System.out.println(actionToPerform);
		
		if(actionToPerform.equals("Delete Election")) {
			String tempElecName = request.getParameter("electToDelete");				
			dao.delete(tempElecName);
			System.out.println("Election deleted");		
			getServletContext().getRequestDispatcher("/ViewElectionsServlet").forward(request, response);
		}else if(actionToPerform.equals("Cancel Delete Election")) {
			getServletContext().getRequestDispatcher("/ViewElectionsServlet").forward(request, response);
		}
		
		
	}

}
