package com.mysite.springtest0301;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
create table sungjuk (
		hakbun varchar(4) primary key,
	    irum varchar(10),
	    kor int, 
	    eng int,
	    math int,
	    tot int,
	    avg double,
	    grade varchar(2)
);
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SungjukVO {
	private String hakbun;
	private String irum;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	private String grade;
	
	public void processSungjuk() {
		this.tot = this.kor + this.eng + this.math;
		this.avg = this.tot / 3;
		switch ((int)this.avg / 10) {
		case 10:
		case 9:
			this.grade = "수";
			break;
		case 8:
			this.grade = "우";
			break;
		case 7:
			this.grade = "미";
			break;
		case 6:
			this.grade = "양";
			break;
		default:
			this.grade = "가";
			break;
		}	
	}
}
