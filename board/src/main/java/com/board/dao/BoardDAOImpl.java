package com.board.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.board.mappers.board";

	@Override
	public List list() throws Exception {
		return sqlSession.selectList(namespace + ".list");
	}
	
	@Override
	public Integer getMaxSeq() {
		return sqlSession.selectOne(namespace+".maxSeq");
	}

	@Override
	public int regi(BoardDTO dto) {
		return sqlSession.insert(namespace+".regi", dto);
	}

	@Override
	public BoardDTO view(int seq) {
		return sqlSession.selectOne(namespace+".view", seq);
	}

}