//app.js
var httpReuqest = require('/utils/httpRequest.js');
var nav;
var height;
var width;

App({
  globalData: {
    userInfo: null,
    navHeight: 0,
    windowH: 0,
    windowW: 0,
  },
  onLaunch: function () {
    wx.getSystemInfo({
      success: function(res) {
        console.log(res);
        nav = res.statusBarHeight + 46;
        height = res.windowHeight;
        width = res.windowWidth;
      },
    });
    this.globalData.navHeight = nav;
    this.globalData.windowH = height;
    this.globalData.windowW = width;
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