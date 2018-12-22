//校验案号是否存在
function checkCaseNumber(casenumber){
	$.post('management/case/check',
			{'casenumber':casenumber},
       function(data){
           if(data.statusCode =='300'){
        	   alertMsg.error(data.message);
        	   $("#casenumber").val("");
        	   $("#shipname").val("");
           }else{
        	   $("#shipname").val(data.message);
           }
	  } ,'json');
	
}