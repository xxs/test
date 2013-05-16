<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>english - Powered By DEFINEDWEEK</title>
<meta name="Author" content="DEFINEDWEEK Team" />
<meta name="Copyright" content="DEFINEDWEEK" />
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link href="${base}/template/admin/css/base.css" rel="stylesheet" type="text/css" />
<link href="${base}/template/admin/css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/template/common/js/jquery.js"></script>
<script type="text/javascript" src="${base}/template/common/js/jquery.pager.js"></script>
<script type="text/javascript" src="${base}/template/admin/js/base.js"></script>
<script type="text/javascript" src="${base}/template/admin/js/admin.js"></script>
<script type="text/javascript">
$().ready(function() {
	
	var $printButton = $("#printButton");
	
	$printButton.click(function(){
		window.print();
		return false;
	});

})

try {
	var WScriptShell = new ActiveXObject("WScript.Shell");
	WScriptShell.RegWrite("HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header", "");
	WScriptShell.RegWrite("HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer", "");
} catch(e) {

}

</script>
</head>
<body class="list">
	<div class="body">
		<form id="listForm" action="friend_link!list.actio" method="post">
			<table id="listTable" class="listTable">
				<tr>
					<th>
						<a href="#" hidefocus>单词</a>
					</th>
					<th>
						<a href="#" hidefocus>音标</a>
					</th>
					<th>
						<a href="#" id="printButton" hidefocus>含义   [打印]</a>
					</th>
				</tr>
				<#list englishList as english>
					<tr>
						<td>
							${english.word}
						</td>
						<td>
							${english.phonetic}
						</td>
						<td>
							${english.trans}
						</td>
					</tr>
				</#list>
			</table>
		</form>
	</div>
</body>
</html>