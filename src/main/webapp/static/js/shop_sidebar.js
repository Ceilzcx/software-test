$(function() {
    $("#ul_click").on("click", "li", function() {
        var sId = $(this).data("id"); //获取data-id的值
        window.location.hash = sId; //设置锚点
        loadInner(sId);
    });

    function loadInner(sId) {
        var sId = window.location.hash;
        var path;
        switch(sId) {
            case "#information":
                path = "shop_information.jsp";
                break;
            case "#modify_pwd":
                path = "shop_modify_pwd.jsp";
                break;
            case "":
                path = "setting";
                break;
            default:
                path = "shop_information.jsp";
                break;
        }
        $("#content").load(path); //加载相对应的内容
        $("ul#ul_click").on("click", "li", function () {
            $(this).addClass("click").siblings().removeClass("click");
        });
    }
    var sId = window.location.hash;
    loadInner(sId);

});