$(function() {
    $(".li_click").on("click", "li", function() {
        var sId = $(this).data("id"); //获取data-id的值
        window.location.hash = sId; //设置锚点
        loadInner(sId);
    });

    function loadInner(sId) {
        var sId = window.location.hash;
        var path;
        switch(sId) {
            case "#shop_notice":
                path = "shop_notice.jsp";
                break;
            case "#recipe_manager":
                path = "recipe_manager.jsp";
                break;
            case "#order_manager":
                path = "order_manager.jsp";
                break;
            case "#activity_manager":
                path = "activity_manager.jsp";
                break;
            case "#user_analyze":
                path = "user_analyze.jsp";
                break;
            case "#order_analyze":
                path = "order_analyze.jsp";
                break;
            case "#information":
                path = "information.jsp";
                break;
            default:
                path = "shop_notice.jsp";
                break;
        }
        $("#content").load(path); //加载相对应的内容
        $("ul.li_click").on("click", "li", function () {
            $(".li_click").children().removeClass("click");
            $(this).addClass("click");
        });
    }
    var sId = window.location.hash;
    loadInner(sId);

});