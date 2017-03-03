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
 * Servlet implementation class MasterElectionServlet
 */
@WebServlet("/MasterElectionServlet")
public class MasterElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterElectionServlet() {
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
		System.out.println("Inside Master Election Servlet");
		ListElectionDAO dao = new ListElectionDAO();
		String actionToPerform = request.getParameter("doThisToElection");
		System.out.println(actionToPerform);
		ListElection currentElection;
		
		if(actionToPerform.equals("Start Election")) {
			int tempId = Integer.parseInt(request.getParameter("id"));
			currentElection = dao.getAllElections().get(tempId);
			System.out.println("Launch us to add Election");
			request.setAttribute("electId", currentElection.getElectionID());
			request.setAttribute("electName", currentElection.getElectionName());
			request.setAttribute("candidOneName", currentElection.getCanidName1());
			request.setAttribute("candidTwoName", currentElection.getCanidName2());
			request.setAttribute("candidThreeName", currentElection.getCanidName3());
			request.setAttribute("candidOneVote", currentElection.getCanidVote1ToString());
			request.setAttribute("candidOneVote", currentElection.getCanidVote2ToString());
			request.setAttribute("candidOneVote", currentElection.getCanidVote3ToString());
			getServletContext().getRequestDispatcher("/start-election.jsp").forward(request, response);
		}else if(actionToPerform.equals("Create Election")) {
			getServletContext().getRequestDispatcher("/add-election.jsp").forward(request, response);
		}else if(actionToPerform.equals("Delete Election")) {
			int tempId = Integer.parseInt(request.getParameter("id"));
			currentElection = dao.getAllElections().get(tempId);
			request.setAttribute("tempElectName", currentElection.getElectionName());
			getServletContext().getRequestDispatcher("/delete-election.jsp").forward(request, response);
		}else if(actionToPerform.equals("View Results")) {
			System.out.println("Starting View Results");
			request.setAttribute("AllElectionsList", dao.getAllElections());
			getServletContext().getRequestDispatcher("/view-results.jsp").forward(request, response);
		}
		
		doGet(request, response);
	}

}
