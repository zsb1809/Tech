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
<title></title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>scripts/jquery-eaysui/themes/metro-blue/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>scripts/jquery-eaysui/themes/icon.css">
<!--<link rel="stylesheet" type="text/css" href="../demo.css">-->
<script type="text/javascript" src="<%=basePath %>scripts/jquery-eaysui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>scripts/jquery-eaysui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>scripts/jquery-eaysui/easyui_extend.js"></script>
<style type="text/css">

	/* a {
		text-decoration:none;
		color:black;
	}
 */
	
	body{
		margin: 0px;
	}
	
	li{
		list-style: none;
	}
	
	
</style>
<script type="text/javascript">
 var basePath = '<%=basePath%>';

</script>
</head>

<body>
	
	<table id="grid" class="easyui-datagrid" style="width:700px;height:250px"
            data-options="singleSelect:true,url:'<%=basePath %>zhadmin/expert/experts.do?type=${type}',method:'get',toolbar:toolbar,fit:true">
        <thead>
            <tr>
                <th data-options="field:'id',width:80">ID</th>
                <th data-options="field:'expertName',width:100">专家名称</th>
                <th data-options="field:'categoryId',width:80,align:'right'">所属领域</th>
                <th data-options="field:'teamLeader',width:80,align:'right'">团队带头人</th>
                <th data-options="field:'education',width:250">学历</th>
                <th data-options="field:'phone',width:60,align:'center'">联系电话</th>
                <th data-options="field:'option',width:120,align:'center',formatter:optionFormat">操作</th>
            </tr>
        </thead>
    </table>
    
    <div id="w" class="easyui-window" title="编辑" data-options="iconCls:'icon-save',modal:true,closed:true,minimizable:false,maximizable:false,draggable:false,onClose:onCloseWin" style="width:800px;height:600px;padding:5px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center'" style="padding:10px;">
				<form id="ff" method="post" >
					<!-- 隐藏表单 辅助完成保存或者编辑 -->
					<input type="hidden" name="optType" id="optType"></input>
					<input class="easyui-textbox" type="hidden" name="id" id="id"></input> 
			    	<table cellpadding="5">
			    		<tr>
			    			<td width="60px;">专家姓名:</td>
			    			<td><input class="easyui-textbox" type="text" name="expertName" data-options="required:true,prompt:'名称不能为空'"></input></td>
			    			<td></td>
			    			<td></td>
			    			<td width="60px;">年龄:</td>
			    			<td><input class="easyui-validatebox easyui-textbox" name="age" data-options="validType:'age'"></input></td>
			    		</tr>
			    		<tr>
			    			<td>性别:</td>
			    			<td><select class="easyui-combobox" name="sex"><option value="0">男</option><option value="1">女</option></select></td>
			    			<td></td>
			    			<td></td>
			    			<td>电话:</td>
			    			<td><input class="easyui-textbox" type="text" name="phone"></input></td>
			    		</tr>
			    		<tr>
			    			<td>学历:</td>
			    			<td><input class="easyui-textbox" type="text" name="education"></input></td>
			    			<td></td>
			    			<td></td>
			    			<td>职务:</td>
			    			<td><input class="easyui-textbox" type="text" name="post"></input></td>
			    		</tr>
			    		<tr>
			    			<td>所在地区:</td>
			    			<td><input class="easyui-textbox" name="area"></input></td>
			    			<td></td>
			    			<td></td>
			    			<td>工作经验:</td>
			    			<td><input class="easyui-validatebox easyui-textbox" name="workYear" data-options="validType:'age'"></input></td>
			    		</tr>
			    		<tr>
			    			<td>所在单位:</td>
			    			<td><input class="easyui-textbox" name="company"></input></td>
			    			<td></td>
			    			<td></td>
			    			<td>所属领域:</td>
			    			<td>
			    				<input class="easyui-textbox" name="workField"></input>
			    			</td>
			    		</tr>
			    		<tr>
			    			<td>专家图片</td>
			    			<td colspan="5"><input class="easyui-filebox" name="photoUrl" data-options="prompt:'Choose a file...'" style="width:100%"></td>
			    		</tr>
			    		<tr>
			    			<td>主要成就:</td>
			    			<td><input class="easyui-textbox" name="achievement" data-options="multiline:true" style="height:60px"></input></td>
			    			<td></td>
			    			<td></td>
			    			<td>简介:</td>
			    			<td>
			    				<input class="easyui-textbox" name="synopsis" data-options="multiline:true" style="height:60px"></input>
			    			</td>
			    		
			    		</tr>
			    		<tr>
			    			<td>所属栏目</td>
			    			<td colspan="5">
			    				<ul style="height: 120px;overflow: auto;">
			    					<li><input type="checkbox" name="columnId" value="100"   />国家政策</li>
			    					<li><input type="checkbox" name="columnId" value="101"   />与国家对应的地方政策</li>
			    					<li><input type="checkbox" name="columnId" value="102"   />相关新闻</li>
			    					<li><input type="checkbox" name="columnId" value="103"   />国家形式</li>
			    					<li><input type="checkbox" name="columnId" value="104"   />相关地方形式</li>
			    				</ul>
			    			</td>
			    		</tr>
			    	</table>
	    		</form>
			</div>
			<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:$('#ff').submit();" style="width:80px">提交</a>
				<!-- <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:alert('cancel')" style="width:80px">Cancel</a> -->
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
			var toolbar = [{
				text:'添加',
				iconCls:'icon-add',
				handler:function(){
					$('#w').window('open');
					$('#optType').val('new');
					$('#id').val(0);
				}
			},'-',];
	
			
			
			//表单属性定义
			$('#ff').form({   
			    url:'<%=basePath%>zhadmin/expert/save.do',   
			    onSubmit: function(){   
			    	return $(this).form('enableValidation').form('validate');
			    },   
			    success:function(msg){
			    	var data = eval('(' + msg + ')');
			        $.messager.alert('My Title',data.msg,'info');
			        $('#w').window('close');
			        $('#ff').form('clear');
			    }   
			});
			
			//数据列表“操作栏”格式  其他列要修改格式 也请参考
			function optionFormat(value,row,index){
				
				return '<a href="javascript:void(0);" onclick="edit('+row.id+');">编辑</a>&nbsp;&nbsp;<a href="javascript:void(0);" onclick="removeExpert('+row.id+');">删除</a>';
			}
			
			
			//编辑动作  打开window窗口
			function edit(id){
				//$('#ff').form('clear');
				$('#w').window('open');
				$('#ff').form({onLoadSuccess:loadsucc});  
				$('#ff').form('load', '<%=basePath %>zhadmin/expert/get.do?id='+id);
				$('#optType').val('edit');
				
			}
			
			//删除
			function removeExpert(id){
				$.messager.confirm('删除?', '确定删除吗?', function(r){
					if (r){
						
						$.ajax({
						   type: "POST",
						   url: "<%=basePath %>zhadmin/expert/remove.do?id="+id,
						   success: function(msg){
							   var data = eval('(' + mag + ')');
							   $.messager.show({
									title:'提示',
									msg:data.msg,
									timeout:4000,
									showType:'slide'
								});
						   }
						});
						
					}
				});
			}
		
			
			// 加载完成后的回调函数
		       function loadsucc(data) {  
		        	$.each( data.columnId.split(","), function(i, n){
		        		$("input[name='columnId'][value='"+n+"']").prop("checked","checked");
		        	});
		       } 
			
			
			/*窗口关闭（即点击×号后所要进行的操作）  */
		       function onCloseWin(){
		    	   clearCheckBox("columnId");
		    	   $('#ff').form('clear');
		    	   
		       }
		       //清空checkbox
		       function clearCheckBox(name){
		    	   $("input[name='"+name+"']").each(function(i){
					   $(this).removeProp('checked');
					});
		       }
		       
		      
	</script>
</body>
</html>