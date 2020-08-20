package board;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
   
    ArticleDao dao=new ArticleDao();

	public void start(){
	dao.makeTestdata();//생성자 생성
	Scanner sc = new Scanner(System.in);
	
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
			Article article = new Article(); //article 클래스에 새로운 아티클 객체 만듦.
			article.setTitle(title);
			article.setBody(body);
			dao.addArticle(article); //articledao클래스에서 addarticle 함수 이용해서 article추가.
			
			
		} else if (s.equals("list")) {
			ArrayList<Article> articles =dao.getArticles(); //전체데이터 가져옴.
			for (int i = 0; i < articles.size(); i++) {
				Article article = articles.get(i);
				
				System.out.println("번호 : " + article.getId());
				System.out.println("제목 : " + article.getTitle());
				System.out.println("-----------------");
			}
		} else if (s.equals("read")) {
			System.out.println("보고싶은 게시물 번호를 입력해주세요");
			int id = Integer.parseInt(sc.nextLine());
			Article article = dao.getArticleById(id);
			
			if (article == null) {
				System.out.println("없는 게시물입니다.");
			} else {
				System.out.println("번호 : " + article.getId());
				System.out.println("제목 : " + article.getTitle());
				System.out.println("내용 : " + article.getBody());
			}

		} else if (s.equals("update")) {
			System.out.println("수정하고싶은 게시물 번호를 입력해주세요");
			int id = Integer.parseInt(sc.nextLine());
			Article article = dao.getArticleById(id);
 

			if (article == null) {
				System.out.println("없는 게시물입니다.");
			} else {
				System.out.println("새로운 제목");
				String title = sc.nextLine();
				System.out.println("새로운 내용");
				String body = sc.nextLine();
				article.setTitle(title);
				article.setBody(body);
				
				dao.updatearticle(id, article);
			}

		} else if (s.equals("delete")) {
			System.out.println("삭제하고싶은 게시물 번호를 입력해주세요");
			int id = Integer.parseInt(sc.nextLine());

			Article article = dao.getArticleById(id);


			if (article == null) {
				System.out.println("없는 게시물입니다.");
			} else {
				dao.deletearticle(article);
			}
		}else if (s.equals("search")) {
			System.out.println("검색하고싶은 게시물 제목을 입력해주세요");
		    String t = sc.nextLine();
			Article article = dao.getTitleT(t);
			if (article==null) {
				System.out.println("없는 게시물입니다.");
			} else {
				System.out.println("번호 : " + article.getId());
				System.out.println("제목 : " + article.getTitle());
				System.out.println("내용 : " + article.getBody());
			}
			
		}
	}
	}

   }
 
