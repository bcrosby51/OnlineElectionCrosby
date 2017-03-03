package model;

public class ListElection {

	private int electionID;
	private String electionName;
	private String CanidName1;
	private String CanidName2;
	private String CanidName3;
	private String CanidVoteToString1;
	private String CanidVoteToString2;
	private String CanidVoteToString3;
	private int CanidVote1;
	private int CanidVote2;
	private int CanidVote3;
	
	public ListElection(String eN, String cN1, String cN2, String cN3, int cV1, int cV2, int cV3) {
		this.electionName = eN;
		this.CanidName1 = cN1;
		this.CanidName2 = cN2;
		this.CanidName3 = cN3;
		this.CanidVote1 = cV1;
		this.CanidVote2 = cV2;
		this.CanidVote3 = cV3;
	}
	
	public ListElection(int elecID, String eN, String cN1, String cN2, String cN3, int cV1, int cV2, int cV3) {
		this.electionID = elecID;
		this.electionName = eN;
		this.CanidName1 = cN1;
		this.CanidName2 = cN2;
		this.CanidName3 = cN3;
		this.CanidVote1 = cV1;
		this.CanidVote2 = cV2;
		this.CanidVote3 = cV3;
	}
	
	public int getElectionID() {
		return electionID;
	}

	public void setElectionID(int electionID) {
		this.electionID = electionID;
	}

	public String getElectionName() {
		return electionName;
	}

	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}

	public String getCanidName1() {
		return CanidName1;
	}

	public void setCanidName1(String canidName1) {
		CanidName1 = canidName1;
	}

	public String getCanidName2() {
		return CanidName2;
	}

	public void setCanidName2(String canidName2) {
		CanidName2 = canidName2;
	}

	public String getCanidName3() {
		return CanidName3;
	}

	public void setCanidName3(String canidName3) {
		CanidName3 = canidName3;
	}

	public int getCanidVote1() {
		return CanidVote1;
	}

	public void setCanidVote1(int canidVote1) {
		CanidVote1 = canidVote1;
	}
	
	public String getCanidVote1ToString() {
		return CanidVoteToString1 ;
	}
	
	public int getCanidVote2() {
		return CanidVote2;
	}
	
	public String getCanidVote2ToString() {
		return CanidVoteToString2 ;
	}

	public void setCanidVote2(int canidVote2) {
		CanidVote2 = canidVote2;
	}

	public int getCanidVote3() {
		return CanidVote3;
	}
	
	public String getCanidVote3ToString() {
		return CanidVoteToString3 ;
	}

	public void setCanidVote3(int canidVote3) {
		CanidVote3 = canidVote3;
	}

	@Override
	public String toString() {
		return "ListItem [electionName=" + electionName + ", CanidName1=" + CanidName1 + ", CanidName2=" + CanidName2
				+ ", CanidName3=" + CanidName3 + ", CanidVote1=" + CanidVote1 + ", CanidVote2=" + CanidVote2
				+ ", CanidVote3=" + CanidVote3 + "]";
	}	
}
