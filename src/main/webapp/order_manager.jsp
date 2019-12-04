<%@ page import="com.etc.model.ShopEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/24
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="static/css/recipe_manager.css"/>

    <script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="static/js/order_manager.js"></script>

</head>
<body>

    <script type="text/javascript">
        var str = "<tr class=\"firstTr\">\n" +
            "<th width=\"20%\">订单序号</th>\n" +
            "<th width=\"15%\">用户名称</th>\n" +
            "<th width=\"40%\">订单详情</th>\n" +
            "<th width=\"25%\">下单时间</th>\n" +
            "</tr>";
        $.ajax({
            /*header: "Access-Control-Allow-Origin:*",*/
            url: "http://localhost:8002/blm/OrderUndone/getOrderDoneList?shopId=<%=((ShopEntity) session.getAttribute("currentLoginShop")).getShopId()%>",
            type: "GET",
            dataType: 'json',
            success: function (data) {
                for (var i=0; i<data.length; i++) {
                    str += "<tr><td>"+data[i].orderId+"</td>\n" +
                        "<td>"+data[i].userName+"</td>\n" +
                        "<td>"+data[i].recipeName+" X"+data[i].orderRecipeNumber+"</td>\n" +
                        "<td>"+data[i].orderStartTime+"</td></tr>"
                }
                $("#table_Data").html(str);
                goPage(1)
            },
            error: function () {
                alert("数据未加载")
            }

        })
    </script>


    <h2>我的订单 My Order</h2>

    <div class="search">
        <span>订单时间：</span>
        <input type="text" placeholder="筛选选择时间到现在的订单"/>
        <input type="button" value="查询"/>
    </div>
    <!--供应商操作表格-->
    <table class="providerTable" cellpadding="0" cellspacing="0" id="table_Data">

        <%--<%for (int i = 0; i < entities.size(); i++) {
            Set<OrderInfEntity> infEntities = entities.get(i).getOrderInfs();
            StringBuilder builder = new StringBuilder();
            for (OrderInfEntity entity: infEntities) {
                builder.append(entity.getRecipe().getRecipeName()).append("  X").append(entity.getOrderRecipeNumber()).append(",  ");
            }
            builder.deleteCharAt(builder.length()-1);
        %>
        <tr>
            <td><%=entities.get(i).getTemporaryId()%></td>
            <td><%=entities.get(i).getUser().getUserName()%></td>
            <td><%=builder.toString()%></td>
            <td><%=sdf.format(entities.get(i).getOrderFinishTime())%></td>
        </tr>
        <%}%>--%>

    </table>

    <div id="page_nav">

    </div>

</body>
</html>
