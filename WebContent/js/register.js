   var parma=null;
    var prompt="";
    //添加提示
    function prom(str){
   	 $("#ts").empty();
   	 var $p=$("<p>"+str+"</P>");
   	 $p.appendTo($("#ts"));
    }
  //比较字符串
    function equals(str1, str2)   
    {   
        if(str1 == str2)   
        {   
            return true;   
        }   
        return false;   
    }
    //获得js对象
    function getparma(){    	 
   	 prompt="";
   	 var pw=null;
   	 var name = $("#name").val();
   	 var pw1 =$("#password1").val();
   	 var pw2 =$("#password2").val();
   	 if(name==""){
   		 prompt="用户名不能为空! ";
   	 }
   	 if(pw1==""){
   		 prompt+=" 密码不能为空! ";
   	 }
   	 if(pw2==""){
   		 prompt+=" 确认密码不能为空!";
   	 }
   	 if(equals(pw1, pw2)){
   		 pw=pw1
   	 }else{
   		 prompt+=" 两次密码不一样!";   		 
   	 }
   	 prom(prompt);
   	 
   	 parma={name:name,password:pw};
    }
//主函数
$(function(){
	$("#login").click(function(){
		 window.location.href='index.jsp';    		 
	 })
	 $("#register").click(function(){
		 getparma();
		 $.post("register.do",parma,function(data){
			 if(data == "success"){    				 
				 prompt =" 注册成功请登陆！";
				 prom(prompt);    				 
			 } 
			 if(data == "failure"){    				 
				 prompt =" 用户名已经存在！请重新注册";
				 prom(prompt);    				 
			 }
		 })   		 
	 })
	
})