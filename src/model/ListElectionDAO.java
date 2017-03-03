package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Statement;

public class ListElectionDAO {
	
	Connection con = null;

	public ListElectionDAO(){
		makeConnection();		
	}
	
	public void makeConnection() {
		String url = "jdbc:mysql://localhost:3306/elections";
		String user = "root";
		String password = "DIAD2016";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection made");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("SQL exception in makeConnection()");
			System.out.println(e);
		}
	}
	
	public ArrayList<ListElection> getAllElections() {		
		ArrayList<ListElection> allElectionsList = new ArrayList<ListElection>();
		
		String q = "select * from elections";
	
		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(q);
			
			while (rs.next()) {
				int elecID = rs.getInt(1);
				String elecName = rs.getString(2);
				String CanName1 = rs.getString(3);
				String CanName2 = rs.getString(4);
				String CanName3 = rs.getString(5);
				int CanVote1 = rs.getInt(6);
				int CanVote2 = rs.getInt(7);
				int CanVote3 = rs.getInt(8);
				
				ListElection tempItem = new ListElection(elecID, elecName, CanName1, CanName2, CanName3, CanVote1, CanVote2, CanVote3);
				allElectionsList.add(tempItem);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection error in getAllItems()");
			System.out.println(e.getStackTrace());
		}
		
		return allElectionsList;
		
	}
	
	public ArrayList<String> getCurrentListFromElection(String s) {
		ArrayList<String> allItemsFromSelectedElection = new ArrayList<String>();
		
		for(ListElection p : getAllElections()) {
			if (p.getElectionName().equals(s)){
				allItemsFromSelectedElection.add(p.getCanidName1());
				allItemsFromSelectedElection.add(p.getCanidName2());
				allItemsFromSelectedElection.add(p.getCanidName3());
				allItemsFromSelectedElection.add(p.getElectionName());
				allItemsFromSelectedElection.add(p.getCanidVote1ToString());
				allItemsFromSelectedElection.add(p.getCanidVote2ToString());
				allItemsFromSelectedElection.add(p.getCanidVote3ToString());
			}
		}		
		return allItemsFromSelectedElection;
	}

	public void insertNewElection(ListElection i) {
		// TODO Auto-generated method stub
		makeConnection();
		
		String tempElec = i.getElectionName();
		String tempCan1 = i.getCanidName1();
		String tempCan2 = i.getCanidName2();
		String tempCan3 = i.getCanidName3();		
		
		String query = "insert into elections (ElectionName, "
				+ "							   CanidName1,"
				+ "							   CanidName2,"
				+ "							   CanidName3,"
				+ "							   CanidVote1,"
				+ "							   CanidVote2,"
				+ "							   CanidVote3) values ('"+tempElec +"','"+tempCan1 +"','"+tempCan2 +"','"+tempCan3 +"','0','0','0')";
		
		try {
			Statement st = (Statement) con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
	}

	public void delete(String tempElectName) {
		// TODO Auto-generated method stub
		makeConnection();
		
		String tempElection = tempElectName;
		
		String query = "delete from elections where electionName ='"+tempElection +"'";
		try {
			Statement st = (Statement) con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("add item error");
		}
	}
	
	public void update(String eN, int v1, int v2, int v3) {
		// TODO Auto-generated method stub
		makeConnection();
		
		String query = "UPDATE elections SET canidVote1='"+ v1 +"',canidVote2= '"+ v2 +"',canidVote3= '"+ v3 +"'"
				+ "WHERE electionName ='"+ eN +"'";
		try {
			Statement st = (Statement) con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Update election error");
		}
	}
	
	public void updateVote(String eN, int canNum) {
		// TODO Auto-generated method stub
		makeConnection();
		String query = null;
		
		switch (canNum) {
		case 1:
			query = "UPDATE elections SET canidVote1 = canidVote1 + 1 WHERE electionName ='" + eN + "'";
			break;
		case 2:
			query = "UPDATE elections SET canidVote2 = canidVote2 + 1 WHERE electionName ='" + eN + "'";
			break;
		case 3:
			query = "UPDATE elections SET canidVote3 = canidVote3 + 1 WHERE electionName ='" + eN + "'";
			break;
		}
		
		
		try {
			Statement st = (Statement) con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Update election error");
		}
	}

	
}

