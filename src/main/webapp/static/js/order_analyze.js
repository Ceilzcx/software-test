"use strict";   //声明严格模式

window.onload = function () {
    $("#order_week_ago").hide();
    $("#order_twoWeek_ago").hide();

};

function onclick_before() {
    var before = document.getElementById("order_indicator_before");

    if ($("#order_before").is(":hidden")) {
        $("#order_before").show();
        before.className = "order_indicator_show";
        $("#image_before").attr("src", "../static/image/show_less.png");
    }else {
        $("#order_before").show();
        before.className = "order_indicator_hidden";
        $("#image_before").attr("src", "../static/image/show_more.png");
    }
}

function onclick_week() {
    var before = document.getElementById("order_indicator_week");

    if ($("#order_week_ago").is(":hidden")) {
        $("#order_week_ago").show();
        before.className = "order_indicator_show";
        $("#image_week").attr("src", "../static/image/show_less.png");
    }else {
        $("#order_week_ago").hide();
        before.className = "order_indicator_hidden";
        $("#image_week").attr("src", "../static/image/show_more.png");
    }
}

function onclick_twoWeek() {
    var before = document.getElementById("order_indicator_twoWeek");

    if ($("#order_twoWeek_ago").is(":hidden")) {
        $("#order_twoWeek_ago").show();
        before.className = "order_indicator_show";
        $("#image_twoWeek").attr("src", "../static/image/show_less.png");
    }else {
        $("#order_twoWeek_ago").hide();
        before.className = "order_indicator_hidden";
        $("#image_twoWeek").attr("src", "../static/image/show_more.png");
    }
}