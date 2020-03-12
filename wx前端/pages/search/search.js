// pages/search/search.js
var httpRequest = require('../../utils/httpRequest.js')

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
    token:"",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  
  onLoad: function (options) {
    this.setData({
      navH: app.globalData.navHeight * 2,
    });
    var token = wx.getStorageSync("token");
    this.requestHistory(token);
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  backPage:function(){
    wx.switchTab({
      url: '/pages/index/index',
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
    var opts = {
      method: 'POST',
      success: this.cSuccess,
      header: { "token": wx.getStorageSync("token") }
    }
    httpRequest.request('search/clear', opts);
  },
  cSuccess:function(res){
    if(res.code == 0){
      this.setData({
        historyCity : [],
      });
      wx.showToast({
        title: res.data,
        icon:"none",
        duration:1500,
      });
    }
  },
  clickSearch:function(){
    var text = this.data.searchInfo;
    if(text.trim().length == 0){
      wx.showToast({
        title: '请先填写城市名称',
        icon:'none',
        duration:1500
      });
      return ;
    }
    this.requestWeather(text,1);
  },
  updateSearchValue:function(e){
    this.setData({
      searchInfo: e.detail.value,
    })
  },
  clickTag:function(e){
    this.requestWeather(e.currentTarget.dataset.key, 2);
  },
  requestHistory:function(token){
    var opts = {
      method: 'GET',
      success: this.hSuccess,
      header: { "token": token }
    }
    httpRequest.request('search/history', opts);
  },
  hSuccess:function(res){
    this.setData({
      historyCity: res.data,
    });
  },
  requestWeather:function(name,type){
    var opts = {
      data:{
        city: name,
        type: type
      },
      method:'POST',
      success: this.wSuccess,
      header:{"token": wx.getStorageSync("token")}
    }
    httpRequest.request('weather/authWeather',opts);
  },
  wSuccess:function(res){
    if(res.code == 0){
      wx.setStorageSync('weather', res.data);
      wx.switchTab({
        url: '/pages/index/index',
      });
    }
  }
})