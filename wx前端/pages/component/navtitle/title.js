// pages/component/navtitle/title.js
const app = getApp();
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    title:{
      type: String,
      value: '看看天气'
    },
    left:{
      type: String,
      value: '/img/icon/user.png'
    },
  },
  /**
   * 组件的初始数据
   */
  data: {
    navH: 0,
  },

  /**
   * 组件的方法列表
   */
  methods: {
    clickImg:function(){
      this.triggerEvent("go");
    }
  },

  lifetimes: {
    attached: function () {
      this.setData({
        navH:app.globalData.navHeight
      })
    },
    detached: function () {

    },
  },
})
