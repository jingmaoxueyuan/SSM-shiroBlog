const serviceURL = "http://localhost:8080/GruduationProject"
const servicePicURL = "http://localhost:8080/GruduationProject/image"
function successLogin(data) {
    var json = eval(data);
    if (json.code === 100) {
        var loginJson = json.object;
        $('#login').hide();
        $('#register').hide();
        $('#login_in').show();
        $('#login_out').show();
        alert('登陆成功');
        $('#login_in').text('欢迎：' + loginJson.userName);
    } else {
        alert(json.info);
    }
}

function successRegister(data) {
    var json = eval(data);
    if (json.code === 100) {
        alert(json.info);
    } else if (json.code === 200) {
        alert(json.info)
    } else if (json.code === 201) {
        alert(json.info)
    } else if (json.code === 202) {
        alert(json.info);
    }else{
        alert(json.info);
    }
}

function doGetData(data) {

    var json = eval(data);
    if (json.code === 1) {
        var jsonObject = json.object;
        $('#login').hide();
        $('#register').hide();
        $('#login_in').show();
        $('#login_out').show();
        $('#login_in').text('欢迎：' + jsonObject);
    }
    var jsonUserInfo=json.userInfo;
    $('#name_info').text(jsonUserInfo.nick);
    $('#name_info1').text(jsonUserInfo.remarks);
    $.each(json.labelInfo,function (i,item) {
        var label=$('#label_Info');
        var content="<li><a  onclick='findLabelByBlog("+item.label_Id+")'>"+item.label+" </a></li>"
        label.append(content);
    });
    $.each(json.blogInfo,function (i,item) {
        var label_news=$('#news_content');
        var content_news="<h1><label>"+item.title+"</label></h1>发布人:<label>"+item.userName+"</label><p>"+item.something+"</p><a class='btn btn-link ' onclick='blogEssay("+item.blogId+")'>  Read more »</a>";
        label_news.append(content_news);
    });
}
function  outLogin(data) {
    var json=eval(data);
    if(json.code===1){
        $('#login').show();
        $('#register').show();
        $('#login_in').hide();
        $('#login_out').hide();
        alert('退出成功');
    }
}

function  outLoginAdmin(data) {
    var json=eval(data);
    if(json.code===1){
        $('#login').show();
        $('#register').show();
        $('#login_in').hide();
        $('#login_out').hide();
        window.location.href="../index.html";
        alert('退出成功');
    }
}

function blogEssay(BlogId) {
//离用ID寻找文章，前写个前端
    window.location.href="./blog-content.html";
    var storage=window.localStorage;
    storage["a"]=BlogId;
}
function findLabelByBlog(label_Id) {
    $.ajax({
        type:"GET",
        url:serviceURL+"/api/findLabelByBlog.do?label_Id="+label_Id+"",
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        xhrFields:{
            withCredentials:true
        },success:function (data) {
            $('#news_content').empty();
            var json=eval(data)
            $.each(json.blogInfo,function (i,item) {
                var label_news=$('#news_content');
                var content_news="<h1><label>"+item.title+"</label></h1>发布人:<label>"+item.userName+"</label><p>"+item.something+"</p><a class='btn btn-link ' onclick='blogEssay("+item.blogId+")'>  Read more »</a>";
                label_news.append(content_news);

            });
        }
    });
}