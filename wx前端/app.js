//app.js
var httpReuqest = require('/utils/httpRequest.js');

App({
  onLaunch: function () {
    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        if(res.code){
          var options = {
            data:{
              "code":res.code
            },
            success: success
          }
          httpReuqest.request("auth", options);
        }
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {

      }
    })
  },
  globalData: {}

})

function success(data){
  console.log(data);
}