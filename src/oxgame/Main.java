package oxgame;

import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Board board = new Board();
		Player[] player = new Player[2];
		player[0] = new Player("プレイヤー１", "○");
		player[1] = new Player("プレイヤー２", "×");
		int judgment = 0;
		int turn = 0;

		while (true) {
		while (true) {
		board.show();
		System.out.printf("%sさんの番です (1～9を入力) >", player[turn].getName());
		int number = player[turn].play();
		if (number == 0) {
		System.out.println("1～9の数字を入力してください");
		continue;
		}
		if (board.check(number)) {
		board.set(number, player[turn].getMark());
		break;
		}
		System.out.println("そこには置けません");
		}
		judgment = board.judge();
		if (judgment != 0) {
		break;
		}
		turn = (turn + 1) % 2;
		}

		board.show();
		System.out.println("ゲーム終了！");

		switch (judgment) {
		case 1:
		System.out.printf("%sさんの勝ちです%n", player[0]);
		break;
		case 2:
		System.out.printf("%sさんの勝ちです%n", player[1]);
		break;
		default:
		System.out.println("勝負はつきませんでした");
		}
		}
		}

		class Board {
		private String[][] pos = new String[3][3];
		private int cnt;

		Board() {
		for (int x = 0; x < 3; x++) {
		for (int y = 0; y < 3; y++) {
		pos[x][y] = "－";
		}
		}
		cnt = 0;
		}

		void show() {
		for (int x = 0; x < 3; x++) {
		for (int y = 0; y < 3; y++) {
		System.out.printf("%s ", pos[x][y]);
		}
		System.out.println("");
		}
		}

		public boolean check(int number) {
		switch (number) {
		case 1:
		return pos[0][0] == "－";
		case 2:
		return pos[0][1] == "－";
		case 3:
		return pos[0][2] == "－";
		case 4:
		return pos[1][0] == "－";
		case 5:
		return pos[1][1] == "－";
		case 6:
		return pos[1][2] == "－";
		case 7:
		return pos[2][0] == "－";
		case 8:
		return pos[2][1] == "－";
		case 9:
		return pos[2][2] == "－";
		}
		return false;
		}

		public void set(int number, String mark) {
		switch (number) {
		case 1:
		pos[0][0] = mark;
		cnt++;
		break;
		case 2:
		pos[0][1] = mark;
		cnt++;
		break;
		case 3:
		pos[0][2] = mark;
		cnt++;
		break;
		case 4:
		pos[1][0] = mark;
		cnt++;
		break;
		case 5:
		pos[1][1] = mark;
		cnt++;
		break;
		case 6:
		pos[1][2] = mark;
		cnt++;
		break;
		case 7:
		pos[2][0] = mark;
		cnt++;
		break;
		case 8:
		pos[2][1] = mark;
		cnt++;
		break;
		case 9:
		pos[2][2] = mark;
		cnt++;
		break;
		default:
		}
		}

		public int judge() {
		if (cnt == 9) {
		return 3;
		}
		return 0;
		}
		}

		class Player {
		private String name;
		private String mark;

		Player(String name, String mark) {
		this.name = name;
		this.mark = mark;
		}

		public String getName() {
		return name;
		}

		public String getMark() {
		return mark;
		}

		public int play() {
		Scanner scan = new Scanner(System.in);
		if (!scan.hasNextInt()) {
		return 0;
		}
		int number = scan.nextInt();
		if (number >= 1 && number <= 9) {
		return number;
		}
		return 0;


	}

}
