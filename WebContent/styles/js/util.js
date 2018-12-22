document.ondblclick=function(){
	return false;
}
Number.prototype.$toString = function (num) {
	var wc = "" + this, s = wc.match(/^(\d+)(\.\d+)?$/);
	return s[1].split("").reverse().join("").replace(/(\d{3})(?=\d)/g, "$1,").split("").reverse().join("") +
		s[2].substring(0, num ? num + 1 : s[2].length);
};
String.prototype.$toString = function (num) {
	var wc = "" + Number(this), s = wc.match(/^(\d+)(\.\d+)?$/);
	return s ? s[1].split("").reverse().join("").replace(/(\d{3})(?=\d)/g, "$1,").split("").reverse().join("") +
		s[2].substring(0, num ? num + 1 : s[2].length) : "";
};
function formatNum(ob,s,n){
	ob.innerText=s.$toString(n);
}
var checknum="";
function checknumProcess(request){
	checknum = request.responseText;
	var xmlDoc = request.responseXML;
	var messageTags = xmlDoc.getElementsByTagName("message");
	if(messageTags[0]){
		if(messageTags[0].firstChild){
		var message = messageTags[0].firstChild.nodeValue;
				alert(message);
		}
	} 
}
function jasperEncode(src){
	src = src.replace(/%/g, "%25");
	src = src.replace(/\&/g,"%26");
	src = src.replace(/\?/g,"%3F");
	return src;
}
function multiSpaceToOneSpacee(ob){
	var src = ob.value;
	ob.value = src.replace(/\s{2,}/g, " ");
}

function jasperPageEncode(src){
	src = src.replace(/'/g, "\\'");
	return src;
}
function makeUppercase(ob) {
	if(ob.value){
		ob.value = ob.value.toUpperCase();
	}
}
function initListTable(id){
	var ob = $(id);
	var firstChild = ob.firstChild;
	for(;firstChild!=ob.lastChild;){
		ob.removeChild(ob.lastChild);
	}
}
function selectAll(e, itemName)
{
  var aa = document.getElementsByName(itemName);
  for (var i=0; i<aa.length; i++){
  	 aa[i].checked = e.checked;
   }
}

function alarmDate(ob,date)
	{
		if(!ob.checked){
			$("arrivedate").value="";
			return ;
		}
		if(!checkdate_bak($("accidentdate"))){
			return;
		}
		var datestr = $("accidentdate").value;
		var dates = datestr.split("-");
		var a = new Date(new Number(dates[0]),new Number(dates[1])-1,new Number(dates[2]));
		var b = a.getTime();
		b = b + date * 24 * 60 * 60 * 1000;
		a = new Date(b);
		$("arrivedate").value = a.getFullYear() + "-" + (a.getMonth() + 1) + "-" + a.getDate(); 
	}
function checkdate_bak(ob){
	var dateStr = ob.value;
	var temp="";
	
	if(!(/\d\d\d\d-[01]{0,1}\d-[0123]{0,1}\d/.test(dateStr))){
		if((/\d\d\d\d[01]\d[0123]\d/.test(dateStr))){
			temp+=dateStr.substr(0,4);
			temp+="-";
			temp+=dateStr.substr(4,2);
			temp+="-";
			temp+=dateStr.substr(6,2);
			ob.value=temp;
			return true;
		}else{
			alert("请输入正确的日期格式");
			//ob.focus();
			return false;
		}
	}else{
		return true;
	}

}
function nullToNone(ob){
	return ob?ob:"&nbsp;";
}
function isEmpty(ob){
	return ob?false:true;
}
function checkEmpty(ids,names){
	if(ids.length!=names.length){
		alert("数据不对称！");
		return false;
	}
	for(var i=0;i<ids.length;i++){
		if (typeof(ids[i])== "object"){
			if("payamountpayamountbfeeamounta".indexOf(ids[i].name)!=-1){
				if(parseFloat(ids[i].value)==0){
					return false;
				}else {
					return true;
				}
			} else if(!(ids[i].value)){
				alert(names[i]+"不能为空！");
				if(ids[i].type!='hidden'){
					ids[i].focus();
				}
				return false;
			}
		}else {
			if($(ids[i])){
				if(!($(ids[i]).value)){
					alert(names[i]+"不能为空！");
					if($(ids[i]).type!='hidden'){
						$(ids[i]).focus();
					}
					return false;
				}
			}
		}
	}
	return true;
}
function mouseover(ob){
	ob.style.background="red";
}
function mouseout(ob){
 ob.style.background="";
}
function formatFloat(src, pos,ob){
	var result=0.00;
	try{
     result = Math.round(src*Math.pow(10, pos))/Math.pow(10, pos)*1;
     if(!result ||result=='Infinity'){
     	result =0.00;
     }
	}catch(e){
		result =0.00;
	}
	try{
		ob = result.toFixed(pos);
	}catch(s){
	}
	return parseFloat(result);
}

function formatFloat2(src,pos){
	var result=0.00;
	try{
     result = Math.round(src*Math.pow(10, pos))/Math.pow(10, pos)*1;
     if(!result ||result=='Infinity'){
     	result =0.00;
     }
	}catch(e){
		result =0.00;
	}
	try{
		result = result.toFixed(pos);
	}catch(s){
	}
	return parseFloat(result);
}
function AjaxProcess(saveUrl){
	this.saveUrl= saveUrl;
	this.processflag=true;
	this.failureProcess=function(response){
		var xmlDoc = response.responseXML;
		//alert(xmlDoc.xml);
		var messageTags = xmlDoc.getElementsByTagName("message");
		if(messageTags[0]){
			if(messageTags[0].firstChild){
			var message = messageTags[0].firstChild.nodeValue;
					alert(message);
			}
		}
	};
	this.defaultCallback=function(response){
		var freshflag = false;
		var xmlDoc = response.responseXML;
		//alert(xmlDoc.xml);
		var messageTags = xmlDoc.getElementsByTagName("message");
		
		var records = xmlDoc.getElementsByTagName("record");
		if(!records){
			 alert(response.responseText);
		}
		for(var i = 0; i < records.length; i++){
			var record = records[i];
			var items = record.getElementsByTagName("item");
			for(var j=0;j<items.length;j++){
				try{
						//alert(items[j].getAttribute("name"));
						if(items[j].firstChild){
							if($(items[j].getAttribute("name")).type=="checkbox"){
								if(items[j].firstChild.nodeValue=="0"){
									$(items[j].getAttribute("name")).checked=false;
								}else{
									$(items[j].getAttribute("name")).checked=true;
								}
							}else{
								$(items[j].getAttribute("name")).value=items[j].firstChild.nodeValue;
							}
						} else{
							$(items[j].getAttribute("name")).value= "";
						}
					}catch(e){
						//alert(items[j].getAttribute("name")+e);
					}
			}
		}
		if(messageTags[0]){
			if(messageTags[0].firstChild){
			var message = messageTags[0].firstChild.nodeValue;
					alert(message);
			}
		}
		try{
		if(fresh){
			fresh();
		}
		}catch(e){
			
		}
		if(extendProcess){
			extendProcess();
		}
	};
	this.saveOreadInfo = function(dataStr,callBack){
		if(!this.processflag){
			alert("系统正在运行！！！");
			return;
		}
		var process = null;
		if(callBack){
			process=callBack;
		}else{
			process = this.defaultCallback;
		}
		new Ajax.Request(this.saveUrl,{onSuccess:process,asynchronous: false,onFailure:this.failureProcess,parameters:dataStr});	
	};
	this.readList = function(dataStr,callBack){
		new Ajax.Request(this.saveUrl,{onSuccess:callBack,asynchronous: false,onFailure:this.failureProcess,parameters:dataStr});
	};
}

function createQuery_g(id){
	var tagSourse = $(id);
	var tags = tagSourse.getElementsByTagName("input");
	var tag = null;
	var resultStr = "";
	if (tags){
		for(i =0 ;i<tags.length;i++){
			tag = tags[i];
			if (tag.type=='text' || tag.type=='hidden'|| tag.type=='password'){
				resultStr +=tag.name+"="+jasperEncode(tag.value)+"&";
			}else if(tag.type=='checkbox'){
				//alert(tag.checked+"@"+tag.name+"@"+tag.value);
				if(tag.checked){
					resultStr +=tag.name+"="+tag.value+"&";
				}else{
					resultStr +=tag.name+"=0&";
				}
			}
			else if(tag.type=='radio'){
				if(tag.checked){
					resultStr +=tag.name+"="+tag.value+"&";
				}
			}
		}
	}
	tags = tagSourse.getElementsByTagName("TEXTAREA");
	if (tags){
		for(i =0 ;i<tags.length;i++){
			tag = tags[i];
			resultStr +=tag.name+"="+jasperEncode(tag.value)+"&";
		}
	}
	tags = tagSourse.getElementsByTagName("SELECT");
	if (tags){
		for(i =0 ;i<tags.length;i++){
			tag = tags[i];
			resultStr +=tag.name+"="+jasperEncode(tag.value)+"&";
		}
	}
	return resultStr;
}

function clearPage_g(id){
	var tagSourse = $(id);
	var tags = tagSourse.getElementsByTagName("INPUT");
	var tag = null;
	if (tags){
		for(i =0 ;i<tags.length;i++){
			tag = tags[i];
			if (tag.type=='text' || tag.type=='hidden'|| tag.type=='password'){
				tag.value="";
			}else if(tag.type=='checkbox'){
				tag.checked =false;
			}
		}
	}
	tags = tagSourse.getElementsByTagName("TEXTAREA");
	if (tags){
		for(i =0 ;i<tags.length;i++){
			tag = tags[i];
			tag.value="";
		}
	}
	tags = tagSourse.getElementsByTagName("SELECT");
	if (tags){
		for(i =0 ;i<tags.length;i++){
			tag = tags[i];
			tag.value+"";
		}
	}
}

function getInputsById(id){
	var ss = $(id);
	var inputs= new Array();
	var tags = ss.getElementsByTagName("input");
	if(tags)
	for(i =0 ;i<tags.length;i++){
		inputs[tags[i].name]=tags[i];
	}
	tags = ss.getElementsByTagName("textarea");
	if(tags)
	for(i =0 ;i<tags.length;i++){
		inputs[tags[i].name]=tags[i];
	}
	return inputs;
}
function PageInfo (action,records,pagenumId,callBack,suffix){
		if(!suffix){
			suffix="";
		}
		this.pageHtml="<div style='display:; position:absolute;"+
		"right:0px '><div class='pagecss' id='"+pagenumId+"' >1/1</div><div class='pagecss' onclick='first"+suffix+"();' >"+
		"第一页</div><div class='pagecss' onclick='prev"+suffix+"();'>上一页</div><div class='pagecss' onclick='next"+suffix+"();'>"+
		"下一页</div><div class='pagecss' onclick='end"+suffix+"();'>末一页</div><div class='pagecss'>跳至"+
		"<input type='text' style='width:20px; height:8px;font-size:9px;' onblur='jump"+suffix+"(this);' /></div></div> ";
		this.records=records;
		this.pages=1;
		this.crurentPage=1;
		this.action=action;
		this.pagenumId=pagenumId;
		this.callBack=callBack;
		this.updataPageInfo=function(){
			$(this.pagenumId).innerHTML=""+this.currentPage+"/"+this.pages;
		};
		this.setAction=function(action){
			this.action=action;
		};
		this.setRecords=function (records){
			this.records=records;
		};
		this.setPages=function(pages){
			this.pages=pages;
		};
		this.setCurrentPage=function(paramPage){
			if(paramPage>this.pages){
				this.currentPage=this.pages
			}
			this.currentPage=paramPage;
		};
		this.getRecords=function (){
			return this.records;
		};
		this.getPages=function(){
			return this.pages;
		};
		this.getCrurentPage=function(){
			return this.crurentPage;
		};
		this.add=function(){
			this.records++;
		};
		this.writePageHtml = function(id){
			$(id).innerHTML=this.pageHtml;
		};
		this.next=function(dataStr){
			this.currentPage++;
			if(this.currentPage>this.pages){
				this.currentPage=this.pages;
			}
			dataStr+="currentPage="+this.currentPage+"&records="+this.records+"&";
			new Ajax.Request(this.action,{onSuccess:this.callBack,parameters:dataStr});
		};
		this.prev=function(dataStr){
			this.currentPage--;
			if(!this.currentPage){
				this.currentPage=1;
			}
			dataStr+="currentPage="+this.currentPage+"&records="+this.records+"&";
			new Ajax.Request(this.action,{onSuccess:this.callBack,parameters:dataStr});
		};
		this.first=function(dataStr){
			this.currentPage=1;
			dataStr+="currentPage="+this.currentPage+"&records="+this.records+"&";
			//alert(dataStr);
			new Ajax.Request(this.action,{onSuccess:this.callBack,parameters:dataStr});
		};
		this.end=function(dataStr){
			this.currentPage=this.pages;
			dataStr+="currentPage="+this.currentPage+"&records="+this.records+"&";
			new Ajax.Request(this.action,{onSuccess:this.callBack,parameters:dataStr});
		};
		this.fresh=function(dataStr){
			if(!this.currentPage){
				this.currentPage=1;
			}
			dataStr+="currentPage="+this.currentPage+"&records="+this.records+"&";
			new Ajax.Request(this.action,{onSuccess:this.callBack,parameters:dataStr+"&"});
		}
	};