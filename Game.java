import java.util.Scanner;
public class Game {
private Board board;
private String player1, player2;
private Scanner s = new Scanner(System.in);
private void setPlayer1() {
	System.out.print("Enter Player1 name: ");
	this.player1 = s.next();
	System.out.println();
}
private void setPlayer2() {
	System.out.print("Enter Player2 name: ");
	this.player2 = s.next();
	System.out.println();
}
public void setPlayers() {
	setPlayer1();
	setPlayer2();
}
private boolean gameover() {
	return board.winner() != ' ' || board.boardfilled();
}
public boolean continue_game() {
	return s.nextInt() == 1;
}
public void play() {
	System.out.println("Enter values from 1 to 9 to update board\nHere's how board looks");
	board.print_board();
	while(!gameover()) {
		System.out.print("Enter your move: ");
		board.update(s.nextInt() - 1);
		board.print_board();
	}
	char winner = board.winner();
	if(winner == ' ')
		System.out.println("Draw");
	else if(winner == 'x')
		System.out.println(String.format("%s wins!",this.player1));
	else
		System.out.println(String.format("%s wins!",this.player2));
}
public void newgame() {
	this.board = new Board();
}

}
