package ConnectFourCourseWork;

public class Player {
	private String colour;
	private String name;
	private int turn;

	public Player(String name,String colour,int turn) {
		setName(name);
		setColour(colour);
		setTurn(turn);
	}

	//GETTERS AND SETTERS
	public void setColour(String colour) {
		this.colour=colour;
	}
	public String getColour() {
		return this.colour;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setTurn(int turn) {
		this.turn=turn;
	}
	public int getTurn() {
		return this.turn;
	}

}
