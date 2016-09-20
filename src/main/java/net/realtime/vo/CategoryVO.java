package net.realtime.vo;

/**
 * 카테고리 테이블(CTGR)의 컬럼을 모두 멤버변수로 가진다.
 * @author 206-024
 *
 */
public class CategoryVO {

	private int categoryId;
	private String categoryName;
	private int parentCategoryId;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getParentCategoryId() {
		return parentCategoryId;
	}
	public void setParentCategoryId(int parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	
	
}
