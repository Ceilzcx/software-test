/*$("#order_before>img").click(function () {
    $("#order_before").show();
    $("#order_week_ago").hidden = true;
    $("#order_twoWeek_ago").hidden = true;
});*/

/*$(".order_analyze_title>img").click(function () {
    alert("ok");
    $("#test1").className = "order_indicator_hidden";
    $("#test2").className = "order_indicator_show";
    $("#test3").className = "order_indicator_hidden";

    $("#order_before").show();
    $("#order_week_ago").hidden = true;
    $("#order_twoWeek_ago").hidden = true;
});

$("#order_twoWeek_ago>img").click(function () {

});*/
"use strict";   //声明严格模式

window.onload = function () {
    $("#order_week_ago").hide();
    $("#order_twoWeek_ago").hide();

};

function onclick_before() {
    var before = document.getElementById("order_indicator_before");
    before.className = "order_indicator_show";
    $("#order_before").show();

    var week = document.getElementById("order_indicator_week");
    week.className = "order_indicator_hidden";
    $("#order_week_ago").hide();

    var twoBefore = document.getElementById("order_indicator_twoWeek");
    twoBefore.className = "order_indicator_hidden";
    $("#order_twoWeek_ago").hide();
}

function onclick_week() {
    var week = document.getElementById("order_indicator_week");
    week.className = "order_indicator_show";
    $("#order_week_ago").show();

    var before = document.getElementById("order_indicator_before");
    before.className = "order_indicator_hidden";
    $("#order_before").hide();

    var twoBefore = document.getElementById("order_indicator_twoWeek");
    twoBefore.className = "order_indicator_hidden";
    $("#order_twoWeek_ago").hide();
}

function onclick_twoWeek() {
    var twoWeek = document.getElementById("order_indicator_twoWeek");
    twoWeek.className = "order_indicator_show";
    if ($("#order_twoWeek_ago").css(display) == "none"){
        $("#order_twoWeek_ago").css(display, "block");
        $("#img_twoWeek").src = "../static/image/show_more.png";
    }else {
        $("#order_twoWeek_ago").css(display, "none");
        $("#img_twoWeek").src = "../static/image/show_less.png";
    }
}