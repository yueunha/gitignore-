package board;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) { //메인 함수 

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> ids = new ArrayList<>(); // 전체 수 배열
		ArrayList<String> titles = new ArrayList<>(); // 문자열로 입력받은 제목 배열
		ArrayList<String> bodies = new ArrayList<>(); // 문자열로 입력받은 내용 배열
		int lastid = 1;


		while (true) {
			String s = sc.nextLine();
			if (s.equals("exit")) {
				System.out.println("프로그램 종료");
				break;
			} else if (s.equals("add")) {
				System.out.println("게시물 제목을 입력해주세요");
				String title = sc.nextLine();
				System.out.println("게시물 내용을 입력해주세요");
				String body = sc.nextLine();
				ids.add(lastid); // 전체 배열 크기
				lastid++;
				titles.add(title); // 입력받은 값 제목배열에 추가
				bodies.add(body); // 입력받은 값 내용배열에 추가

			} else if (s.equals("list")) { // 게시물 조회하는 것

				for (int i = 0; i < titles.size(); i++) {
					System.out.println("번호 : " + ids.get(i));
					System.out.println("제목 : " + titles.get(i));
					System.out.println("내용 : " + bodies.get(i));
					System.out.println("-----------------");
				}
			} else if (s.equals("read")) { // 입력한 게시물 정보와 같은 게시물 읽는 것
				System.out.println("보고싶은 게시물 번호를 입력해주세요");
				int id = Integer.parseInt(sc.nextLine());
				int target =findnum(id,ids);
				if (id == target) {
					System.out.println("번호 : " + ids.get(target));
					System.out.println("제목 : " + titles.get(target));
					System.out.println("내용 : " + bodies.get(target));
					break;
				}else {
					System.out.println("원하는 게시물이 없습니다.");
				}

			} else if (s.equals("update")) {
				System.out.println("수정하고싶은 게시물 번호를 입력해주세요");
				int id = Integer.parseInt(sc.nextLine());
				int target =findnum(id,ids);
				if (id == target) {
					System.out.println("새로운 제목");
					String title = sc.nextLine();
					System.out.println("새로운 내용");
					String body = sc.nextLine();

					titles.set(target, title);
					bodies.set(target, body);
					break;
				}
			} else if (s.equals("delete")) {
				System.out.println("삭제하고싶은 게시물 번호를 입력해주세요");
				int id = Integer.parseInt(sc.nextLine());
				int target =findnum(id,ids);
				if (id == target) {
					ids.remove(target);
					titles.remove(target);
					bodies.remove(target);
					break;
				}
			}

		}

	}
	 private static int findnum(int id, ArrayList<Integer> ids) {
		 for (int i = 0; i < ids.size(); i++) { //번호 탐색해서 원하는 값 출력하게 함.  // f는 ids의 i번째 값 가져온거.
				if(id==ids.get(i)) {
					return i;
				}
			}
		return -1;
	}
// 탑다운
// 바텀업

}

