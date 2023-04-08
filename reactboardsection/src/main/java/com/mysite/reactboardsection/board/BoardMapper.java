package com.mysite.reactboardsection.board;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BoardMapper {
	
	@Select("SELECT board_num, board_writer, board_title, board_content, date_format(board_date, '%y-%m-%d') " + 
				"as board_date from board_tbl order by board_num desc limit #{start}, #{limit}")
	public List<BoardVO> getBoardList(@Param("start") int start, @Param("limit") int limit);
	
	@Select("Select count(*) as count from board_tbl")	//추가
	public int getCount();
	
	@Insert("insert into board_tbl (board_writer, board_title, board_content) values (#{board_writer}, #{board_title}, #{board_content})")
	public int insertBoard(BoardVO board);
	
	@Select("select board_num, board_writer, board_title, board_content, date_format(board_date, '%y-%m-%d') as board_date from board_tbl where board_num = #{board_num}")
	public BoardVO getDetail(BoardVO board);
	
	@Update("update board_tbl set board_title=#{board_title}, board_content=#{board_content}, board_date=now() where board_num=#{board_num}")
	public int modifyBoard(BoardVO board);
	
	@Delete("delete from board_tbl where board_num = #{board_num}")
	public int deleteBoard(BoardVO board);
	
}
