function getProbing(date) {

    var json = eval(date)
    if (json.code === 200) {
        var jsonobject = json.object;
        $('#admin_nav').text('欢迎:' + jsonobject);
        $('#adminLogin').attr('href', './admin/login.html');
    } else if (json.code === 403) {
        alert('请登录');
    }
}

function getProbingAdmin(date) {

    var json = eval(date)
    if (json.code === 200) {
        var jsonobject = json.object;
        $('#admin_nav').text('欢迎:' + jsonobject);
    } else if (json.code === 403) {
        alert('请登录');
        window.location.replace('../index.html');
    }
}

function uploadPic(date) {
    var json = eval(date);
    if (json.code === 100) {
        var jsonObject = json.object;
        $('#pic').text(jsonObject);

    } else if (json.code === 200) {
        alert(json.info);
    }
}

function userInfo(date) {
    var json = eval(date);
    if (json.code === 100) {
        var jsonObject = json.object;
        $('#inputUser').attr('value', jsonObject.userName);
        $('#picImg').attr('src', servicePicURL + jsonObject.pic);
        $('#inputName').attr('value', jsonObject.nick);
        $('#inputAutograph').attr('value', jsonObject.remarks);

    }
}

function userInfoSubmit(date) {
    var json = eval(date);
    if (json.code === 100) {
        alert(json.info);
    } else if (json.code === 200) {
        alert(json.info);
    } else if (json.code === 202) {
        alert(json.info);
    }
}

function statuschange(date) {
    var json = eval(date);
    if (json.code === 100) {
        alert(json.info);
        $('#content').load('./essay-content.html');
        rows = null;
    } else if (json.code === 200) {
        alert(json.info);
    } else {
        alert(json.info);
    }
}

function deleteStatus(data) {
    var json = eval(data);
    if (json.code === 100) {
        alert(json.info);
        $('#content').load('./essay-content.html');
        rows = null;
    } else if (json.code === 200) {
        alert(json.info);
    } else {
        alert(json.code);
    }
}

function labelData(data) {
    var json = eval(data);
    $.each(json.object, function (i, item) {
        var label = $('#label');
        var content = "<option value='" + item.label_Id + "'>" + item.label + "</option>";
        label.append(content);
    });
}

function essayinsert(data) {
    var json = eval(data);
    if (json.code === 100) {
        alert(json.info);
        $('#content').load('./essay-content.html');
    } else if (json.code === 200) {
        alert(json.info);
    } else {
        alert(json.info);
    }
}

function essayView(data) {
    var json = eval(data);
    if (json.code === 100) {
        var jsonObject = json.object;
        var label = jsonObject.label;
        $('#numberId').attr('value', jsonObject.blogId);
        $('#title').attr('value', jsonObject.title);
        $('#label option:contains(' + label + ')').each(function () {
            if ($(this).text() == label) {
                $(this).attr('selected', true);
            }
        });
        $('#something').attr('value', jsonObject.something);
        ue.ready(function () {
            ue.setContent(jsonObject.content);
        });
        rows = null;
    }
}

function sucessUpdateEssay(data) {
    var json = eval(data);
    if (json.code === 100) {
        alert(json.info);
        $('#content').load('./essay-content.html');
        rows = null;
    } else if (json.code === 200) {
        alert(json.info);
    } else {
        alert(json.info);
    }
}

function successInsertLabel(data) {
    var json = eval(data);
    if (json.code === 100) {
        alert(json.info);
        $('#content').load('./label-content.html');
    } else if (json.code === 200) {
        alert(json.info);
    } else {
        alert(json.info);
    }
}

function successupdateLabel(data) {
    var json = eval(data);
    if (json.code === 100) {
        var jsonObject = json.object;
        $("#labelWindow").slideDown(500);
        $("#backGround").show();
        $('#updateLabelText').attr('value', jsonObject.label);
        $('#updateLabelDate').attr('value', jsonObject.create_Date);
    }
}

function successUpdata(data) {
    var json = eval(data);
    if (json.code === 100) {
        alert(json.info);
        $('#content').load('./label-content.html');
        rows = null
    } else if (json.code === 200) {
        alert(json.info);
    } else {
        alert(json.info);
    }
}

function sucessDelete(data) {
    var json = eval(data);
    if (json.code === 100) {
        alert(json.info);
        $('#content').load('./label-content.html');
        rows = null
    } else if (json.code === 200) {
        alert(json.info);
    } else {
        alert(json.info)
    }

}
function successFindRole(date) {
    var json=eval(date);

    $.each(json.rows,function (i,item) {
        var role_rows=$('#role');
        var role_content="<option value='"+item.role_Id+"'>"+item.role+"</option>";
        role_rows.append(role_content);
    });
    rows=null;

}
function successUpdateUsers(data) {
    var json=eval(data);
    if(json.code===100){
        alert(json.info);
        $('#content').load('./user-content.html');
        rows=null;
    }else{
        alert(json.info);
    }

}
function successDeleteUsers(data) {
    var json=eval(data);
    if(json.code===100){
        alert(json.info);
        $('#content').load('./user-content.html');
        rows=null;
    }else{
        alert(json.info);
    }
}
function successResetting(data) {
    var json=eval(data);
    if(json.code===100){
        alert(json.info);
        $('#content').load('./user-content.html');
        rows=null;
    }else{
        alert(json.info);
    }
}
function successInsertPermission(data) {
    var json=eval(data);
    if(json.code===100){
        alert(json.info);
        $('#content').load('./permission-content.html');
    }else{
        alert(json.info);
    }
}
function successUpdatePermission(data) {
    var json=eval(data);
    if(json.code===100){
        alert(json.info);
        $('#content').load('./permission-content.html');
        rows=null;
    }else{
        alert(json.info);
    }
}
function successDeletePermission(data) {
    var json=eval(data);
    if(json.code===100){
        alert(json.info);
        $('#content').load('./permission-content.html');
        rows=null;
    }else{
        alert(json.info);
    }
}
function successPermissionSelect(data) {
    var json=eval(data);
    $.each(json.rows,function (i,item) {
        var label=$('#permission_load');
        var content="<input type=checkbox name=permission_box value='"+item.permission_Id+"'>"+item.permission_info+"</input>&nbsp;&nbsp;";
        if(i%3===0){
            label.append("<br>");
        }
        label.append(content);
    })
}
function  successPermissionAllot(data) {
    var json=eval(data);
    if(json.code===100){
        alert(json.info);
    }else{
        alert(json.info);
    }
}