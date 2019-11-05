function func( x){
				return (x>=10)?x:"0"+x;
			}
			function showTime(){
				/*获取所有时间相关信息*/
				var xdate=new Date();
				var xyear=xdate.getFullYear();
				var xmonth=xdate.getMonth()+1;
				var xday=xdate.getDate();
				var xweek=xdate.getDay();
				var week=["日","一","二","三","四","五","六"];
				var xhours=xdate.getHours();
				var xminutes=xdate.getMinutes();
				var xseconds=xdate.getSeconds();
				var str="";
				str=func(xyear)+"年"+func(xmonth)+"月"+func(xday)+"日&nbsp;&nbsp;星期"+week[xweek]+" "+func(xhours)+"时"+func(xminutes)+"分"+func(xseconds)+"秒";
				/*获取str的内容或向id=“showtime”插入内容*/
				document.getElementById("showtime").innerHTML=str;
			}
			/*页面加载完后立即发生*/
			window.onload=showTime;
			window.setInterval(showTime,1000);	
