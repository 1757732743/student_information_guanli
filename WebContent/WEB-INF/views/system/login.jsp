<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="shortcut icon" href="favicon.ico"/>
<link rel="bookmark" href="favicon.ico"/>
<link href="../h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="../h-ui/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="../h-ui/lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="../h-ui/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">

<script type="text/javascript" src="../easyui/jquery.min.js"></script> 
<script type="text/javascript" src="../h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="../h-ui/lib/icheck/jquery.icheck.min.js"></script> 

<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>

//scrit用于编写逻辑
<script type="text/javascript">
	$(function(){
		//点击图片切换验证码，liick就是点击图像。用#代表的是标签的id号哦，
		$("#vcodeImg").click(function(){
			//src就是跳转与资源的链接位置
			this.src="get_cpacha?vl=4&w=160&h=40&t="+new Date().getTime();
		});
		
		//登录
		$("#submitBtn").click(function(){
			var data = $("#form").serialize();
			
			$.ajax({
				type: "post",
				url: "login",
				data: data, 
				dataType: "json", //返回数据类型
				success: function(data){
					//这个就是返回的东西了哦
					if("success" == data.type){
						//这里发生跳转找资源index
						window.parent.location.href = "index";
					} else{
						$.messager.alert("消息提醒", data.msg, "warning");
						$("#vcodeImg").click();//切换验证码
						$("input[name='vcode']").val("");//清空验证码输入框
					} 
				}
				
			});
		});
		
		//设置复选框的样式
		$(".skin-minimal input").iCheck({
			radioClass: 'iradio-blue',
			increaseArea: '25%'
		});
	})
</script> 

//下面这3行可以不要
<title>四川轻化工大学_学生信息管理系统</title>
<meta name="keywords" content="学生信息管理系统">
</head>


//body里面才是界面上真真实实展示的东西
<body>
<div class="header" style="padding: 0;">
	<h2 style="color: white; width: 600px; height: 60px; line-height: 60px; margin: 0 0 0 30px; padding: 0;">四川轻化工大学_学生信息管理系统</h2>
</div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
  <!--表单里面的东西是可以进行提交到服务器的哦 -->
    <form id="form" class="form form-horizontal" method="post">
      <div class=" ">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-8">
          <input id="username" name="username" value="" type="text" placeholder="账户" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-8">
          <input id="password" name="password" value="" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-8 col-offset-3">
          <input class="input-text size-L" name="vcode" type="text" placeholder="请输入验证码" style="width: 200px;">
          <!-- et_cpach资源，在systemcotroller下面哦 -->
          <img title="点击图片切换验证码" id="vcodeImg" src="get_cpacha?vl=4&w=160&h=40"></div>
      </div>
      <!--下面是2个单选按钮 -->
      <div class="mt-20 skin-minimal" style="text-align: center;">
		<div class="radio-box">
			<input type="radio" id="radio-2" name="type" value="2" />
			<label for="radio-1">学生</label>
		</div>
		<div class="radio-box">
			<input type="radio" id="radio-1" checked name="type" value="1" />
			<label for="radio-3">管理员</label>
		</div>
	</div>
      
      <div class="row">
        <div class="formControls col-8 col-offset-3">
       <!-- &nbsp代表的空格 --> 
          <input id="submitBtn" type="button" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">作者:软件工程1811 肖湘政 </div>


</body>
</html>