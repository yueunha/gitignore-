package board;

import java.util.ArrayList;

//데이터관리
public class ArticleDao {
	
	ArrayList<Article> articles = new ArrayList<Article>();
	int lastId = 4;

	void makeTestdata() {
		Article article1 = new Article();
		article1.setId(1);
		article1.setTitle("제목1");
		article1.setBody("내용1");

		Article article2 = new Article();
		article2.setId(2);
		article2.setTitle("제목2");
		article2.setBody("내용2");

		Article article3 = new Article();
		article3.setId(3);
		article3.setTitle("제목3");
		article3.setBody("내용3");
		articles.add(article1);
		articles.add(article2);
		articles.add(article3);
	}

	void addArticle(Article article) { // 게시판 추가하는 함수
		article.setId(lastId); // 게시판 수 추가
		articles.add(article); // 게시판 내용 추가
		lastId++; // 수 증가

	}

	// 전체 데이터 가져오기
	ArrayList<Article> getArticles() {
		return articles;
	}

	// 원하는 데이터 가져오는 함수
	Article getArticleById(int id) {
		int index = getIndexById(id);
		if (index == -1) {
			return null;
		}
		return articles.get(index);
	}

	// 원하는 게시판 수정하는 함수
	void updatearticle(int id, Article article) {
		int index = getIndexById(id);
		if (index != -1) {
			articles.set(index, article);
		}

	}

	// 원하는 데이터 삭제하는 함수
	void deletearticle(Article article) {
		articles.remove(article);
	}

	// 게시판 전체데이터중 입력한 id찾는 함수.
	int getIndexById(int id) {

		for (int i = 0; i < articles.size(); i++) {
			if (id == articles.get(i).getId()) {
				return i;
			}
		}

		return -1;

	}

	Article getTitleT(String title) {
		for (int i = 0; i < articles.size(); i++) {
			Article t2 = articles.get(i);
			if (t2.getTitle().contains(title)) {  //입력한 문자 포함여부 확인
				return t2;	
			}
		}
		return null;
	}
}
