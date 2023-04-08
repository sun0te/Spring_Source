package com.mysite.springmemberboard.board;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BoardMapper {
	
	@Select("select count(*) from smemberboard")
	public int getListCount();
	
	@Select("select * from smemberboard order by num desc limit #{page}, #{limit}")
	public List<BoardVO> getBoardList(@Param("page") int page, @Param("limit") int limit);
	
	@Select("select IFNULL(max(num), 0) from smemberboard")
	public int getMaxNum();

	@Insert("insert into smemberboard values(null,#{id},#{subject},#{content},#{org_file},"
			+ "#{up_file},#{re_ref},#{re_lev},#{re_seq},#{readcount},now())")
	public boolean boardInsert(BoardVO board); // 원글쓰기
	
	@Update("update smemberboard set readcount=readcount+1 where num=#{num}")
	public void setReadCountUpdate(@Param("num") int num); // 글 조회수 1증가
	
	@Select("select * from smemberboard where num=#{num}")
	public BoardVO getDetail(@Param("num") int num); // 글조회
	
	
}
