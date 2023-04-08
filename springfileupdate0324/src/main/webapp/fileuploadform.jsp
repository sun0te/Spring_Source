<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>File Upload</title>
</head>
<body>
<h2>파일 업로드</h2>
<form action="/upload" method="post" enctype="multipart/form-data">
	<h4>다중 파일 업로드</h4>
	<input type="file" multiple="multiple" name="uploadfiles" />
	<input type="submit" value="전송" />
</form>


</body>
</html>