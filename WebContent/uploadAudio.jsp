<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Audio Test</title>
</head>
<body>

<form action="addAudio" method="post" enctype="multipart/form-data">

Audio file:<input type="file" name="audio"><br>
<input type="submit" value="Upload">

</form>

<audio controls>
    <source src="http://localhost:8080/MyOnlineLibrary/addAudio.mp3" type="audio/mpeg">
Your browser does not support the audio element.
</audio>

</body>
</html>