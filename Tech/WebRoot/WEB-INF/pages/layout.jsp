<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%	
HttpServletRequest httpRequest=(HttpServletRequest)request;
String basePath = "http://" + request.getServerName() //服务器地址  
	+ ":"   
	+ request.getServerPort()          //端口号  
	+ httpRequest.getContextPath()      //项目名称  
	+ "/" ;
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>智华后台管理系统</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>scripts/jquery-eaysui/themes/metro-blue/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>scripts/jquery-eaysui/themes/icon.css">
<!--<link rel="stylesheet" type="text/css" href="../demo.css">-->
<script type="text/javascript" src="<%=basePath %>scripts/jquery-eaysui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>scripts/jquery-eaysui/jquery.easyui.min.js"></script>

<style type="text/css">

	a {
		text-decoration:none;
		color:black;
	}


</style>
<script type="text/javascript">
	var basePath = '<%=basePath%>' ;
</script>


</head>

<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:80px;background:#0B5394;padding:10px;"><p style=" font:Verdana, Geneva, sans-serif; font-size:18px;font-weight: bold;"><font color="#CCCCCC">智华后台管理系统</font></p></div>
	<div data-options="region:'west',split:true" style="width:250px;">
    	<div class="easyui-accordion" data-options="multiple:true" style="width:100%;">
		<div title="专家管理" data-options="iconCls:'icon-ok'" style="overflow:auto;">
				<ul class="easyui-tree">
			<li>
				<span><a href="javascript:addPanel('<%=basePath%>zhadmin/expert/index.do?type=person','个人专家')">个人专家</a></span>
			</li>
			<li>
				<span>专家团队</span>
			</li>
		</ul>
		</div>
		<div title="决策2">
			2
		</div>
		<div title="决策3">
			3
		</div>
		<div title="决策4">
			4
		</div>
		<div title="决策5">
			5
		</div>
	</div>
    
    
    </div>
	<div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="tools:'#tab-tools'" style="width:100%;height:100%">
			
        </div>
    
    
    </div>
    
    
    
    <div id="mm" class="easyui-menu" data-options="onClick:menuHandler" style="width:100px;">
		<div  data-options="name:'close_current'">关闭当前标签</div>
        <div class="menu-sep"></div>
		<div  data-options="name:'close_other'">关闭其他标签</div>
	</div>
    
    
    
    <script type="text/javascript">
		
		function addPanel(url,tabname){
			
			if ($('#tt').tabs('exists', tabname)){
				$('#tt').tabs('select', tabname);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>' ;
				$('#tt').tabs('add',{
					title: tabname,
					content: content,
					closable: true
				});
			}

		}


		$(function(){
			$('.tabs').bind('contextmenu',function(e){
				e.preventDefault();
				$('#mm').menu('show', {
					left: e.pageX,
					top: e.pageY
				});
			});
		});
		
		
		
		function menuHandler(item){
			
			 
			 var title = $('.tabs-selected').text(); 
			 
			 
			 var tab = $('#tt').tabs('getSelected');
			 var index = $('#tt').tabs('getTabIndex',tab);
       		
			 if(item.name=='close_current'){
				 $('#tt').tabs('close',title);			 
			 }else if(item.name=='close_other'){				 
				 $(".tabs li").each(function(index, obj) { 
				 		var uTitle = $(obj).text();
				 		if(uTitle!=title){
							$('#tt').tabs('close',uTitle);
						}
				  });
			 }
			
		}

		
		
		
	</script>
    
    
</body>
</html>