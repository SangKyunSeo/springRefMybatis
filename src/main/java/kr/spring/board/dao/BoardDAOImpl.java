package kr.spring.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.spring.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void insertBoard(BoardVO board) {
		//                SQL문을 식별하는 id, 자자빈(VO) - 데이터가 들어가있는
		sqlSession.insert("insertBoard",board);		
	}

	@Override
	public int selectBoardCount() {
		return sqlSession.selectOne("selectBoardCount");
	}

	@Override
	public List<BoardVO> selectBoardList(Map<String, Object> map) {
		return sqlSession.selectList("selectBoardList", map);
	}

	@Override
	public BoardVO selectBoard(int num) {
		return sqlSession.selectOne("selectBoard",num);
	}

	@Override
	public void updateBoard(BoardVO board) {
		sqlSession.update("updateBoard",board);
	}

	@Override
	public void deleteBoard(int num) {
		sqlSession.delete("deleteBoard",num);
	}
	
}
