package board;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	// 클래스는 고유한 한개-STATIC붙으면 고유한 존재가 됨. 객체들이 클래스 공유함.
	// 독립성 낮아짐.재활용성 떨어짐.STATIC 필요할 때 아니면 쓰지말아라.
	public static void main(String[] args) {
		App app = new App();
		app.start();

	}
}