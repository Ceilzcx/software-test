<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/24
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="static/css/real_order.css"/>

    <script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>

</head>
<body>

<div id="bg">

    <div id="main">

        <div class="title">
            <h2>订单处理</h2>

            <span><a href="sidebar.html">返回</a></span>
            <select id="status">
                <option value="">1</option>
                <option value="">2</option>
                <option value="">3</option>
            </select>
            <span>状态</span>

        </div>

        <div id="content">

            <table>

                <thead>
                <tr>
                    <th width="50%">订单详情</th>
                    <th width="20%">备注</th>
                    <th width="15%">用户</th>
                    <th width="15%">操作</th>
                </tr>
                </thead>

                <tr>
                    <td colspan="5"><div id="blank"></div></td>
                </tr>


                <tbody>

                <tr class="split_row">
                    <td colspan="5">
                        <span class="dealTime">2019-11-22 16:47:22</span>
                        <span class="order_number">订单号：101101010110</span>
                    </td>
                </tr>

                <tr class="order">
                    <td class="order_detail" valign="middle">
                        <div class="order_item">
                            <img src="static/image/icon.jpg">
                        </div>
                        <div class="order_recipe">
                            <span>红烧肉</span>
                        </div>
                        <div class="order_num">
                            <span>×2</span>
                        </div>
                    </td>

                    <td rowspan="1" id="order_remark" class="order_td">
                        <span>多加辣</span>
                    </td>
                    <td rowspan="1" class="order_td">
                        <span>郑晨鑫</span>
                    </td>
                    <td rowspan="1" class="order_td">
                        <div class="order_operation">
                            <button id="ok">完成订单</button>
                            <button id="cancel">取消订单</button>
                        </div>
                    </td>
                </tr>

                </tbody>

            </table>

        </div>

    </div>

</div>

</body>
</html>
