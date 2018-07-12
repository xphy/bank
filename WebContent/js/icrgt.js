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
    	 prompt="";
    	 var uid1 =window.location.search;
    	 var uid = uid1.split("=")[1];
    	 var bank=$(".bank select").val();
    	 var icnum = $("#icnum").val();
    	 var date =$("#date").val();
    	 var money = $("#money").val();
    	 if(bank == "0"){
    		 prompt ="开户行不能为空! ";
    		 bool =false;
    	 }
    	 if(icnum==""){
    		 prompt +="卡号不能为空! ";
    		 bool =false;
    	 }
    	 if(date==""){
    		 prompt+=" 开卡日期不能为空! ";
    		 bool =false;
    	 }
    	 if(money==""){
    		 prompt+=" 初始金额不能为空!";
    		 bool =false;
    	 }
    	 prom(prompt);
    	 parma={uid:uid,bank:bank,icnum:icnum,date:date,money:money};
    	
     }
     //注册银行卡
     function ic(){
    	 $("#login").click(function(){    		 
    		 getparma();
    		 if(bool){
    			 $.post("../icrgt.do",parma,function(data){
    				 if(data){
    					 prompt ="银行卡注册成功!";
    					 prom(prompt);    		
    				 }else{
    					 prompt ="银行卡注册失败!";
    					 prom(prompt);    
    				 }
    			 })
    		 }
    		 
    	 })
     }
//主要的

$(function(){
	ic();
	
	$.getJSON("../icrgt.do",function(data){
		var $sel=$(".bank select");
		
		$.each(data,function(i,k){
			var $op=$("<option>"+k.bname+"</option>");
			$op.attr("value",k.bid);
			$op.appendTo($sel);
		})
	})
	
})