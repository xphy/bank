     var parma=null;
     

   //获得js对象
     function getparma(){
    	 var uid1 =window.location.search;
    	 var uid = uid1.split("=")[1];
    	 parma={uid:uid};
     }
     function del(cid,money){
    	 var uid1 =window.location.search;
    	 var uid = uid1.split("=")[1];
    	 if(money==0){    		 
    		 $.getJSON("../icdel.do",{cid:cid,uid:uid},function(data){
    			 $.each(data,function(i,k){
    				 if(k.bname==null){
    					 if(k.flag==true) window.location.reload(true);
    					 if(k.flag==false)$tr = $("<tr><td>删除失败</td></tr>");
    					 $tr.appendTo($("#tab"));
    				 }
    			 })
    		 }) 
    	 }else{
    		 var $ts=$("<p>银行卡余额不为0，不能注销</p>");
    		 $("#ts").append($ts);
    	 }
     }

//主要js


$(function(){
	getparma();
	$.getJSON("../icdel.do",parma,function(data){
		$("#tab").find("tr:gt(0)").remove();
		$.each(data,function(i,k){
			if(k.bname !=null){				
				var $tr = $("<tr></tr>");
				$("<td>"+(i+1)+"</td>").appendTo($tr);
				$("<td>"+k.bname+"</td>").appendTo($tr);
				$("<td>"+k.cnum+"</td>").appendTo($tr);
				$("<td>"+k.money+"</td>").appendTo($tr);
				var $a = $("<td class='text-center'><a href='#' onclick='del("+k.cid+","+k.money+")'>注销</a></td>").appendTo($tr);
				$tr.appendTo();
				$tr.appendTo($("#tab"));
			}
		})
	})
	
	 
})