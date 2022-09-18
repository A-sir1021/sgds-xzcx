var CheckVail ={
    checkPhone : function (data_phone) {
        if (ValidataUtil.checkMobile(data_phone) == "ok"){
            return true;
        } else { return false}
    },

}