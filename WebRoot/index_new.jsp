
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>兼果兼职</title>

<link href="themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="js/speedup.js" type="text/javascript"></script>
<![endif]-->
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/jquery.cookie.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="uploadify/scripts/jquery.uploadify.min.js" type="text/javascript"></script>

<script src="bin/dwz.min.js" type="text/javascript"></script>
<script src="js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("dwz.frag.xml", {
		loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"themes"});
			setTimeout(function() {$("#sidebar .toggleCollapse div").trigger("click");}, 10);
		}
	});
});

	$(document).ready(function(){
			$('.toggleCollapse h2').click(function(){
				var i=$(".toggleCollapse h2").index(this);
				$('.accordion').hide();
				$('.accordion').eq(i).show();

			});
		});
</script>

	<!-- 选项卡 -->
<style><%--
	.hide{
		display: none;
	}
	.toggleCollapse h2{
		    border: 1px solid #b8d0d6;
    margin: 8px 8px;
    padding: 0 5px;
   
    text-align: center;
		}
--%></style>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>
		
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>主菜单</h2>
					<%--<h2>交互</h2>
					<h2>主菜单</h2>
				--%></div>


				<div class="accordion" fillSpace="sidebar">
				
				<div class="accordionHeader">
						<h2><span>Folder</span>结算兼职</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="T_PC_job_City_List_Servlet?city_id=${cityid}" target="navTab" rel="externa2" external="true">待结算兼职</a></li>
							<li><a href="T_PC_job_City_List_OKServlet?city_id=${cityid}" target="navTab" rel="externa3" external="true">已结算兼职</a></li>
						</ul>
					</div>
				
					<div class="accordionHeader">
						<h2><span>Folder</span>工资结算</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="T_user_moneyout_List_Servlet" target="navTab" rel="externa0" external="true">提现申请</a></li>
							<li><a href="T_user_moneyout_List_OK_Servlet?city_id=${cityid}" target="navTab" rel="externa1" external="true">提现完成记录</a></li>
						</ul>
					</div>
					
					<!-- 自用 -->
					<div class="accordionHeader">
						<h2><span>Folder</span>自用</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="T_money_use_Servlet?pageNo=1" target="navTab" rel="externa0" external="true">用户结算</a></li>
						</ul>
					</div>
					
					<!--<div class="accordionHeader">
						<h2><span>Folder</span>推送</h2>
					</div>
				<div class="accordionContent">
						<ul class="tree treeFolder">						
							<li><a href="T_to_push_Servlet?pageNo=1" target="navTab" rel="externa6" external="true">推送消息</a></li>
						</ul>
						<ul class="tree treeFolder">						
							<li><a href="T_feedback_Servlet?pageNo=1" target="navTab" rel="externa6" external="true">意见反馈</a></li>
						</ul>
				</div>
					
					--><!--<div class="accordionHeader">
						<h2><span>Folder</span>用户管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
						
							<li><a href="dc_fenlei/fl_insert.jsp" target="navTab" rel="externa3" external="true">用户增长总数</a></li>
							<li><a href="FL_List_Servlet" target="navTab" rel="externa4" external="true">用户增长详情</a></li>
							<li><a href="TG_List_Servlet" target="navTab" rel="externa5" external="true">用户信息管理</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>推送消息</h2>
						
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
						
							<li><a href="TC_List_Look_Servlet" target="navTab" rel="externa6" external="true">推送消息</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>用户反馈</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
						
							<li><a href="User_List_NO_BOSS_Servlet" target="navTab" rel="externa8" external="true">用户反馈</a></li>
						</ul>
					</div>
				--></div>
<!-- tab -->
				<%--<div class="accordion hide" fillSpace="sidebar">
				1111

				</div>
				<div class="accordion hide" fillSpace="sidebar">
					11222222222222

				</div>


			--%></div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							
						</div>
						<img src="themes/default/images/login_banner.jpg" />
					</div>
					
				</div>
			</div>
		</div>

	</div>


</body>
</html>
