<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function search_dynamic(f) {
		f.action = '/chapter19_search/Controller?';
		f.submit();
	}
</script>
</head>
<body>
	<div>
		<form>
			<h1>무엇을 검색 하시겠습니까?</h1>
			<table>
				<tr>
					<th>검색옵션 </th>
				</tr>
				<tr>
					<th> 
					선택검색
					<select>
						<option value="1">아이디</option>
						<option value="2">이름</option>
						<option value="3">부서번호</option>
					</select>
					</th>
				</tr>
				<tr>
					<td>
						<input type="button"value="검색" onclick="search_dynamic(this.form)">
						<input type="hidden"value="cmd" onclick="dynamicList">

					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>