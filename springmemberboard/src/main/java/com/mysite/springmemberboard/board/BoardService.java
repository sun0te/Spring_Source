package com.mysite.springmemberboard.board;

import java.util.List;

public interface BoardService {
	public int getListCount();
	public List<BoardVO> getBoardList(int page,int limit);
	public boolean boardInsert(BoardVO board);
	public BoardVO getDetail(int num);

}
