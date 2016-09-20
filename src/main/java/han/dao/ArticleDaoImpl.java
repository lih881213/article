package han.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.han.vo.ArticleVO;

public class ArticleDaoImpl implements ArticleDao {

	@Override
	public List<ArticleVO> getArticle() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTCL", "ARTCL");
			
			StringBuffer query = new StringBuffer();
			query.append(" SELECT 	A.ARTCL_ID ");
			query.append("			, A.SBJ ");
			query.append("			, A.CONT ");
			query.append("			, A.CRT_DT ");
			query.append(" FROM		ARTCL A ");
			
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			
			List<ArticleVO> article = new ArrayList<ArticleVO>();
			
			ArticleVO articleVO = null;
			
			while(rs.next()) {
				
				articleVO = new ArticleVO();
				articleVO.setArticleId(rs.getInt("ARTCL_ID"));
				articleVO.setSubject(rs.getString("SBJ"));
				articleVO.setContents(rs.getString("CONT"));
				articleVO.setCreateDate(rs.getString("CRT_DT"));

				
				article.add(articleVO);
			}
			return article;
		
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		finally{
			
			if ( rs !=null ) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if ( pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if ( conn != null ) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}	
}
