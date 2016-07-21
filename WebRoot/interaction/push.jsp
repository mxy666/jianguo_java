<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.jianguo.bean.T_user_moneyout_Bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	
	<head>
		<base href="<%=basePath%>">

		<title>推送</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/common.css"/>
	<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
	
<style type="text/css">
	*{margin:0;padding:0;}	
	body { font-size: 13px; line-height: 130%; padding: 60px }
	#panel { width: 100%; border: 1px solid #a9a9a9 }
	.head { padding: 5px; background: #CAE8EA; cursor: pointer }
	.content { padding: 10px; text-indent: 2em; border-top: 1px solid #a9a9a9;display:block; }
	
</style>





<script type="text/javascript" >
function test(){
	var list = [];
    $('#dg tbody tr.selected').each(function(){
        //获取当前行的第一列子标签里的值（即input标签的值）
        list.push($(this).find('td').eq(2).children().val())
    })
        alert(list); 
} 



	



</script>
</head>

	<body>	
		<form action="T_to_push_Servlet?pageNo=1" method="post">
	<div id="panel">
	<h5 class="head">查询</h5>
	<div class="content" >

	<CENTER>
			<span class="lable">地区：</span>
			
			<input id="cityId" name="cityId" type="text" class="input"  value="${cityId }"/>
			<span class="lable">学校：</span><input id="school" name="school" type="text" class="input"  value="${school}"/></br>
			<span class="lable"style="margin-left:24px;" >性别：</span><input id="sex" name="sex" type="text" class="input"  value="${sex}"/>
			<span class="lable" >电话：</span><input id="tel" name="tel" type="text" class="input"  value="${tel}"/>
			<input id="city_id" name="button" type="submit" class="add" value="查询"/>
			
	</CENTER>
		
	</div>
</div>
</form>
	<table id="dg"  name="grid" class="easyui-datagrid" style="width:1014px;height:424px;" data-options="rownumbers:true,singleSelect:false">  	
      <thead>  
          <tr>
             <th data-options="field:'num',checkbox:true">序号</th>               
             <th data-options="field:'name',width:80">姓名</th>                         
             <th data-options="field:'sex',width:60">性别</th> 
             <th data-options="field:'tel',width:180">电话号码</th>  
             <th data-options="field:'school',width:300">学校</th>               
             <th data-options="field:'city_id',width:350">区域</th>               
          </tr>  
      </thead>  
     <tbody>
       
        	<c:forEach items="${page.list}" var="pushObj"
					varStatus="aa">
					<tr>
						<td >${aa.count}&emsp;</td>						
						<td>${pushObj.name}</td>
						<td> ${pushObj.sex}</td>						
						<td> ${pushObj.tel}</td>
						<td> ${pushObj.school}</td>
						<td> ${pushObj.cityId}</td>				
		
					</tr>
				</c:forEach> 
					<tr><td  align="center" colspan="4">共 ${page.totalPages}页 | 第 ${page.pageNo}页</td>
 				
              
                
     </tbody> 

                
 </table>
    [<a href="T_to_push_Servlet?pageNo=1" >首页</a> 
                | <a href="T_to_push_Servlet?pageNo=${page.prePage }" >上一页</a> | 
                <a href="T_to_push_Servlet?pageNo=${page.nextPage}" >下一页</a> | 
                <a href="T_money_use_Servlet?pageNo=${page.bottomPage}" >末页</a>] 

	<form action="T_pushAction_servlet" method="post">
<div>
<div align="center"> 
		推送内容: <textarea id="message" name="message" cols="40" rows="4"></textarea> 
  <input id="city_id" name="cityId" type="hidden" class="input"  value="${cityId}"/>
  <input id="city_id" name="school" type="hidden" class="input"  value="${school}"/>
  <input id="city_id" name="tel" type="hidden" class="input"  value="${tel}"/>
  <input id="city_id" name="sex" type="hidden" class="input"  value="${sex}"/>
		 推送方式：<select id="cc" name="pushWay" style="width: 200px;">  
			 	<option value="light">极光</option>  
	  		 	<option value="sms">短信</option>  
 	   		  </select> 
 	   	
 		<input id="push" name="push" type="submit" class="add" value="推送"/></div>
</div>

</form>
   </body>
</html>
