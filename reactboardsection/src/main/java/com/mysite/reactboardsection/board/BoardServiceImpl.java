package com.mysite.reactboardsection.board;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;
	
	public BoardServiceImpl(BoardMapper mapper) {
		this.mapper = mapper;
	}


	@Override
	public int getCount() {
		int res = mapper.getCount();
		return res;
	}
	
	@Override
	public List<BoardVO> getBoardList(int page_num, int limit) {
		int start = (page_num - 1) * limit;
//		System.out.println("start : "+ start);
//		System.out.println("limit : "+ limit);
		List<BoardVO> boardlist = mapper.getBoardList(start, limit);
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
