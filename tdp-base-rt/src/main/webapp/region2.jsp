<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>
	<script src="http://code.jquery.com/jquery-latest.js"></script>  
	<body>
		<h2>region demo2</h2>
		<select id="provinceId" name="province">
			<option value="-1">--请选择--</option>
		</select>
		<select id="cityId" name="city">
			<option value="-1">--请选择--</option>
		</select>
		<select id="countyId" name="county">
			<option value="-1">--请选择--</option>
		</select>
		<script type="text/javascript">
			var allProvinceURL= 'http://127.0.0.1:8080/tdp-base/region/getAllProvince';
			var pURL = 'http://127.0.0.1:8080/tdp-base/region/getRegionByParentCode';
			var tOpt = '<option value="-1">--请选择--</option>';
			//页面加载完成请求区域数据
			$.ajax({
				type:'POST',
				url:allProvinceURL,
				dataType:'json',
				success:function(data){
					//console.log(data);
					$('#provinceId').append(assembleData(data));
				}
			});
			
			//选择省份数据后加载下一级城市数据
			$('#provinceId').on('change',function(){
				var c = $('#provinceId').val()
				$.ajax({
					type:'POST',
					url:pURL + '/' + c,
					dataType:'json',
					success:function(data){
						//console.log(data);
						$('#countyId').empty().append(tOpt);
						$('#cityId').empty().append(tOpt).append(assembleData(data));
					}
				});
			});
			
			//选择城市数据后加载下一级县区、数据
			$('#cityId').on('change',function(){
				var c = $('#cityId').val()
				$.ajax({
					type:'POST',
					url:pURL + '/' + c,
					dataType:'json',
					success:function(data){
						//console.log(data);
						$('#countyId').empty().append(tOpt).append(assembleData(data));
					}
				});
			});
			
			//解析json数据并返回组装后的option
			function assembleData(data){
				var opt = "",t="";
				$.each(data,function(idx,m){
					//console.log(m.regCode);
					//组装options
					t = '<option value=' + m.regCode + '>' + m.regName + '</option>';
					opt += t;
				});
				return opt;
			}
		</script>
	</body>
</html>
