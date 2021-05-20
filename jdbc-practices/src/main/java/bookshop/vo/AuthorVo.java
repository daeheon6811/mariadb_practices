package bookshop.vo;

public class AuthorVo {
	
	private Long No;
	private String name;
	
	public Long getNo() {
		return No;
	}
	public void setNo(Long no) {
		No = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AuthorVo [No=" + No + ", name=" + name + "]";
	}

	
	

}
