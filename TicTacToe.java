
public class TicTacToe {
public static void main(String[] args) {
	Game game = new Game();
	System.out.println("Welcome to TicTacToe\npress 1 to play or any key to exit");
	if(game.continue_game()) {
		game.setPlayers();
	}
	do {
		game.newgame();
		game.play();
		System.out.println("press 1 to play again or any key to exit");
	}while(game.continue_game());
}
}
