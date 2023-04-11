package com.mysite.speech;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class RequestEntity {
	private String language = "ko-KR";
	private String completion = "sync";
	private String callback;
	private Map<String, Object> userdata;
	private Boolean wordAlignment = Boolean.TRUE;
	private Boolean fullText = Boolean.TRUE;
	private List<Boosting> boostings;
	private String forbiddens;
	private Diarization diarization;
}
