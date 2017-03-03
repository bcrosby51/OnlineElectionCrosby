package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListElection;
import model.ListElectionDAO;

/**
 * Servlet implementation class AddItemSerlet
 */
@WebServlet("/AddElectionServlet")
public class AddElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddElectionServlet() {
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
		// TODO Auto-generated method stub
		System.out.println("Inside Add Election Servlet");
		ListElectionDAO dao = new ListElectionDAO();
		String actionToPerform = request.getParameter("addElectionChoice");
		System.out.println(actionToPerform);
		
		if(actionToPerform.equals("Create Election")) {
			System.out.println("adding new election");
			String electionName = request.getParameter("electName");
			String candidOneName = request.getParameter("candOne");
			String candidTwoName = request.getParameter("candTwo");
			String candidThreeName = request.getParameter("candThree");
			
			ListElection li = new ListElection(0, electionName, candidOneName, candidTwoName, candidThreeName, 0, 0, 0);
			dao.insertNewElection(li);
			System.out.println("New election added");
			getServletContext().getRequestDispatcher("/ViewElectionsServlet").forward(request, response);
		}else if(actionToPerform.equals("Cancel New Election")) {
			getServletContext().getRequestDispatcher("/ViewElectionsServlet").forward(request, response);
		}
		
		
		
	}

}
