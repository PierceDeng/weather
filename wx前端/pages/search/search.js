// pages/search/search.js
var httpRequest = require('../../utils/httpRequest.js')

var token;
const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    left:"/img/icon/left.png",
    title:"切换城市",
    navH:0,
    hotCity: ['北京', '上海'
      , '深圳', '广州', '天津'
      , '成都', '杭州', '重庆'
      , '武汉', '南京', '郑州', '苏州',],
    historyCity:[],
    searchInfo:"",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      navH: app.globalData.navHeight * 2,
    });
    wx.getStorage({
      key: 'token',
      success: function(res) {
        token = res;
      },
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  backPage:function(){
    wx.navigateBack({
      delta:1
    });
  },
  clickBlackTag:function(){
    wx.showToast({
      title: '请先搜索哦!',
      icon:'none',
      duration:1500,
    });
  },
  clearHistory:function(){
    console.log(1);
  },
  clickSearch:function(){
    console.log(this.data.searchInfo);
  },
  updateSearchValue:function(e){
    this.setData({
      searchInfo: e.detail.value,
    })
  },
  clickTag:function(e){
    console.log(e.currentTarget.dataset.key);
  },
  requestWeather:function(name,type){
    var opts = {
      data:{
        name: name,
        type: type
      },
      method:'POST',
      success: this.wSuccess,
      header:{"token": token}
    }
    httpRequest.request('weather/authWeather',opts);
  },
  wSuccess:function(res){
    console.log(1);
  }
})