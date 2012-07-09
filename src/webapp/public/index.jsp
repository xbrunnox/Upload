<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<h1>Upload de arquivo</h1>
</head>
<body>
	<div align="center">
		<img src="<c:url value='/public/images/upaupa.jpeg' />"> <br>
		<p>Commons File Upload Example</p>
		<form action="<c:url value='/upload/upload' />" method="POST"
			enctype="multipart/form-data">
			<input type="file" name="foto"><br> <input type="Submit"
				value="Upload File">
		</form>
		<button onclick="window.location.href='<c:url value="/upload/" />';">Upload</button>
	</div>
</body>
</html>