package com.mysite.springmemberboard.board;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
private BoardMapper mapper;
	
	public BoardServiceImpl(BoardMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public int getListCount() {
		int res = mapper.getListCount();
		return res;
	}

	@Override
	public List<BoardVO> getBoardList(int page, int limit) {
		int start = (page - 1) * limit;
		List<BoardVO> boardlist = mapper.getBoardList(start, limit);
		return boardlist;
	}
	
	@Override
	public boolean boardInsert(BoardVO board) { // 원글쓰기
		board.setRe_ref(mapper.getMaxNum() + 1);
		boolean res = mapper.boardInsert(board);
		return res;
	}
	
	@Override
	public BoardVO getDetail(int num) {
		mapper.setReadCountUpdate(num);
		BoardVO board = mapper.getDetail(num);
		return board;
	}
	

}
