/*删除操作的弹出*/
$(function () {
    $('.removeProvider').click(function () {
        $('.fade').css('display', 'block');
        $('#removeRecipe').fadeIn();
    });
});

$(function () {
    $('#no').click(function () {
        $('.fade').css('display', 'none');
        $('#removeRecipe').fadeOut();
    });
});
