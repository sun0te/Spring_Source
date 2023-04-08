package com.example.springtest0321;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SungjukVO {
	private String hakbun;
	private String irum;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	private String grade;
	
	public void ProcessSungjuk() {
		this.total = this.kor + this.eng + this.math;
		avg = total / 3;
		
		switch((int)avg / 10) {
		case 10:
		case 9:
			grade = "수";
			break;
		case 8:
			grade = "우";
			break;
		case 7:
			grade = "미";
			break;
		case 6:
			grade = "양";
			break;
		default:
			grade = "가";
			break;
		}
	}
	
}
