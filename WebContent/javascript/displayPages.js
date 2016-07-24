function displayPage(url)
{
	var xmlhttp;
	 if (window.XMLHttpRequest)
	 { 
		 xmlhttp=new XMLHttpRequest();
	 }
	 else
	 { 
		 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	 }
	 	xmlhttp.onreadystatechange=function()
	 	{
	 		if (xmlhttp.readyState==4 && xmlhttp.status==200)
	 		{
	 			document.getElementById("mainDiv").innerHTML=xmlhttp.responseText;
	 		}
	 	};
	 	xmlhttp.open("GET",url,true);
	 	xmlhttp.send();	
}

function addPrivileges(url)
{
	var employeeId=document.getElementById('employeeId').value;
	/*alert(url);*/
	if(employeeId==0)
		{
			alert("Please Select Employee");
			return false;
		}
	var selectedcheckbox="";
	
	var elements=document.getElementById('employeePrivileges').elements.length;
	for(var i=0;i<elements;i++)
	{
		var elementtype = document.getElementById('employeePrivileges').elements[i].type;
			if(elementtype=='checkbox')
			{
				if(document.getElementById('employeePrivileges').elements[i].checked==true)
					{
					var checkbox=document.getElementById('employeePrivileges').elements[i].value;
					if(checkbox!='selectAll')
					selectedcheckbox +=checkbox+",";
					}
			}
	}
	if(selectedcheckbox=="")
		{
		alert("Please Select Privileges");
		return false;
		}
/*	alert(selectedcheckbox);*/
	document.forms[0].method="POST";
	document.forms[0].action=url+"?selectedcheckbox="+selectedcheckbox;
	document.forms[0].submit();
}


function selectOrDeselectAll(size)
{
	//alert('hi');
	if(document.getElementById('selectAll').checked)
	{
		for(var i=0;i<size;i++)
		{
			document.getElementById(i).checked=true;
		}
	}
	else
	{
		for(var i=0;i<size;i++)
		{
			document.getElementById(i).checked=false;
		}
	}
}

function showPasswordWindow() 
{
	document.getElementById('passwordDiv').style.display="block";
}

function canclePass()
{
	document.getElementById('passwordDiv').style.display="none";
}

function savePasswordEmp(orgPass,url)
{
	/*alert(url);*/
	var oldPass=document.getElementById('oldPassword').value;
	var newPass=document.getElementById('newPassword').value;
	var conPass=document.getElementById('confirmPassword').value;
	/*alert("textbox "+oldPass);
	alert("db "+orgPass);*/
	
	
	if(oldPass!=orgPass)
		{
			alert('Old Password do not match');
			return false;
		}
	else if(newPass!=conPass)
		{
			alert('Passwords do not match');
			return false;
		}
	else if(oldPass=="" || newPass =="" || conPass=="")
		{
			alert('Please Enter all fields');
		}
	else
		{
		/*alert('in else');
			var xmlhttp;
			 if (window.XMLHttpRequest)
			 { 
				 xmlhttp=new XMLHttpRequest();
			 }
			 else
			 { 
				 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			 }
			 	xmlhttp.onreadystatechange=function()
			 	{
			 		if (xmlhttp.readyState==4 && xmlhttp.status==200)
			 		{
			 		//	document.getElementById("mainDiv").innerHTML=xmlhttp.responseText;
			 		}
			 	};
			 	xmlhttp.open("GET",url+"&conPass="+conPass,true);
			 	xmlhttp.send();	
			}*/
		document.forms[0].action=url+"&conPass="+conPass;
		document.forms[0].method="POST";
		document.forms[0].submit();
		}
}

function displaytabs(url,elementID,newClass)
{
if(elementID=="li1")
	{
	document.getElementById("li2").className = "";
    document.getElementById("li3").className ="";
    document.getElementById(url).style.display="block";
    document.getElementById("supplierAccountsTab").style.display="none";
    document.getElementById("supplierOthersTab").style.display="none";
	}
else if(elementID=="li2")
	{
	document.getElementById("li1").className = "";
    document.getElementById("li3").className ="";
    document.getElementById(url).style.display="block";
    document.getElementById("supplierAddressTab").style.display="none";
    document.getElementById("supplierOthersTab").style.display="none";
	}
else
	{
	document.getElementById("li1").className ="";
    document.getElementById("li2").className ="";
    document.getElementById(url).style.display="block";
    document.getElementById("supplierAddressTab").style.display="none";
    document.getElementById("supplierAccountsTab").style.display="none";
	}
var element=document.getElementById(elementID);
element.setAttribute("class", newClass);
element.setAttribute("className", newClass);

}
function updateDelete(size,url)
{
	if(size>1){
		var selection = document.check.radionm;
	    var a=0;
		for ( var i = 0; i < selection.length; i++)
		{
			if (selection[i].checked == true)
			{
				var Id=selection[i].value;
	             a=1;
	             document.check.method="POST";
	             document.check.action=url+"?Id="+Id;
	             document.check.submit();
			} 
		}
			if(a==0)
			{
			alert("Please select id");
			return false;
			}
		}
		else if(size==1){
			var selection = document.check.radionm;
			if (selection.checked == true)
			{
			    document.check.method="POST";
			    document.check.action=url+"?Id="+selection.value;
			    document.check.submit();
			    return true;
			}
			}
			else{
				alert("The List is Empty");
				return false;
			}
}

function updateShiftDefinition(url,id,idType)
{
	if(null!=document.getElementById("datefrom") && null!=document.getElementById("dateTo"))
	{
	
				var firstValue = document.getElementById("datefrom").value.split('-');
				var secondValue = document.getElementById("dateTo").value.split('-');
				
				 var firstDate=new Date();
				 firstDate.setFullYear(firstValue[2],(firstValue[1] - 1 ),firstValue[0]);
				
				 var secondDate=new Date();
				 secondDate.setFullYear(secondValue[2],(secondValue[1] - 1 ),secondValue[0]);     
				
				  if (firstDate > secondDate)
				  {
				  alert('Start Date Should Be Less Than End Date');
				  return false;
				  }
	}
	
			    document.check.method="POST";
			    document.check.action=url+"?id="+id+"&idType="+idType;
			    document.check.submit();
}

function updatePendingToApproved(url,id)
{
			    document.check.method="POST";
			    document.check.action=url+"?id="+id;
			    document.check.submit();
}



function setProcessDetails(processValue)
{
	document.getElementById("processDetails").value=processValue;
}


function setExpiryDate(expvalue)
{
	document.getElementById("expiryDtApplicable").value=expvalue;
}

function getSelectedEmployeeDetails(url,employeeId)
{
		document.employeeForm.method="POST";
		document.employeeForm.action=url+"?Id="+document.getElementById(employeeId).value;
		document.employeeForm.submit();
}




function setDropDownValue(listValue,inputPath)
{
	
	if(listValue!=0)
		{
		document.getElementById(inputPath).value=listValue;
		}
}


function setRadioButton(radioValue,pathname)
{
	document.getElementById(pathname).value=radioValue;
}

function setCheckbox(checkboxId, inputPath)
{

	if(document.getElementById(checkboxId).checked==true)
		{
		document.getElementById(inputPath).value=1;
		}
	else
		{
		document.getElementById(inputPath).value=0;
		}
}


function setTextarea(textValue,inputpath)
{
	document.getElementById(inputpath).value=textValue;
}


function displayCompanyTabs(url,elementID,newClass)
{

if(elementID=="li1")
	{
	document.getElementById("li2").className = "";
    document.getElementById("li3").className ="";
    document.getElementById("li4").className = "";
    document.getElementById("li5").className ="";
    document.getElementById("companyinfotab").style.display = "block";
    document.getElementById("companyaddresstab").style.display = "none";
    document.getElementById("companysettingstab").style.display = "none";
    document.getElementById("companyothertab").style.display = "none";
    document.getElementById("companylogotab").style.display = "none";
	}
else if(elementID=="li2")
	{
	document.getElementById("li1").className = "";
    document.getElementById("li3").className ="";
    document.getElementById("li4").className = "";
    document.getElementById("li5").className ="";
    document.getElementById("companyinfotab").style.display = "none";
    document.getElementById("companyaddresstab").style.display = "block";
    document.getElementById("companysettingstab").style.display = "none";
    document.getElementById("companyothertab").style.display = "none";
    document.getElementById("companylogotab").style.display = "none";
	}
else if(elementID=="li3")
	{
	document.getElementById("li1").className ="";
    document.getElementById("li2").className ="";
    document.getElementById("li4").className ="";
    document.getElementById("li5").className ="";
    document.getElementById("companyinfotab").style.display = "none";
    document.getElementById("companyaddresstab").style.display = "none";
    document.getElementById("companysettingstab").style.display = "block";
    document.getElementById("companyothertab").style.display = "none";
    document.getElementById("companylogotab").style.display = "none";
	}

else if(elementID=="li4")
{
document.getElementById("li1").className ="";
document.getElementById("li2").className ="";
document.getElementById("li3").className ="";
document.getElementById("li5").className ="";
document.getElementById("companyinfotab").style.display = "none";
document.getElementById("companyaddresstab").style.display = "none";
document.getElementById("companysettingstab").style.display = "none";
document.getElementById("companyothertab").style.display = "block";
document.getElementById("companylogotab").style.display = "none";
}

else if(elementID=="li5")
{
document.getElementById("li1").className ="";
document.getElementById("li2").className ="";
document.getElementById("li3").className ="";
document.getElementById("li4").className ="";
document.getElementById("companyinfotab").style.display = "none";
document.getElementById("companyaddresstab").style.display = "none";
document.getElementById("companysettingstab").style.display = "none";
document.getElementById("companyothertab").style.display = "none";
document.getElementById("companylogotab").style.display = "block";
}

var element = document.getElementById(elementID);
element.setAttribute("class", newClass); //For Most Browsers
element.setAttribute("className", newClass); //For IE; harmless to other browsers.
	
	var xmlhttp;
	 if (window.XMLHttpRequest)
	 { 
		 xmlhttp=new XMLHttpRequest();
	 }
	 else
	 { 
		 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	 }
	 	xmlhttp.onreadystatechange=function()
	 	{
	 		if (xmlhttp.readyState==4 && xmlhttp.status==200)
	 		{
	 			document.getElementById("tabsDiv").innerHTML=xmlhttp.responseText;
	 		}
	 	};
	 	xmlhttp.open("GET",url,true);
	 	xmlhttp.send();	
}

function enableVatNo()
{
	if(document.getElementById("vatApplicable").checked==true)
		{
		document.getElementById("vatNo").disabled=false;
		}
	else
		{
		document.getElementById("vatNo").value="";
		document.getElementById("vatNo").disabled=true;
		}
}

function genericAjaxFunction(url,method,divToBeReplaced)
{						
	/*alert(url);
	alert(method);
	alert(divToBeReplaced);*/
	var xmlhttp;
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById(divToBeReplaced).innerHTML=xmlhttp.responseText;
		}
	};
	xmlhttp.open(method,url,true);
	xmlhttp.send(url);
}


function callPopupWindowWithPost(url,name,method)
{
	/*popupWindowWithPost(url,name,{
	});	*/
	if(method=='POST')
		{
		//alert("post");
		popupWindowWithPost(url,name,{
		});	
		}
	else
		{
		//alert("get");
			window.open(url,"width=260px","scrollbars=no","sizable=yes","toolbar=no","statusbar=no");
		}
}
function popupWindowWithPost(URL,name,PARAMS) {
	//alert(URL);
	var windowoption='height=200px,width=260px,top=350px,left=1050px,scrollbars=no,sizable=yes,toolbar=no,statusbar=no';
	var temp=document.createElement("form");
	temp.action=URL;
	temp.method="POST";
	temp.style.display="none";
	temp.setAttribute("target", name);
	for(var x in PARAMS) {
		var opt=document.createElement("textarea");
		opt.name=x;
		opt.value=PARAMS[x];
		temp.appendChild(opt);
	}
	document.body.appendChild(temp);
	window.open(URL, name, windowoption);
	temp.submit();
    document.body.removeChild(temp);
	return temp;
}


function popupWindowWithPostSize(URL,name,size,PARAMS) {
	
	/*alert(size);*/
	var windowoption=size;
	var temp=document.createElement("form");
	temp.action=URL;
	temp.method="POST";
	temp.style.display="none";
	temp.setAttribute("target", name);
	for(var x in PARAMS) {
		var opt=document.createElement("textarea");
		opt.name=x;
		opt.value=PARAMS[x];
		temp.appendChild(opt);
	}
	document.body.appendChild(temp);
	window.open(URL, name, windowoption);
	temp.submit();
    document.body.removeChild(temp);
	return temp;
}


/*function connectionAjax()
{
	var xmlhttp;
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			alert('ready');
			if(xmlhttp.responseText==document.getElementById("ipAddress"))
				{
				alert("Connection Successfull");
				}
			else
				{
				alert("Connection Failed");
				}
		}
	};
	var url ="testConnection.json";
	var method='POST';
	xmlhttp.open(method,url,true);
	xmlhttp.send(url);
}*/




/*popupWindowWithPost("saveEditBillingItem.json", {
	orderid:orderid,
	itemName:document.getElementById("text1").value,
	quantity:document.getElementById("quantity").value
});*/

function disableStartAndEndTime(value,dateFrom,dateTo)
{
	/*alert(value);*/
	
	if(value==true)
	{
	 document.getElementById(dateFrom).disabled = true;
	 document.getElementById(dateFrom).readOnly = true;
	 document.getElementById(dateTo).disabled = true;
	 document.getElementById(dateTo).readOnly = true;
		document.getElementById("DateToDiv").style.display ='none';
		document.getElementById("DateFromDiv").style.display ='none';
	
	}
else
	{
	 document.getElementById(dateFrom).disabled = false;
	 document.getElementById(dateFrom).readOnly = false;
	 document.getElementById(dateTo).disabled = false;
	 document.getElementById(dateTo).readOnly = false;
	document.getElementById('DateToDiv').style.display = "block";
	document.getElementById('DateFromDiv').style.display = "block";
	
	}
	
}

function showRecurrenceDiv(value)
{
	if(value==true)
	{
		document.getElementById('recurrenceDiv').style.display = "block";
		document.getElementById('recurrenceDivName').style.display = "block";
	}
else
	{
	document.getElementById("recurrenceDiv").style.display ='none';
	document.getElementById("recurrenceDivName").style.display ='none';
	}
}

function showMonthCalenderDiv(url,div,employeeId,iYear,iMonth)
{
	/*alert(url);
	alert(div);
	alert(employeeId);*/
	
	/*if(iYear!=0&&iMonth!=0)
	{
	iMonth=document.getElementById("iMonth").value;	
	iYear=document.getElementById("iYear").value;
	}*/
	if(iYear!=0)
	{
	iYear=document.getElementById("iYear").value;		
	}
	if(iMonth!=0)
	{
	iMonth=document.getElementById("iMonth").value;		
	}
	
	/*alert(iYear);
	alert(iMonth);*/
    var xmlhttp;
    if (window.XMLHttpRequest)
    {
            xmlhttp=new XMLHttpRequest();
    }
    else
    {
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
   
           xmlhttp.onreadystatechange=function()
           {
                   if (xmlhttp.readyState==4 && xmlhttp.status==200)
                   {
                	  /* alert("ready");*/
                   	document.getElementById(div).innerHTML=xmlhttp.responseText;
                   }
           };
           xmlhttp.open("POST",url+"?employeeId="+employeeId+"&iYear="+iYear+"&iMonth="+iMonth,true);
           xmlhttp.send();
}

function goTo(employeeId)
{
	

	/*if(iYear!=0&&iMonth!=0)
		{
		iMonth=document.getElementById("iMonth").value;	
		iYear=document.getElementById("iYear").value;
		}
	else if(iYear!=0)
		{
		iYear=document.getElementById("iYear").value;		
		}
	else if(iMonth!=0)
	{
		iMonth=document.getElementById("iMonth").value;		
	}*/
	
  // document.frm.submit(); 
 // alert('hi');
	/*document.frm.method="POST";
	 document.frm.action="showMonthCalenderDiv.json?employeeId="+employeeId;
	 document.frm.submit();*/
  // showMonthCalenderDiv(employeeId);	
}


function enableDisableBreaks(value,elementsId1,elementsId2)
{
	/*alert(value);*/
	/*alert(document.getElementById("break1").checked);*/
	
		if(value.checked==true)
		{
			if(document.getElementById("break1").checked==true)
			{
				
			document.getElementById(elementsId1).disabled = false;
			document.getElementById(elementsId1).readOnly = false;
			document.getElementById(elementsId2).disabled = false;
			document.getElementById(elementsId2).readOnly = false;
			}
			else
			{	
				value.checked=false;
				alert("Break 2 cannot be defined without break 1");
			}
		}
	else
		{
		 document.getElementById(elementsId1).disabled = true;
		 document.getElementById(elementsId1).readOnly = true;
		 document.getElementById(elementsId2).disabled = true;
		 document.getElementById(elementsId2).readOnly = true;
 		 if(document.getElementById("break1").checked==false)
		 {
			 
			 document.getElementById("break2").checked=false;
			 document.getElementById("break2StartTime").disabled = true;
			 document.getElementById("break2StartTime").readOnly = true;
			 document.getElementById("break2EndTime").disabled = true;
			 document.getElementById("break2EndTime").readOnly = true;
		 }
		 document.getElementById(elementsId1).value =0;
		 document.getElementById(elementsId2).value =0;
		 document.getElementById("break2StartTime").value =0;
		 document.getElementById("break2EndTime").value =0;
		}
}

function enableDisableWeeklyOff(value,elementsId1)
{
	
		if(value.checked==true)
		{
			if(document.getElementById("weeklyOff1").checked==true)
			{
				
			document.getElementById(elementsId1).disabled = false;
			document.getElementById(elementsId1).readOnly = false;
			}
			else
			{	
				value.checked=false;
				alert("Weekly Off 2 cannot be defined without 1");
			}
		}
	else
		{
		 document.getElementById(elementsId1).disabled = true;
		 document.getElementById(elementsId1).readOnly = true;
		 if(document.getElementById("weeklyOff1").checked==false)
		 {
			 document.getElementById("weeklyOff2").checked=false;
			 document.getElementById("weeklyOff2Day").disabled = true;
			 document.getElementById("weeklyOff2Day").readOnly = true;
			 document.getElementById("weeklyOff1Day").value =0;
		 }
		 document.getElementById("weeklyOff2Day").value =0;
		 
		}
}


function showRespectiveDiv(type,url)
{
	
	/*url="showEmployeeTypeView.json?type="+type;*/
	document.getElementById('employeeReportType').value=type;
	var xmlhttp;
	 if (window.XMLHttpRequest)
	 { 
		 xmlhttp=new XMLHttpRequest();
	 }
	 else
	 { 
		 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	 }
	 	xmlhttp.onreadystatechange=function()
	 	{
	 		if (xmlhttp.readyState==4 && xmlhttp.status==200)
	 		{
	 			document.getElementById("SelectEmployeeView").innerHTML=xmlhttp.responseText;
	 		}
	 	};
	 	xmlhttp.open("POST",url+"type="+type,true);
	 	xmlhttp.send();	
		
}

function setShippingLocation()
{
	var value=document.getElementById('billingLocation').value;
	if(setShippLocation.checked==true)
	{
		if(value==0)
		{
			setShippLocation.checked=false;
			alert("Please Select the Billing Location");
		}
		//alert(value);
		else
		{
			document.getElementById('shippinglocation').value=value;
			document.getElementById('shippinglocation').disabled=true;
		}
	}
	else
	{
		document.getElementById('shippinglocation').value=0;
		document.getElementById('shippinglocation').disabled=false;
	}
}

function generateReport(url)
{
	if(null!=document.getElementById("datefrom") && null!=document.getElementById("dateTo"))
		{
		
		var firstValue = document.getElementById("datefrom").value.split('-');
		var secondValue = document.getElementById("dateTo").value.split('-');
		var firstDate=new Date();
		firstDate.setFullYear(firstValue[2],(firstValue[1] - 1 ),firstValue[0]);
	
		var secondDate=new Date();
		secondDate.setFullYear(secondValue[2],(secondValue[1] - 1 ),secondValue[0]);     
		  if (firstDate > secondDate)
		  {
		  alert('Start Date Should Be Less Than End Date');
		  return false;
		  }
		}
	
	if(null!=document.getElementById("allowedTime"))
		{
		url=url+"allowedTime="+document.getElementById("allowedTime").value+"&";
		/*alert(url);*/
		}
	
	
	var empReportType=document.getElementById('employeeReportType').value;
	/*if(null!=document.getElementById('employeeReportType'))
		{		
		}
	else
		{
		alert('Please select the required fields');
		return false;
		}*/
	var selectedcheckbox="";
	var elements=document.getElementById('EmployeeWiseReport').elements.length;
	//alert(elements);
	for(var i=0;i<elements;i++)
		{
		var elementtype = document.getElementById('EmployeeWiseReport').elements[i].type;
		//alert(elementtype);
			if(elementtype=='checkbox')
			{
				if(document.getElementById('EmployeeWiseReport').elements[i].checked==true)
					{
					var checkbox=document.getElementById('EmployeeWiseReport').elements[i].value;
					selectedcheckbox +=checkbox+",";
					}
			}
		}
	//alert(selectedcheckbox);
	if(selectedcheckbox=="" && (empReportType=='multiple'||empReportType==''))
		{
		alert('Select Employees');
		return false;
		}
	else
		{
	/*	alert('else');
		alert(url+"selectedcheckbox="+selectedcheckbox+"&empReportType="+empReportType);*/
		/*document.forms[0].action="generateEmployeeWiseReport.json?selectedcheckbox="+selectedcheckbox+"&empReportType="+empReportType;*/
		if(empReportType=='single')
			{
			if(null==document.getElementById('employeeNo')||document.getElementById('employeeNo').value==0)
				{
				alert('select Employee');
				return false;
				}
			}
		
		document.forms[0].method="POST";
		document.forms[0].action=url+"selectedcheckbox="+selectedcheckbox+"&empReportType="+empReportType;
		document.forms[0].submit();	
		}
}


function workingHoursfunction(){
	var workingHoursTypeArray = document.getElementsByName("workingHoursRadio");
	   for (var i = 0; i < workingHoursTypeArray.length; i++) {
	      if(workingHoursTypeArray[i].checked)
	    	  {
	    	  document.getElementById("workingHoursType").value=workingHoursTypeArray[i].value;
	    	  }
	      
	   }
}

function generateReportForMsg(url,userName)
{
	if(userName=='admin')
		{
			alert("Please login as a User to sent messages");
			return false;
		}
	return generateReport(url);
}

function weeklyTimecardAjax()
{
	var empId=document.getElementById("dailyattendance").value;
	var dateFrom=document.getElementById("datefrom").value;
	var dateTo=document.getElementById("dateTo").value;
	var xmlhttp;
	
	var url="weeklytimecard.json?empId="+empId+"&dateFrom="+dateFrom+"&dateTo="+dateTo;
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("weeklyTimecardDiv").innerHTML=xmlhttp.responseText;
		}
	};
	
	xmlhttp.open("POST",url,true);
	xmlhttp.send(url);
	
}

function presentAbscentAjax()
{
	var employeeNo;
	var xmlhttp;
	var url="generatepresenceabscencechart.json";
	var empReportType=document.getElementById('employeeReportType').value;
	var departmentId=document.getElementById('hiddenDepartmentId').value;
	var dateFrom=document.getElementById('datefrom').value;
	
	if(empReportType=='single')
		{
		employeeNo=document.getElementById('employeeNo').value;
		}
	else
		{
		employeeNo=0;
		}
	
	
	var dateTo=document.getElementById('dateTo').value;
	var selectedcheckbox="";
	var elements=document.getElementById('EmployeeWiseReport').elements.length;
	//alert(elements);
	for(var i=0;i<elements;i++)
		{
		var elementtype = document.getElementById('EmployeeWiseReport').elements[i].type;
		//alert(elementtype);
			if(elementtype=='checkbox')
			{
				if(document.getElementById('EmployeeWiseReport').elements[i].checked==true)
					{
					var checkbox=document.getElementById('EmployeeWiseReport').elements[i].value;
					selectedcheckbox +=checkbox+",";
					}
			}
		}
	
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("presentAbscentDiv").innerHTML=xmlhttp.responseText;
		}
	};
	
	xmlhttp.open("POST",url+"?selectedcheckbox="+selectedcheckbox+"&empReportType="+empReportType+"&departmentId="+departmentId+"&dateFrom="+dateFrom+"&dateTo="+dateTo+"&employeeNo="+employeeNo,true);
	xmlhttp.send(url);
	
}
function generateReportForAbsentPresent(url)
{
	alert(url);
	//var empReportType=document.getElementById('employeeReportType').value;
	var selectedcheckbox="";
	/*var elements=document.getElementById('EmployeeWiseReport').elements.length;
	//alert(elements);
	for(var i=0;i<elements;i++)
		{
		var elementtype = document.getElementById('EmployeeWiseReport').elements[i].type;
		//alert(elementtype);
			if(elementtype=='checkbox')
			{
				if(document.getElementById('EmployeeWiseReport').elements[i].checked==true)
					{
					var checkbox=document.getElementById('EmployeeWiseReport').elements[i].value;
					selectedcheckbox +=checkbox+",";
					}
			}
		}*/
	//alert(selectedcheckbox);
	document.forms[0].method="POST";
	/*document.forms[0].action="generateEmployeeWiseReport.json?selectedcheckbox="+selectedcheckbox+"&empReportType="+empReportType;*/
	document.forms[0].action=url+"selectedcheckbox="+selectedcheckbox+"&empReportType=all";
	document.forms[0].submit();
}

function validateLeaveApplication()
{	

	    var empReportType=document.getElementById('employeeReportType').value;
	    
	    document.getElementById('employeeType').value=empReportType;
		
		var selectedcheckbox="";
		var elements=document.getElementById('leaveForm').elements.length;

		for(var i=0;i<elements;i++)
			{
			var elementtype = document.getElementById('leaveForm').elements[i].type;
				if(elementtype=='checkbox')
				{
					if(document.getElementById('leaveForm').elements[i].checked==true)
						{
						var checkbox=document.getElementById('leaveForm').elements[i].value;
						if(checkbox!='on')
							{
								selectedcheckbox +=checkbox+",";
							}
						}
				}
			}

		if(empReportType=='multiple')
			{
			document.getElementById("multipleSelectedEmployees").value=selectedcheckbox;
			document.getElementById("singleSelectedEmployee").value='';
			}
		
		if(empReportType=='all')
			{
			document.getElementById("multipleSelectedEmployees").value='';
			document.getElementById("singleSelectedEmployee").value='';
			}
		
		if(selectedcheckbox=="" && (empReportType=='multiple'||empReportType==''))
			{
			alert('Select Employees');
			return false;
			}
		else
			{
			if(empReportType=='single')
				{
				if(null==document.getElementById('employeeNo')||document.getElementById('employeeNo').value==0)
					{
					alert('select Employee');
					return false;
					}
					else
						{
						document.getElementById("singleSelectedEmployee").value=document.getElementById('employeeNo').value;
						document.getElementById("multipleSelectedEmployees").value='';
						}
				}
			}
		
		
		
		var RegxSerialNo=/^[0-9.]*$/;
	    if (RegxSerialNo.test(document.getElementById("value_duration").value)) {
	       if(document.getElementById("value_duration").value=="0.0")
	           {
	               alert("Please enter a valid Duration");
	                return false;
	           }
	    }
	    else {
	        alert("Duration not valid");
	        return false;
	    }
		
		    var value_priority=document.getElementById("value_priority").value;
		    if(value_priority=="0")
		    	{
		    	 alert("Priority not valid");
		    	return false;
		    	}

		    var leaveType=document.getElementById("leavetype").value;
		    if(leaveType=="0")
		    	{
		    	 alert("Leave Type not valid");
		    	return false;
		    	}
		    
		    var Regx = /^[A-Za-z0-9 ]*$/;
		    if (Regx.test(document.getElementById("value_subject").value)) {
		       if(document.getElementById("value_subject").value=="")
		           {
		               alert("Please enter a valid Subject");
		                return false;
		           }
		    }
		    else {
		        alert("Subject not valid");
		        return false;
		    }
		    
	    
	    return true;

}


function validateOutOfWork()
{
	alert('hi');
	
	
}

function validateOutOfWorkUserDashBoard()
{
	
	  var toEmployees=document.getElementById("toEmployees").value;
	    if(toEmployees=="")
	    	{
	    	 alert("Please Select Atleast One Employee");
	    	return false;
	    	}
	    
	    
	    if(null!=document.getElementById("datefrom") && null!=document.getElementById("dateTo"))
		{
		
					var firstValue = document.getElementById("datefrom").value.split('-');
					var secondValue = document.getElementById("dateTo").value.split('-');
					
					 var firstDate=new Date();
					 firstDate.setFullYear(firstValue[2],(firstValue[1] - 1 ),firstValue[0]);
					
					 var secondDate=new Date();
					 secondDate.setFullYear(secondValue[2],(secondValue[1] - 1 ),secondValue[0]);     
					
					  if (firstDate > secondDate)
					  {
					  alert('Start Date Should Be Less Than End Date');
					  return false;
					  }
		}
	
	
	
	 var Regx = /^[A-Za-z0-9 ]*$/;
	    if (Regx.test(document.getElementById("subject").value)) {
	       if(document.getElementById("subject").value=="")
	           {
	               alert("Please enter a valid Subject");
	                return false;
	           }
	    }
	    else {
	        alert("Subject not valid");
	        return false;
	    }
}




function home(url,methodType)
{
	document.userDashboard.method=methodType;
	document.userDashboard.action=url;
	document.userDashboard.submit();
	
}


function showStateForSelectedCountry(countryId)
{
alert(countryId);
}

