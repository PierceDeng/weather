//app.js
var httpReuqest = require('/utils/httpRequest.js');
var bmap = require('/utils/map/bmap-wx.min.js');
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
        nav = res.statusBarHeight + 44;
        height = res.windowHeight;
        width = res.windowWidth;
      },
    });
    this.globalData.navHeight = nav;
    this.globalData.windowH = height;
    this.globalData.windowW = width;

    var map = new bmap.BMapWX({
      ak:"0OzKEwjC5V2xvrdNGwLyaHOlHofrUXV0"
    });

    map.weather({
      fail: res =>{
        console.log(res);
      },
      success: res =>{
        var city = res.currentWeather[0].currentCity;
        city = city.replace("市","");
        var opts = {
          data:{city: city},
          success:citySuccess,
          method:'GET'
        }
        httpReuqest.request("weather/getWeather",opts);
      }
    });

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


function citySuccess(res) {
  console.log(res);
}
