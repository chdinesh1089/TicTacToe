
public class Board {

private char a[] = new char[9];
private boolean xo = true;

Board(){
	int len = 9;
	// fastest way to set all values in an array.
	this.a[0] = ' ';
	for (int i = 1; i < len; i+=i) {
		System.arraycopy(this.a, 0, this.a, i, ((len-i)<i)?(len-i):i);
	}
}
private char whose_turn() {
	return this.xo?'x':'o';
}
private void update_turn() {
	xo = !xo;
}
private boolean validmove(int i) {
	return this.a[i] == ' ';
}
public void update(int i) {
	if(!validmove(i)) {
		System.out.println("That was an Inalid move. Try again!");
		return;
	}
	if(i>=9 || i<0)
		System.out.println("Invalid input given to update board");
	else{
		this.a[i] = whose_turn();
		update_turn();
	}
}
public void print_board() {
	String seperatorString = "-------\n";
	StringBuilder str = new StringBuilder();
	str.append(String.format("|%c|%c|%c|\n", this.a[0],this.a[1],this.a[2]));
	str.append(seperatorString);
	str.append(String.format("|%c|%c|%c|\n", this.a[3],this.a[4],this.a[5]));
	str.append(seperatorString);
	str.append(String.format("|%c|%c|%c|\n", this.a[6],this.a[7],this.a[8]));
	System.out.println(str.toString());
}
private boolean allequal(int a, int b, int c) {
	return this.a[a]==this.a[b]?this.a[b]==this.a[c]:false;
}
public char winner() {
	int indexes[][] = {
			{0,1,2},
			{3,4,5},
			{6,7,8},
			{0,3,6},
			{1,4,7},
			{2,5,8},
			{0,4,8},
			{2,4,6}
	};
	for (int i=0;i<8;i++) {
		if(allequal(indexes[i][0],indexes[i][1],indexes[i][2])){
			return this.a[indexes[i][0]];
		}
	}
	return ' ';
}
public boolean boardfilled() {
	for(int i=0;i<9;i++) {
		if(this.a[i] == ' ')
			return false;
	}
	return true;
}
}
