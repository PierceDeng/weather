// pages/auth/location/location.js
var httpReuqest = require('../../../utils/httpRequest.js');
var bmap = require('../../../utils/map/bmap-wx.min.js');
var dateUtil = require("../../../utils/dateUtil.js");

Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  
  onPullDownRefresh:function(){
    console.log("下拉");
  },  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.showLoading({
      title: '加载中',
    });
    wx.getStorage({
      key: 'weather',
      success: function (res) {
        var hours = dateUtil.dateHours(res.data.update_time);
        if(hours >= 8){
          that.getWeather(that);
          return ;
        }
        wx.reLaunch({
          url: '/pages/index/index',
        });
      },
      fail: function (res) {
        console.log(res);
        that.getWeather(that);
      }
    });
  },  

  citySuccess:function(res){
    wx.setStorage({
      key: 'weather',
      data: res.data,
    });
    wx.reLaunch({
      url: '/pages/index/index',
    })
  },
  cityFail:function(){
    wx.reLaunch({
      url: '/pages/index/index',
    })
  },

  getWeather: function (that){
    var map = new bmap.BMapWX({
      ak: "0OzKEwjC5V2xvrdNGwLyaHOlHofrUXV0"
    });
    map.weather({
      fail: res => {
        console.log('fail auth location!');
        var opts = {
          data: { city: '北京' },
          success: that.citySuccess,
          fail: that.cityFail,
          method: 'GET'
        }
        httpReuqest.request("weather/getWeather", opts);
      },
      success: res => {
        var city = res.currentWeather[0].currentCity;
        city = city.replace("市", "");
        var opts = {
          data: { city: city },
          success: that.citySuccess,
          fail: that.cityFail,
          method: 'GET'
        }
        httpReuqest.request("weather/getWeather", opts);
      }
    });
  },
})