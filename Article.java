package board;

public class Article {
	// private 쓰면 클래스 안에서만 접근 가능.접근제어자 
	private int id;
	private String title;
	private String body;
	
    //캡슐화 함(getter,setter)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
