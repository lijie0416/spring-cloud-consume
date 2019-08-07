var curPage=0;
var nodeId;
var totleNum;//总页数
$(function(){
	nodeId=GetQueryString("id");
	initData(nodeId);
})


function initData(nodeId){
	var pageInfo={};
	pageInfo.key="hsubject_content_"+nodeId;
	pageInfo.curPage=curPage;
	$.post("/subjectContent",pageInfo,function(message){
		$("#content_table").html("");
		$(message.datas).each(function(i,curObj){
			 var curObj=jQuery.parseJSON(curObj);
			 var from =curObj.from;
			 if(!from){
				 from="";
			 }
			var html='<tr>'+
	            '<td bgcolor="#FFFFFF" style"padding-left:8px;margin:0"><a href="" target="_blank" class="a_left2" style="padding-left: 5px">'+curObj.name+'</a></td>'+
	            '<td align="center" bgcolor="#FFFFFF">'+from+'</td>'+
	            '<td bgcolor="#FFFFFF" style="padding-left:8px;margin:0 ">'+curObj.type+'</td>'+
	            '<td bgcolor="#FFFFFF" style="padding-left:8px;margin:0 ">'+curObj.mbrq+'</td>'+
	            '<td bgcolor="#FFFFFF" style="padding-left:8px;margin:0 ">'+curObj.zzrq+'</td>'+
	            '</tr>';
			$("#content_table").append($(html));
		})
		totleNum=message.totalPageNum;
		$("#totleNum_span").text(message.totalContentNum);
		$("#totle_span").text(message.totalPageNum);
		$("#totles_span").text(message.totalPageNum);
		var curPage=parseInt(message.curPage)+1;
		$("#curPage_span").text(curPage);
		_hasLastNext();
	 },"json");
}

function _hasLastNext(){
	if(curPage==0&&totleNum==1){
		$("#last_span").hide();
		$("#next_span").hide();
	}else if(curPage==0){
		$("#last_span").hide();
	}else if(curPage==totleNum){
		$("#next_span").hide();
	}
}

function goPage(num){
	curPage=num;
	initData(nodeId);
}

function searchPage(){
	var num=$("#cPage").val();
	if(num){
		num=parseInt(num);
		num=num-1;
		curPage=num;
		initData(nodeId);
	}
	
}

function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}

function goLast(){
	curPage=curPage-1;
	goPage(curPage);
}

function goNext(){
	curPage=curPage+1;
	goPage(curPage);
}

function goEnd(){
	var num=totleNum;
	if(num==1){
		num=0;
	}
	goPage(num);
}