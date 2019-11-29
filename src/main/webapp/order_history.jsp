<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/6
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>店家管理平台</title>

    <link rel="stylesheet" href="static/css/order_history.css"/>

    <script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>

</head>
<body>

    <div id="page1"></div>
    <script>$("#page1").load("header.html")</script>

    <div id="main">

        <div id="page2"></div>
        <script>$("#page2").load("sidebar.html")</script>

        <!--默认为订单信息表-->
        <div id="content">
            <h3>订单管理列表</h3>

            <h4>搜索条件</h4>

            <form action="" id="search">
                <table>
                    <tr>
                        <td class="search_text"><input type="text" placeholder="请输入订单编号"></td>
                        <td class="search_text"><input type="text" placeholder="请输入起始时间"></td>

                        <td class="search_checkBox">
                            <label>状态</label>
                            <select>
                                <option value="已付款">已付款</option>
                                <option value="途中">途中</option>
                                <option value="已送达">已送达</option>
                                <option value="退单">退单</option>
                            </select>
                        </td>

                        <td>其他</td>

                        <td id="search_button"><input type="button" value="确定"></td>
                    </tr>
                </table>
            </form>

            <h4>订单信息</h4>
            <!--链接数据库-->
            <form action="" id="orderDetail">

                <table>
                    <tr id="orderDetail_title">
                        <th>订单编号</th>
                        <th>收件人</th>
                        <th>联系方式</th>
                        <th>送达地址</th>
                        <th>下单时间</th>
                        <th>合计价格</th>
                        <th>内容</th>
                        <th>状态</th>
                        <th>...</th>
                    </tr>

                    <tr>
                        <td>1234567890</td>
                        <td>郑晨鑫</td>
                        <td>15669032560</td>
                        <td>浙江大学城市学院明德1</td>
                        <td>2019-10-22 8:20:00</td>
                        <td>20.0</td>
                        <td>酸菜鱼</td>
                        <td>已支付</td>
                        <td>...</td>
                    </tr>

                </table>

            </form>



        </div>

    </div>

    <div id="footer">

    </div>

</body>
</html>
