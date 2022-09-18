
function AccExit(){
    var date_aj = {
        "acc" : $("#acc").val()
    };
    $(".alert").remove();
    $(".lab-fail").remove();
    if (date_aj["acc"].length<=6){
        return ;
    }
    var flag=  CheckVail.checkPhone(date_aj["acc"]);
    if(!flag){
       // return ;
    } else {
        //TODO
        submit()
    }

}

function submit (){
    var date_aj = {
        "acc" : $("#acc").val()
    };
    $("#submi").prop("disabled",true)
    $.ajax({
        type:"POST",
        data:date_aj,
        contentType: 'application/json',
        url: "/role/acc",
        timeout:3000,
        success:function (date) {
            $("#submi").prop("disabled",false)
            if(date == "succ"){
            } else if (date == "500211"){
                $(".Msg").after(
                    '<p class="alert">账号未查询到有效员工！</p>'
                )
            } else {
            }
        },
        error:function (e){
            console.warn("ERROE",e);
            $("#submi").prop("disabled",false)
        },
    })
}