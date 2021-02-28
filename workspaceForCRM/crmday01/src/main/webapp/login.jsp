<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
<script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function (){
			/*页面加载完毕之后把文本框内容清空*/
			$("#loginAct").val("");
			$("#loginPwd").val("");
			/*页面加载完毕之后自动获得焦点*/
			$("#loginAct").focus();
			$("#submitBtn").click(function (){
				login();
			})
			//为页面绑定敲回车时间 event的值 表示敲的哪个键
			$(window).keydown(function (event){
				//alert(event.keyCode); 13表示为回车键 验证登录操作
				if (event.keyCode==13){
					login();
				}
			})
		})
		function login() {
			//alert("登录操作");
			//验证账号密码不能为空
			//取得账号密码
			//去除文本的左右空格，使用$.trim(文本)
			var loginAct = $.trim($("#loginAct").val());
			var loginPwd = $.trim($("#loginPwd").val());
			if (loginAct==""||loginPwd==""){
				$("#msg").html("用户名和密码不能为空");
				return false;
			}
			$.ajax({
				url:"settings/user/login.do",
				data:{
					"loginAct":loginAct,
					"loginPwd":loginPwd
				},
				type:"post",//请求方式
				data_type:"json",
				success:function (data){
					/*
						data{
							"success":true/false，
							"msg":错误详细信息
						}
					*
					*/
					//如果登录成功
					if (data.success){
						//成功就加载到工作台的欢迎页面
						alert("给我中！！");
						window.location.href="workbench/index.html";
						console.log("11111");
					//如果登录失败
					}else {
						//失败就返回提示信息
						alert("登录失败");
						$("#msg").html(data.msg);
						console.log(22222222);
					}

				}


			})

		}
	</script>
</head>
<body>
	<div style="position: absolute; top: 0px; left: 0px; width: 60%;">
		<img src="image/IMG_7114.JPG" style="width: 100%; height: 90%; position: relative; top: 50px;">
	</div>
	<div id="top" style="height: 50px; background-color: #3C3C3C; width: 100%;">
		<div style="position: absolute; top: 5px; left: 0px; font-size: 30px; font-weight: 400; color: white; font-family: 'times new roman'">CRM &nbsp;<span style="font-size: 12px;">&copy;2017&nbsp;动力节点</span></div>
	</div>
	
	<div style="position: absolute; top: 120px; right: 100px;width:450px;height:400px;border:1px solid #D5D5D5">
		<div style="position: absolute; top: 0px; right: 60px;">
			<div class="page-header">
				<h1>登录</h1>
			</div>
			<form action="" class="form-horizontal" role="form">
				<div class="form-group form-group-lg">
					<div style="width: 350px;">
						<input class="form-control" type="text" placeholder="用户名" id="loginAct">
					</div>
					<div style="width: 350px; position: relative;top: 20px;">
						<input class="form-control" type="password" placeholder="密码" id="loginPwd">
					</div>
					<div class="checkbox"  style="position: relative;top: 30px; left: 10px;">
						
							<span id="msg" style="color: red"></span>
						
					</div>
					<%--按钮写在表单中 type默认就是submit--%>
					<button type="submit" class="btn btn-primary btn-lg btn-block" id="submitBtn" style="width: 350px; position: relative;top: 45px;">登录</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>