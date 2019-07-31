//app.js
var httpReuqest = require('/utils/httpRequest.js');
var nav;

App({
  globalData: {
    userInfo: null,
    navHeight: 0
  },
  onLaunch: function () {
    wx.getSystemInfo({
      success: function(res) {
        nav = res.statusBarHeight + 46;
      },
    });
    this.globalData.navHeight = nav;
    // 登录
    // wx.login({
    //   success: res => {
    //     // 发送 res.code 到后台换取 openId, sessionKey, unionId
    //     if(res.code){
    //       var options = {
    //         data:{"code":res.code},
    //         success: success,
    //         method: "GET"
    //       }
    //       httpReuqest.request("auth", options);
    //     }
    //   }
    // })

    // 获取用户信息
    // wx.getSetting({
    //   success: res => {
    //     if (!res.authSetting["scope.userInfo"]){
          
    //     }
    //   }
    // })
  },


})

function success(res){
  if (res.code === 0){
    wx.setStorage({
      key: 'token',
      data: res.data,
    });
  }else{
    wx.showToast({
      title: res.message,
      icon:'none',
      duration: 2000
    });
  }
}