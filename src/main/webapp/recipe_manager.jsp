<%@ page import="com.etc.model.ShopEntity" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/10
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="static/js/recipe_manager.js"></script>

    <link rel="stylesheet" href="static/css/recipe_manager.css"/>

</head>
<body>

       <%-- <%
            RecipeService service = new RecipeService();
            List<RecipeEntity> entities = service.viewRecipes((ShopEntity) session.getAttribute("currentLoginShop"));

        %>--%>

        <script type="text/javascript">
            var str = "<tr class=\"firstTr\">\n" +
                "<th width=\"15%\">菜谱图片</th>\n" +
                "<th width=\"15%\">菜谱名称</th>\n" +
                "<th width=\"12.5%\">价格</th>\n" +
                "<th width=\"12.5%\">月销售</th>\n" +
                "<th width=\"12.5%\">余量</th>\n" +
                "<th width=\"12.5%\">折扣</th>\n" +
                "<th width=\"20%\">操作</th>\n" +
                "</tr>";
            $.ajax({
                /*header: "Access-Control-Allow-Origin:*",*/
                url: "http://localhost:8002/blm/Recipe/getRecipeList?shopId=<%=((ShopEntity) session.getAttribute("currentLoginShop")).getShopId()%>",
                type: "GET",
                dataType: 'json',
                success: function (data) {
                    for (var i=0; i<data.length; i++) {
                        str += "<tr><td><img align=\"center\" style=\"width: 50px;height: 50px\" src=\""+"data:image/png;base64,"+data[i].recipeImage+"\"/></td>";
                        str += "<td>"+data[i].recipeName+"</td>";
                        str += "<td>"+data[i].recipePrice+"</td>";
                        str += "<td>"+data[i].monthlySale+"</td>";
                        str += "<td>"+data[i].recipeRemain+"</td>";
                        str += "<td>"+data[i].recipeDiscount+"</td>";
                        str += "<td><a href=\"#\"><img src=\"static/image/read.png\" alt=\"查看\" title=\"查看\"/></a>\n" +
                            "<a href=\"#\"><img src=\"static/image/modify.png\" alt=\"修改\" title=\"修改\"/></a>\n" +
                            "<a href=\"#\" class=\"removeProvider\"><img src=\"static/image/delete.png\" alt=\"删除\" title=\"删除\"/></a></td></tr>"
                    }
                    $("#table_Data").html(str);
                    goPage(1)
                },
                error: function (e) {
                    alert("数据未加载")
                }

            })
        </script>


        <h2>我的菜谱 My Recipe</h2>

        <div class="search">
            <span>菜谱名称：</span>
            <input type="text" placeholder="请输入菜谱名称"/>
            <input type="button" value="查询"/>
            <a onclick="skiptoRecipeAdd()">添加菜谱</a>
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0" id="table_Data">
            <%--<tr class="firstTr">
                <th width="15%">菜谱图片</th>
                <th width="15%">菜谱名称</th>
                <th width="12.5%">价格</th>
                <th width="12.5%">月销售</th>
                <th width="12.5%">余量</th>
                <th width="12.5%">折扣</th>
                <th width="20%">操作</th>
            </tr>

            <%for (int i = 0; i < entities.size(); i++) {%>
            <tr>
                <td><img align="center" style="width: 50px;height: 50px" src="GetRecipeImgServlet?id=<%=entities.get(i).getRecipeId()%>"></td>
                <td><%=entities.get(i).getRecipeName()%></td>
                <td><%=entities.get(i).getRecipePrice()%></td>
                <td><%=entities.get(i).getMonthlySale()%></td>
                <td><%=entities.get(i).getRecipeRemain()%></td>
                <td><%=entities.get(i).getRecipeDiscount()%></td>
                <td>
                    <a href="#"><img src="static/image/read.png" alt="查看" title="查看"/></a>
                    <a href="#"><img src="static/image/modify.png" alt="修改" title="修改"/></a>
                    <a href="#" class="removeProvider"><img src="static/image/delete.png" alt="删除" title="删除"/></a>
                </td>
            </tr>
            <%}%>--%>

        </table>

        <div id="page_nav">

        </div>

        <!--点击删除按钮后弹出的页面-->
        <div class="fade"></div>
        <div class="remove" id="removeRecipe">
            <div class="removerChild">
                <h2>提示</h2>
                <div class="removeMain" >
                    <p>你确定要删除该菜谱吗？</p>
                    <a href="#" id="yes">确定</a>
                    <a href="#" id="no">取消</a>
                </div>
            </div>
        </div>



</body>
</html>