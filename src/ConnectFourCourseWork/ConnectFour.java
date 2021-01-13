package ConnectFourCourseWork;
import javax.swing.JOptionPane;

public class ConnectFour {

	public static void main(String[] args){
		Game game;
		Player player1=new Player(JOptionPane.showInputDialog("Player One, Please choose your name"),"_Red_",1);
		Player player2=new Player(JOptionPane.showInputDialog("Player Two, Please choose your name"),"_Blue",2);
		int input;
		String inputInString;
		int continueGame=0;
		int yes=0;
		int no=1;
		int anotherGo=0;	
		do {
			game=new Game();
			//setting the first player to start the game
			game.setPlayer(player1);

			do {
				//asking player for input
				inputInString=JOptionPane.showInputDialog(null,game.printTheGrid()+"\n\n"+game.getPlayer().getName()+", please choose a column from 1 to 7.");
				input=Integer.parseInt(inputInString);
				//ensuring that the input is valid(both inside the grid and for a row that still has space)
				while(game.checkingIfInputIsValid(input)==false||game.columnFull(input)) {
					String errorMessage=game.errorMessage(input);
					inputInString=JOptionPane.showInputDialog(null,game.printTheGrid()+"\n\n"+game.getPlayer().getName()+", "+errorMessage,"",JOptionPane.OK_OPTION);
					input=Integer.parseInt(inputInString);
				}
				//adding the disc to the place requested
				game.addAdisc(input);
				if(game.usingTheChecker(input)) {
					JOptionPane.showMessageDialog(null,game.printTheGrid()+"\n\n"+ game.getPlayer().getName()+", you Won");
					//asking the players in they would like to play again
					anotherGo=JOptionPane.showConfirmDialog(null, "Would you like another go?","",JOptionPane.YES_NO_OPTION);
					break;
				}
				//stopping the game if the grid is full
				if(game.seeIfGridFull()) {
					JOptionPane.showMessageDialog(null, "Game Over\nThe Grid is Full");
					//asking the players in they would like to play again
					anotherGo=JOptionPane.showConfirmDialog(null, "Would you like another go?","",JOptionPane.YES_NO_OPTION);
					break;
				}
				//switching between active players
				if(game.getPlayer()==player1) {
					game.setPlayer(player2);
				}else {
					game.setPlayer(player1);
				}
				//asking player if they would like to continue playing
				continueGame=JOptionPane.showConfirmDialog(null, game.getPlayer().getName()+", it's your turn.\nWould you like to continue?","",JOptionPane.YES_NO_OPTION);
			}while(continueGame==yes);
			//if they say they don't want to continue the game exits
			if(continueGame==no) {
				System.exit(0);
			}
			//restarting the game if the players wish to do so
		}while(anotherGo==yes);
		if(anotherGo==no) {
			System.exit(0);
		}
	}
}
