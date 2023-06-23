<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function login(f) {
		if (f.mid.value == "") {
			alert("아이디 입력");
			f.mid.focus();
			return;
		}
		if (f.mpw.value == "") {
			alert("비번 입력");
			f.mpw.focus();
			return;
		}
		f.action = "/jspTest/MemberController";
		f.submit();
	}
	function view_all() {
		location.href='/jspTest/MainController?cmd=allList';
	}
</script>
<style type="text/css">
 @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap');

        * {
            font-family: 'Noto Sans KR', sans-serif;
        }

        body {
            background-color: #D1B2FF;
        }

        div {
            margin: auto;
            width: 300px;
            background-color: #EEEFF1;
            border-radius: 5px;
            text-align: center;
            padding: 20px;
        }

        input {
            width: 100%;
            padding: 5px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
            
        }

        .in {
            margin-bottom: 10px;
        }

        #btn {
            background-color: #D1B2FF;
            margin-left : 20px;
            color: white;
        }
        #btn2 {
        text-decoration: none;
        margin-left : 20px;
            color: #9B9B9B;
            font-size: 12px;
        }

      
</style>
</head>
<body>
	<div>
		<h2>로그인</h2>
		<form method="post">
			<table>
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="mid" class = "in"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="mpw" class = "in"></td>
					</tr>
					<tr>
						<td colspan="2" >
							<input id="btn" type="button" value="로그인 " onclick="login(this.form)">&nbsp;
							<input id="btn2" type="reset" value="다시 작성"> &nbsp;&nbsp;
							<input id="btn2" type="button" value="목록으로 이동" onclick="view_all()">
							<input type="hidden" name="cmd" value="login">
							
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>