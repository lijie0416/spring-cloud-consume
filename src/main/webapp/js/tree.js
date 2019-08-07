/**
 * 
 */
$(function(){
	getTreeNode();
});

function getTreeNode(){
	var pageInfo={};
	pageInfo.key="hsubject_247";
	$.post("/subjectTree",pageInfo,function(message){
		var setting = {	
			callback: {
				onClick: nodeOnClick
			}
		};
		var zNodes=message;
		$.fn.zTree.init($("#subjectTree"), setting, zNodes);
		clickFirstNode();
		
	 },"json");
}

function nodeOnClick(event, treeId, treeNode, clickFlag) {
	parent.window.open("content.html?id="+treeNode.id,"rightList");
}

function clickFirstNode(){
	var treeObj = $.fn.zTree.getZTreeObj("subjectTree");
	var nodes = treeObj.getNodes();
	var nodeId=nodes[0].id;
	parent.window.open("content.html?id="+nodeId,"rightList");
}