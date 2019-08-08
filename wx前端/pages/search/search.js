// pages/search/search.js

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
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      navH: app.globalData.navHeight * 2,
    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  backPage:function(){
    console.log(1);
  }

})