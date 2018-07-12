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
			$.getJSON("../record.do",parma,function(data){
				console.log(data);
				$("#tab").find("tr:gt(0)").remove();
				$.each(data,function(i,k){	
					    var type1 = "支取";
						var $tr = $("<tr></tr>");
						$("<td>"+(i+1)+"</td>").appendTo($tr);
						$("<td>"+k.cnum+"</td>").appendTo($tr);
						$("<td>"+k.data+"</td>").appendTo($tr);
						if(k.type==1) type1="存入";
						$("<td>"+type1+"</td>").appendTo($tr);
						$("<td>"+k.money+"</td>").appendTo($tr);
						$tr.appendTo($("#tab"));
					
				})
			})
	        }
		})
		
	 
})