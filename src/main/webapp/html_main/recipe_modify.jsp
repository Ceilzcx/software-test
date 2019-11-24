<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="../static/css/recipe_modify.css"/>

    <script type="text/javascript" src="../static/js/jquery-3.4.1.js"></script>

</head>

<body>

<div id="page1"></div>
<script>$("#page1").load("header.html")</script>

<div id="main">

    <div id="page2"></div>
    <script>$("#page2").load("sidebar.html")</script>

    <div id="content">

        <form id="menu_info" class="menu_form" action="">
            <fieldset>

                <legend>菜谱信息</legend>

                <div class="icon">
                    <input class="name" type="text" name="recipe_name" id="recipe_name" placeholder="名称">
                </div>

                <div class="icon">
                    <input class="price" type="text" name="recipe_price" id="recipe_price"  placeholder="价格">
                </div>

                <div class="icon">
                    <input class="remain" type="text" name="recipe_remain" id="recipe_remain" placeholder="余量">
                </div>

                <div class="icon">
                    <input class="discount" type="text" name="recipe_discount" id="recipe_discount" placeholder="折扣">
                </div>

                <div class="icon">
                    <textarea class="message" name="recipe_notice" id="recipe_notice" placeholder="菜谱描述"></textarea>
                </div>

                <div class="file">
                    <div class="update_file">
                        上传图片<input type="file" name="recipe_image" id="recipe_image" accept="image/*">
                    </div>
                    <div class="file_path">
                        <input type="text"/>
                    </div>

                    <img src="" class="menu_img">
                </div>



                <script>
                    $("#recipe_image").change(function(){
                        $(".menu_img").attr("src",URL.createObjectURL($(this)[0].files[0]));
                    });
                </script>

                <div class="recipe_submit">
                    <button id="back">返回</button>
                    <button id="ok">确认提交</button>
                </div>

            </fieldset>


        </form>

    </div>

</div>

</body>

</html>