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

function goPage(pno) {
    var idTable = document.getElementById("table_Data");
    var rowNum = idTable.rows.length;//获取行数
    var pageSize = 5;//每页显示tr行数
    var totalPage = parseInt((rowNum-1)%pageSize==0 ? (rowNum-1)/pageSize : (rowNum-1)/pageSize+1);//总页数

    var currentPage = pno;//当前页数
    var startRow = (currentPage-1)*pageSize+2;//开始显示时的行数
    var endRow = currentPage*pageSize+1;//结束显示时的行数
    endRow = (endRow > rowNum) ? rowNum : endRow;
    //遍历显示数据实现分页
    for (var i=2;i<(rowNum+1);i++){
        var irow = idTable.rows[i-1];
        if(i >= startRow && i <= endRow){
            irow.style.display = "table-row";
        }
        else {
            irow.style.display = "none";
        }
    }

    var tempStr = "<div class='skipPage'>";
    if(currentPage > 1){
        tempStr += "<span class='btn' href=\"#\" onClick=\"goPage("+(1)+")\">首页</span>";
        tempStr += "<span class='btn' href=\"#\" onClick=\"goPage("+(currentPage-1)+")\">上一页</span>"
    }
    else {
        tempStr += "<span class='btn'>首页</span>";
        tempStr += "<span class='btn'>上一页</span>";
    }

    tempStr += "<span class='btn'>"+currentPage+"/"+totalPage+"</span>";
    if(currentPage < totalPage){
        tempStr += "<span class='btn' href=\"#\" onClick=\"goPage("+(currentPage+1)+")\">下一页</span>";
        tempStr += "<span class='btn' href=\"#\" onClick=\"goPage("+(totalPage)+")\">尾页</span>"
    }
    else{
        tempStr += "<span class='btn'>下一页</span>";
        tempStr += "<span class='btn'>尾页</span>";
    }
    tempStr += "</div>";
    document.getElementById("page_nav").innerHTML = tempStr;
}