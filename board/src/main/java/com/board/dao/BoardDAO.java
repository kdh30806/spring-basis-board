package com.board.dao;

import java.util.List;

import com.board.domain.BoardDTO;

public interface BoardDAO {
 
 public List list() throws Exception;

Integer getMaxSeq();

int regi(BoardDTO dto);

public BoardDTO view(int seq);

public void updateReadCount(int seq);

public int update(BoardDTO dto);

public int delete(int seq); 

}