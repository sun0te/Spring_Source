<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 연동 테스트</title>
</head>
<body>
<h1>이미지 테스트</h1>
<!-- 스프링부트에서는 resources/static 이 기본 경로로 자동으로 설정이 된다. -->
<!-- 이 경로 하위에 css/js/image와 관련된 파일을 배치하면 된다. -->
<img src = "/images/test1.png" /> <br />
<img src = "/imgs/test2.png" /> <br />
<img src = "/imgs/test3.png" /> <br />
<img src = "./image/test5.png" /> <br />
</body>
</html>