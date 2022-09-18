window.onload=function (){
    if(window.top!==window.self){
        window.top.location=window.location
    };
    aja1();
}
function resend(e){
    $('#mess_Fail').remove();
    aja();

    $("#from_resend").click(function (e) {
        var v_id = e.target.id;
        //window.location.href="/main/"+v_id;

        $.ajax({
            url:"/main/"+v_id,
            async:true,
            success:function (data) {
                $('#salarly_refresh').html(data)
            },
            error:function (date) {
              console.log(date)
            }
        })

    })
}

function querySarly(e){
    $('.mess_Fail').remove();
    console.log(2)

    aja();

    $("#from_resend").click(function (e) {
        var phone = CookieUtil.getValue('phone');
        var date_query = {
            "salary": phone
        }

        $.ajax({
            data: date_query,
            type: "POST",
            async:true,
            url: "/main/queryPerson",
            timeout: 3000,
            success: function (data) {
                if (data == '500211') {
                    $('#massage').after('<blockquote style="color: #A60000" class="mess_Fail">用户验证不正确，查询失败</blockquote>')
                    return;
                }
                // console.log(data)
                $('#salarly_refresh').html(data)
            },
            error: function (e) {
                console.log(e)
            }
        })
    })
}

function aja(){
    console.log(1)
    $("#from_resend").click(function (e) {
        var v_id = e.target.id;
        ss()
        $(document).ajaxSend(function() {
            $("#wait").css("display", "block");
            $("#" + v_id).prop("disabled", true)
            butt(e);
            // $("#" + v_id).attr()
            //$("#" + v_id).attr("disabled", true);
            // $("#" + v_id).removeAttr("disabled")
        })
        $(document).ajaxComplete(function(){
            $("#wait").css("display","none");
            $("#"+v_id).prop("disabled",true)

        })
    })
}
const ss = async () =>{await sleep(100000)}

const sleep = (delay) => new Promise((resolve) => setTimeout(resolve, delay))

function aja1(){
        // ss()
    $(function (){
        $("#wait").css("display", "block");
        ss()
        $("#wait").css("display","none");

    })
}

function butt(v_id){
    $("#upload").css("color","gray")
}

$(function (){
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
        $(document).ready(function(){
            $("#sendEmail").click(function(){
              //  window.document.f.action="/main/sendEmail";
            });
        });
        $(document).ready(function(){
            $("#upload").click(function(){
              //  window.document.f.action="/main/upload";
            });

         });
        $(document).ready(function(){
        //��ť����ʱִ��
        $("#update").click(function(){
            alert("���4");
            window.document.f.action="/auth/updatemiddle";
        });

    });
        $(document).ready(function(){
        //��ť����ʱִ��
        $("#art").click(function(){
            alert("���5");
            window.document.f.action="/auth/Article";
        });

    });
        $(document).ready(function(){
        //��ť����ʱִ��
        $("#per").click(function(){
            alert("���6");
            window.document.f.action="/auth/Permission";
        });

    });
})


