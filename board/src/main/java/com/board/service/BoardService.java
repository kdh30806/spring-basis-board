package com.board.service;

import java.util.List;

import com.board.domain.BoardDTO;

public interface BoardService {
	public List list() throws Exception;

	int regi(BoardDTO dto) throws Exception;

	public BoardDTO view(int seq); 
}