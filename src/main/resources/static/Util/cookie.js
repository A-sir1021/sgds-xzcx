/**
 *
 * @param name
 * @param value
 * @param time(s2,h3)
 */
function setCookie(name,value,time)
{
    var strsec = getsec(time);
    var exp = new Date();
    exp.setTime(exp.getTime() + strsec*1);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}

function getsec(str)
{
    console.warn("str>>",str);
    var str1=str.substring(1,str.length)*1;
    var str2=str.substring(0,1);
    if (str2=="s"){
        return str1*1000;
    }else if (str2=="h"){
        return str1*60*60*1000;
    }else if (str2=="d"){
        return str1*24*60*60*1000;
    }
}

var CookieUtil= {
    getValue :function (str) {
        var cookie = document.cookie;
        console.warn(cookie);
        var list = cookie.split(";");

        for (var string of list) {
            var key_value = string.split("=");
            var key = key_value[0].trim();
            var value = key_value[1].trim();

            if (key == str) {
                return value;
            }
        }
    },

    getValueJson : function (str){
        var cookie = document.cookie;
        var jsonValue = eval("(" + cookie + ")");
        return jsonValue;
    },

}
var SessionUtil = {
    getValue :function (str){
        var session = document.getSelection();
        console.log(session)
    }
}