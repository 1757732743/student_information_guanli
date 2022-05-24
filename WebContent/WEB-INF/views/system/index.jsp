<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 这个是导入jstl的标签文件 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 这个是xml文件的约束文档 -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>学生信息管理系统 管理员后台</title>
    <link rel="shortcut icon" href="favicon.ico"/>
	<link rel="bookmark" href="favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="../easyui/css/default.css" />
    <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css" />
    <script type="text/javascript" src="../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='../easyui/js/outlook2.js'> </script>
    <script type="text/javascript">
	 var _menus = {"menus":[
	                       //下面这个就是从域里面拿出来的type,只有管理员才有用户管理这个界面
						<c:if test="${userType == 1}">
						{"menuid":"1","icon":"","menuname":"用户（管理员）管理",
							"menus":[
									{"menuid":"11","menuname":"用户列表","icon":"icon-user-teacher","url":"../user/list"}
								]
						},
						{"menuid":"3","icon":"","menuname":"专业信息管理",
							"menus":[
									{"menuid":"31","menuname":"专业管理","icon":"icon-world","url":"../grade/list"},
								]
						},
						{"menuid":"4","icon":"","menuname":"班级信息管理",
							"menus":[
									{"menuid":"41","menuname":"班级管理","icon":"icon-house","url":"../clazz/list"},
								]
						},
						{"menuid":"5","icon":"","menuname":"教室管理",
							"menus":[
									{"menuid":"51","menuname":"教室列表","icon":"icon-user-teacher","url":"../room/list"}
								]
						},
						{"menuid":"6","icon":"","menuname":"学生信息管理_管理员",
							"menus":[
									{"menuid":"61","menuname":"学生信息管理","icon":"icon-user-teacher","url":"../student_new/list"}
								]
						},
						</c:if>
						
						<c:if test="${userType == 2}">
						{"menuid":"3","icon":"","menuname":"专业信息管理",
							"menus":[
									{"menuid":"31","menuname":"专业管理","icon":"icon-world","url":"../grade/list"},
								]
						},
						{"menuid":"4","icon":"","menuname":"班级信息管理",
							"menus":[
									{"menuid":"41","menuname":"班级管理","icon":"icon-house","url":"../clazz/list"},
								]
						},
						{"menuid":"6","icon":"","menuname":"学生信息管理_管理员",
							"menus":[
									{"menuid":"61","menuname":"学生信息管理","icon":"icon-user-teacher","url":"../student_new/list"}
								]
						},
						</c:if>
	
						
				]};


    </script>

</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
	<noscript>
		<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
		    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
    <div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background:  #7f99be;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <!-- 下面这个就是右上的的您好，后面跟上了一个后退的东西-->
        <c:if test="${userType == 1}">
        <span style="float:right; padding-right:20px;" class="head"><span style="color:red; font-weight:bold;">${user.username}&nbsp;</span>您好&nbsp;&nbsp;&nbsp;<a href="login_out" id="loginOut">安全退出</a></span>
        </c:if>
        <c:if test="${userType == 2}">
        <span style="float:right; padding-right:20px;" class="head"><span style="color:red; font-weight:bold;">${user.sname}&nbsp;</span>您好&nbsp;&nbsp;&nbsp;<a href="login_out" id="loginOut">安全退出</a></span>
        </c:if>
        <span style="padding-left:10px; font-size: 16px; ">四川轻化工大学_学生信息管理系统</span>
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">四川轻化工大学欢迎您！</div>
    </div>
    <div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
	<div id="nav" class="easyui-accordion" fit="true" border="false">
		<!--  导航内容 -->
	</div>
	
    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<jsp:include page="welcome.jsp" />
		</div>
    </div>
	
</body>
</html>