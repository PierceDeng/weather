//index.js
//获取应用实例
const app = getApp();

Page({
  data: {
    navH: null
  },
  onLoad:function(options){
    this.setData({
      navH: app.globalData.navHeight
    });
  }
  
})
