     var parma=null;
     var prompt="";
     var bool =true;
     
   //添加提示
     function prom(str){
    	 $("#ts").empty();
    	 var $p=$("<p>"+str+"</P>");
    	 $p.appendTo($("#ts"));
     }
   
   //获得js对象
     function getparma(){
    	 var uid1 =window.location.search;
    	 var uid = uid1.split("=")[1];
    	 var cnum = $("#icnum").val();
    	 if(cnum==""){
    		 prompt +="卡号不能为空! ";
    		 bool =false;
    	 }
    	 prom(prompt)
    	 parma={uid:uid,cnum:cnum};
     }
     

//主要js


$(function(){
	$("#login").click(function(){
		getparma();
	if(bool){
			$.getJSON("../ye.do",parma,function(data){
				$("#tab").find("tr:gt(0)").remove();
				
						var $tr = $("<tr></tr>");
						$("<td>"+data.bname+"</td>").appendTo($tr);
						$("<td>"+data.cnum+"</td>").appendTo($tr);
						$("<td>"+data.money+"</td>").appendTo($tr);
						$tr.appendTo($("#tab"));
				
			})
	        }
		})
		
	 
})