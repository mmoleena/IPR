<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<script language="JavaScript"
src="<%=request.getContextPath()
+ "/scripts/gen_validatorv31.js"%>"
type="text/javascript"></script>
<style type="text/css">
.Title {
font-family: Verdana;
font-weight: bold;
font-size: 8pt
}
.Title1 {
font-family: Verdana;
font-weight: bold;
font-size: 8pt
}
</style>
<script type="text/javascript">
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>
</head>
<body onload="javascript:disableBackButton()">
<body>
    <jsp:include page="Header.jsp"></jsp:include>
<form action="<%=request.getContextPath() + "/LoginAction"%>"
method=post name="login">
<table bgcolor="#698B69" border="1" align="right" bgcolor="white"
width="40%" height='60%'>
<tr>
<td height="120" align="right"></td>
<td>
<table border="0" align="center"
style='position: absolute; top: 270pt; left:
470pt;'>
<tr align="center">
<strong><h3>
&nbsp&nbsp&nbspLogin Form
</h3> </strong>
</tr>
<tr>
<td align='right'>
<span
class="Title">UserID :</span>
</td>
<td>
<input type="text"
name="username">
</td>
</tr>
<tr>
<td align='right'>
<span
class="Title">Password :</span>
</td>
<td>
<input type="password"
name="password">
</td>
</tr>
<tr>
<td colspan="2">
    <div align="center"
class="style11">
<input
type="submit" name="Submit" value="Sign In">
&nbsp;
<input
name="Input2" type="reset" value="Clear">
</div>
</td>
</tr>
<tr>
<td>
&nbsp;
</td>
</tr>
<tr>
<td>
&nbsp;
</td>
<td>
<div align="center">
<a
href="./Recoverpassword.jsp"><strong><font
color="#000000">Forgot Password</font> </strong> </a>
</div>
</td>
<td>
&nbsp;
</td>
</tr>
<tr>
<td>
&nbsp;
</td>
<td>
<div align="center">
<a
href="./RegistrationForm.jsp"><strong><font color="#000000">New Registration.....?</font> </strong> </a>
</div>
</td>
<td>
&nbsp;
</td>
</tr>
</table> </table>
</form>
<script language="JavaScript"
type="text/javascript">
//You should create the validator only after the definition of the HTML form
 var frmvalidator = new Validator("login");
 frmvalidator.addValidation("username","req","Login Name is required");
 frmvalidator.addValidation("username","alpha","Login Name is Only Characters");
 frmvalidator.addValidation("password","req","Password is required");

 </script>
<jsp:include page="Fotter.jsp"></jsp:include>
</body>
</html>
