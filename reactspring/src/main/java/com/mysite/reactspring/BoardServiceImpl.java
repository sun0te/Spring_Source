package com.mysite.reactspring;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;
	
	public BoardServiceImpl(BoardMapper mapper) {
		this.mapper = mapper;
	}

	
	@Override
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardlist = mapper.getBoardList();
		return boardlist;
	}

	@Override
	public int insertBoard(BoardVO board) {
		int res = mapper.insertBoard(board);
		return res;
	}

	@Override
	public BoardVO getDetail(BoardVO board) {
		BoardVO boardVo = mapper.getDetail(board);
		return boardVo;
	}

	@Override
	public int modifyBoard(BoardVO board) {
		int res = mapper.modifyBoard(board);
		return res;
	}

	@Override
	public int deleteBoard(BoardVO board) {
		int res = mapper.modifyBoard(board);
		return res;
	}

}
