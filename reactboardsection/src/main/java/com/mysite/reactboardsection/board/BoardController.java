package com.mysite.reactboardsection.board;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//React는 서버와 Json 형식으로 통신한다.
@RestController
public class BoardController {
	
	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/list")
	public List<BoardVO> getBoardList(@RequestBody Paging pg) {
		List<BoardVO> boardlist = boardService.getBoardList(pg.getPage_num(), pg.getLimit());
		
		return boardlist;
	}
	
	@RequestMapping("/count")
	public int getCount() {
		int res = boardService.getCount();
		
		return res;
	}
	
	@RequestMapping("/insert")
	public int insertBoard(@RequestBody BoardVO vo) {
		int res = boardService.insertBoard(vo);
		
		return res;
	}
	
	@RequestMapping("/detail")
	public BoardVO getDetail(@RequestBody BoardVO vo) {
		BoardVO res = boardService.getDetail(vo);
		
		return res;
	}
	
	@RequestMapping("/update")
	public int modifyBoard(@RequestBody BoardVO vo) {
		int res = boardService.modifyBoard(vo);
		
		return res;
	}
	
	@RequestMapping("/delete")
	public int deleteBoard(@RequestBody BoardVO vo) {
		int res = boardService.deleteBoard(vo);
		
		return res;
	}
	
}
