window.onload = function () {
    if (window.top !== window.self) {
        window.top.location = window.location
    }
    aja1();
    delStoring();
    v_id = 'undefined';
    CookieUtil.setStoring();
}

var v_id = 'undefined';
var storage = window.localStorage
var cookie = document.cookie;
var first = 0;


function delStoring (){
    storage.clear();
}


$(document).ready(function () {
    console.log(v_id)
    $("#from_resend").click(function (e) {
        v_id = e.target.id;
        console.log(v_id)
        if(cookie ==''){
            window.referURL('/role/login/')
        }

        aja();

    })
})

function resend(e) {
    $('#mess_Fail').remove();
    if (v_id == 'undefined') {
        return
    }
}


function resend_ajax(v_id) {
    $.ajax({
        url: "/main/" + v_id,
        success: function (data) {
            v_id = 'undefined';
            $('#salarly_refresh').html(data)
        },
        error: function (date) {
            console.log(date)
        }
    })
}


function querySalaAjav(v_sala) {
    var phone = CookieUtil.getValue('phone');
    var phone1 = storage.getItem('phone');
    if(phone != phone1){
        return ;
    }
    var date_query = {
        "salary": phone
    }
    console.log(v_sala)
    $.ajax({
        data: date_query,
        type: "POST",
        //没什么鸟用
        async: true,
        url: "/main/queryPerson",
        timeout: 3000,
        success: function (data) {
            v_id = 'undefined';
            if (data == '500211') {
                $('#massage').after('<blockquote style="color: #A60000" class="mess_Fail">用户验证不正确，查询失败</blockquote>')
                return;
            }
            $('#salarly_refresh').html(data)
        },
        error: function (e) {
            console.log(e)
        }
    })
}

function aja() {

    sleep_view()
    console.log(v_id)
    //点击后，置灰不可点，完成后恢复
    $("#wait").css("display", "block");
    butt(v_id, 'gray');
    $("#" + v_id).attr("disabled", true);

    //请求完城后，视觉效果
    $(document).ajaxComplete(function () {
        setTimeout(function () {
            butt(v_id, 'white')
            $("#" + v_id).removeAttr("disabled")
        }, 15000)

        //视觉效果
        setTimeout(function () {
            $("#wait").css("display", "none");
        }, 500)

    })
}

//为了效果掩饰，程序睡眠
const sleep_view = async () => {
    console.log(new Date().getTime()+" "+v_id)
    await sleep(1000)

    //等待加载完dom后，触发提交
    if (v_id == 'sendEmail') {
        resend_ajax(v_id)
    } else if (v_id = 'queryPerson') {
        querySalaAjav(v_id)
    }
}
const sleep = (delay) => new Promise((resolve) => setTimeout(resolve, delay)).then(console.log(v_id))

//按钮置灰
function butt(v_id, color) {
    $("#" + v_id).css("color", color)
}


//视觉效果，刚加载时触发
function aja1() {
    $(function () {
        $("#wait").css("display", "block");
        setTimeout(function () {
            $("#wait").css("display", "none");
        }, 200)
    })
}

$(function () {
    /*  $(document).ready(function(){
      //��ť����ʱִ��
          return ;
          $("#form_resend").click(function(e){
              e.preventDefault()
              var v_id = e.target.id;
              console.log(v_id+">>v_id");
              //e.preventDefault(true);
              window.document.action="/main/"+v_id;
          });
     });*/
    $(document).ready(function () {
        $("#sendEmail").click(function () {
            //  window.document.f.action="/main/sendEmail";
        });
    });
    $(document).ready(function () {
        $("#upload").click(function () {
            //  window.document.f.action="/main/upload";
        });

    });
    $(document).ready(function () {
        //��ť����ʱִ��
        $("#update").click(function () {
            alert("���4");
            window.document.f.action = "/auth/updatemiddle";
        });

    });
    $(document).ready(function () {
        //��ť����ʱִ��
        $("#art").click(function () {
            alert("���5");
            window.document.f.action = "/auth/Article";
        });

    });
    $(document).ready(function () {
        //��ť����ʱִ��
        $("#per").click(function () {
            alert("���6");
            window.document.f.action = "/auth/Permission";
        });

    });
})


