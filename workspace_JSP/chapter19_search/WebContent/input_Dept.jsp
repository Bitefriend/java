<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{
		width: 800px;
		text-align: center;
		margin: auto;
	}
	table {
		width: 100%;
		border-collapse: collapse;
		
	}
	th, td{
		border: 1px solid gray;
	}
	th{
		padding: 5px;
		background-color: darkslateblue;
		color : white;
	}
</style>
<script type="text/javascript">
	function search_dept(f) {
		 /* if (department_id == "") {
			alert("부서를 선택하세요.");
		} */ 
		f.action = '/chapter19_search/Controller';
		f.submit();
	}
</script>
</head>
<body>
	<div>
		<form>
			<h1>부서를 선택하고 검색 버튼을 누르세요</h1>
			<table>
				<tr>
					<th>부서검색</th>
				</tr>
				<tr>
					<td>
						<select name="department_id">
							<option value="">::부서선택::</option>
							<option value="10">10</option>
							<option value="20">20</option>
							<option value="30">30</option>
							<option value="40">40</option>
							<option value="50">50</option>
							<option value="60">60</option>
							<option value="70">70</option>
							<option value="80">80</option>
							<option value="90">90</option>
							<option value="100">100</option>
						</select>
						<input type="button" value="검색" onclick="search_dept(this.form)">
						<input type="hidden" name="cmd" value="deptList">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>