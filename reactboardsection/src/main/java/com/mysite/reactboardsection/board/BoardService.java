package com.mysite.reactboardsection.board;

import java.util.List;

public interface BoardService {
	public List<BoardVO> getBoardList(int page_num, int limit);
	public int getCount();	//추가
	public int insertBoard(BoardVO board);
	public BoardVO getDetail(BoardVO board);
	public int modifyBoard(BoardVO board);
	public int deleteBoard(BoardVO board);
}
