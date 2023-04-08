package com.mysite.reactboardsection.board;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Paging {
	private int page_num;
	private int limit;
}
