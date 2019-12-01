<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/6
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="static/css/order_analyze.css"/>

    <script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="static/js/jsapi.js"></script>
    <script type="text/javascript" src="static/js/corechart.js"></script>
    <script type="text/javascript" src="static/js/jquery.gvChart-1.0.1.min.js"></script>
    <script type="text/javascript" src="static/js/jquery.ba-resize.min.js"></script>

</head>
<body>

<script type="text/javascript">
    $(document).ready(function () {
        barChart();
    });
</script>

<h2>订单分析</h2>

<div id="main1">

    <div class="row1_1 row1_2 yesterday">
        <h3>昨日订单</h3>
        <div class="order_count">
            <span class="order_title">新增订单数</span>
            <span class="order_value">100</span>
        </div>

        <div class="order_money">
            <span class="order_title">总计金额</span>
            <span class="order_value">500</span>
        </div>
    </div>

    <div class="row1_1 row1_2 week">
        <h3>七日订单</h3>
        <div class="order_count">
            <span class="order_title">新增订单数</span>
            <span class="order_value">100</span>
        </div>

        <div class="order_money">
            <span class="order_title">总计金额</span>
            <span class="order_value">500</span>
        </div>
    </div>

    <div class="row1_1 twoweek">
        <h3>十五日订单</h3>
        <div class="order_count">
            <span class="order_title">新增订单数</span>
            <span class="order_value">100</span>
        </div>

        <div class="order_money">
            <span class="order_title">总计金额</span>
            <span class="order_value">500</span>
        </div>
    </div>

</div>

<h2>上月订单</h2>

<div id="main2">

    <div id="main2_left">

        <div class="row2_1 row2_2">
            <img src="static/image/order_count.svg"/>
            <span class="order_title">订单总计</span>
            <span class="order_value">1000</span>
        </div>

        <div class="row2_1 row2_2">
            <img src="static/image/order_money.svg"/>
            <span class="order_title">订单总金额</span>
            <span class="order_value">10000</span>
        </div>

        <div class="row2_1">
            <img src="static/image/order_charge-back.svg"/>
            <span class="order_title">退单情况</span>
            <span class="order_value">20</span>
        </div>

    </div>

    <div id="main2_right">

        <script type="text/javascript">
            gvChartInit();
            $(document).ready(function(){
                $('#myTable5').gvChart({
                    chartType: 'PieChart',
                    gvSettings: {
                        vAxis: {title: 'No of players'},
                        hAxis: {title: 'Month'},
                        width: 450,
                        height: 300
                    }
                });
            });
        </script>
        <%--饼状图显示--%>
        <table id='myTable5'>
            <caption>上月各菜谱销售情况</caption>
            <thead>
            <tr>
                <th>小炒肉</th>
                <th>酸菜鱼</th>
                <th>西红柿炒蛋</th>
                <th>炒青菜</th>
                <th>水煮肉片</th>
                <th>水蒸蛋</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>1200</th>
                <td>540</td>
                <td>300</td>
                <td>150</td>
                <td>180</td>
                <td>120</td>
            </tr>
            </tbody>
        </table>

    </div>

</div>

<%--柱状图显示--%>
<div id="main3">

    <canvas id="bchart" height="400" width="800">您的浏览器不支持HTML5 Canvas</canvas>

</div>
<script type="text/javascript">

    // 图表数据
    var arrVisitors = new Array();
    arrVisitors[0] = "1, 150";
    arrVisitors[1] = "2, 225";
    arrVisitors[2] = "3, 260";
    arrVisitors[3] = "4, 100";
    arrVisitors[4] = "5, 300";
    arrVisitors[5] = "6, 375";
    arrVisitors[6] = "7, 275";
    arrVisitors[7] = "8, 275";
    arrVisitors[8] = "9, 186";
    arrVisitors[9] = "10, 186";
    arrVisitors[10] = "11, 150";
    arrVisitors[11] = "12, 225";
    arrVisitors[12] = "13, 260";
    arrVisitors[13] = "14, 100";
    arrVisitors[14] = "15, 300";
    arrVisitors[15] = "16, 375";
    arrVisitors[16] = "17, 275";
    arrVisitors[17] = "18, 275";
    arrVisitors[18] = "19, 186";
    arrVisitors[19] = "20, 186";
    arrVisitors[20] = "21, 150";
    arrVisitors[21] = "22, 225";
    arrVisitors[22] = "23, 260";
    arrVisitors[23] = "24, 100";
    arrVisitors[24] = "25, 300";
    arrVisitors[25] = "26, 375";
    arrVisitors[26] = "27, 275";
    arrVisitors[27] = "28, 275";
    arrVisitors[28] = "29, 186";
    arrVisitors[29] = "30, 186";

    var canvas;
    var context;
    // 图表属性
    var cWidth, cHeight, cMargin, cSpace;
    var cMarginSpace, cMarginHeight;
    // 条形图属性
    var bWidth, bMargin, totalBars, maxDataValue;
    var bWidthMargin;
    // 条形动画
    var ctr, numctr, speed;
    // 轴属性
    var totLabelsOnYAxis;
    // 条形图构造函数
    function barChart() {
        canvas = document.getElementById('bchart');
        if (canvas && canvas.getContext) {
            context = canvas.getContext('2d');
        }
        chartSettings();
        drawAxisLabelMarkers();
        drawChartWithAnimation();
    }
    // 初始化图表和条形图值
    function chartSettings() {
        // 图表属性
        cMargin = 25;
        cSpace = 60;
        cHeight = canvas.height - 2 * cMargin - cSpace;
        cWidth = canvas.width - 2 * cMargin - cSpace;
        cMarginSpace = cMargin + cSpace;
        cMarginHeight = cMargin + cHeight;
        // 条形图属性
        bMargin = 15;
        totalBars = arrVisitors.length;
        bWidth = (cWidth / totalBars) - bMargin;
        //找到要在图表上绘制的最大值
        maxDataValue = 0;
        for (var i = 0; i < totalBars; i++) {
            var arrVal = arrVisitors[i].split(",");
            var barVal = parseInt(arrVal[1]);
            if (parseInt(barVal) > parseInt(maxDataValue))
                maxDataValue = barVal;
        }
        totLabelsOnYAxis = 10;
        context.font = "10pt Garamond";

        // 初始化动画变量
        ctr = 0;
        numctr = 100;
        speed = 10;
    }
    // 绘制图表轴、标签和标记
    function drawAxisLabelMarkers() {
        context.lineWidth = "2.0";
        // 绘制y轴
        drawAxis(cMarginSpace, cMarginHeight, cMarginSpace, cMargin);
        //绘制x轴
        drawAxis(cMarginSpace, cMarginHeight, cMarginSpace + cWidth, cMarginHeight);
        context.lineWidth = "1.0";
        drawMarkers();
    }
    //绘制X和Y轴
    function drawAxis(x, y, X, Y) {
        context.beginPath();
        context.moveTo(x, y);
        context.lineTo(X, Y);
        context.closePath();
        context.stroke();
    }
    //在X和Y轴上绘制图表标记
    function drawMarkers() {
        var numMarkers = parseInt(maxDataValue / totLabelsOnYAxis);
        context.textAlign = "right";
        context.fillStyle = "#000";;
        //y轴
        for (var i = 0; i <= totLabelsOnYAxis; i++) {
            markerVal = i * numMarkers;
            markerValHt = i * numMarkers * cHeight;
            var xMarkers = cMarginSpace - 5;
            var yMarkers = cMarginHeight - (markerValHt / maxDataValue);
            context.fillText(markerVal, xMarkers, yMarkers, cSpace);
        }
        //X轴
        context.textAlign = 'center';
        for (var i = 0; i < totalBars; i++) {
            arrval = arrVisitors[i].split(",");
            name = arrval[0];
            markerXPos = cMarginSpace + bMargin
                + (i * (bWidth + bMargin)) + (bWidth/2);
            markerYPos = cMarginHeight + 15; //X轴文字位置
            context.fillText(name, markerXPos, markerYPos, bWidth);
        }
        context.save();
        //添加Y轴标题
        context.translate(cMargin + 10, cHeight / 2);
        context.rotate(Math.PI * -90 / 180);
        context.fillText('每日订单总数', 0, 0);
        context.restore();
        //添加X轴标题
        context.fillText('日', cMarginSpace +
            (cWidth / 2), cMarginHeight + 30 );
    }
    function drawChartWithAnimation() {
        //循环遍历总条并绘制
        for (var i = 0; i < totalBars; i++) {
            var arrVal = arrVisitors[i].split(",");
            bVal = parseInt(arrVal[1]);
            bHt = (bVal * cHeight / maxDataValue) / numctr * ctr;
            bX = cMarginSpace + (i * (bWidth + bMargin)) + bMargin;
            bY = cMarginHeight - bHt - 2;
            drawRectangle(bX, bY, bWidth, bHt, true);
        }
        // 超时运行并检查是否已达到条
        // 所需高度；如果不是，则继续增长
        if (ctr < numctr) {
            ctr = ctr + 1;
            setTimeout(arguments.callee, speed);
        }
    }
    function drawRectangle(x, y, w, h, fill) {
        context.beginPath();
        context.rect(x, y, w, h);
        context.closePath();
        context.stroke();
        if (fill) {
            var gradient = context.createLinearGradient(0, 0, 0, 300);
            gradient.addColorStop(0, 'yellow');
            //gradient.addColorStop(1, 'rgba(67,203,36,.15)');
            gradient.addColorStop(1, 'red');
            context.fillStyle = gradient;
            context.strokeStyle = gradient;
            context.fill();
        }
    }
</script>

</body>
</html>
