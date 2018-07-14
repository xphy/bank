  $(function(){	  
     var id = window.location.search;
     var uid=id.split("=")[1];
     var $i=("<i>"+uid+"</i>");
     $("#uid").append($i);
     var $a1 = $("a:contains('银行卡注册')");
     var $a2 = $("a:contains('银行卡销毁')");
     var $a3 = $("a:contains('存入/支出管理')");
     var $a4 = $("a:contains('交易记录查询')");
     var $a5 = $("a:contains('账户余额查询')");
     var $a6 = $("a:contains('计算器')");
     var a="icRgt.jsp?uid="+uid+"";
     $a1.attr("href",a);
     a="icdel.jsp?uid="+uid+"";
     $a2.attr("href",a);
     a="Access.jsp?uid="+uid+"";
     $a3.attr("href",a);
     a="Record.jsp?uid="+uid+"";
     $a4.attr("href",a);
     a="Ye.jsp?uid="+uid+"";
     $a5.attr("href",a);
     a="Cal.jsp?uid="+uid+"";
     $a6.attr("href",a);
     
  })