package com.board.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.board.dao.BoardDAO;
import com.board.domain.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;

	@Override
	public List list() throws Exception {
		return dao.list();
	}
	
	@Override
	public int regi(BoardDTO dto) throws Exception {
		
		if (dao.getMaxSeq() == null) { // 게시글이 존재하지 않을 때
			dto.setSeq(1); // SEQ는 1
		} else { // 게시글이 존재할 때
			dto.setSeq(dao.getMaxSeq() + 1); // 최대값에 +1
		}
		
		return dao.regi(dto);
	}

}