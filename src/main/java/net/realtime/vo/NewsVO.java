package net.realtime.vo;

public class NewsVO {
	
	private int newsId;
	private String subject;
	private String content;
	private int recommendCount;
	private int journalistId;
	private int categoryId;
	private String createdDate;
	
	private JournalistVO journalistVO;
	private CategoryVO categoryVO;
	
	
	public NewsVO() {
		journalistVO = new JournalistVO();
		categoryVO = new CategoryVO();
	}
	
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRecommendCount() {
		return recommendCount;
	}
	public void setRecommendCount(int recommendCount) {
		this.recommendCount = recommendCount;
	}
	public int getJournalistId() {
		return journalistId;
	}
	public void setJournalistId(int journalistId) {
		this.journalistId = journalistId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public JournalistVO getJournalistVO() {
		return journalistVO;
	}
	public void setJournalistVO(JournalistVO journalistVO) {
		this.journalistVO = journalistVO;
	}
	public CategoryVO getCategoryVO() {
		return categoryVO;
	}
	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}
	
	
}
