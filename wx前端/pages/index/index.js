//index.js
//获取应用实例
const app = getApp();

Page({
  data: {
    left:'/img/icon/user.png',
    bg: '/img/season/test.jpg',
    localtion:'长沙市',
    todayTem: 30,
  },
  onLoad:function(options){
    // this.setData({
    //   navH: app.globalData.navHeight
    // });
  },
  toMyPage:function(){
    console.log(2);
  }

  
})
