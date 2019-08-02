//index.js
//获取应用实例
const app = getApp();

Page({
  data: {
    left:'/img/icon/user.png',
    bg: '/img/season/test.jpg',
    weatherIcon: '/img/weather/yun.png',
    localtion:'长沙市',
    todayTemMax: 37,
    todayTemMin: 25,
    todayTem: 30,
    todayWeather: '多云转雷阵雨',
    todaySkyNumber: '37',
    todaySky: '优',
    todayHumidity:"64",
    todayCloud: '东南风',
    todayCloudSpeed: '<3级',
    todayWeek: '星期五',
    weekDay:[
      {
        date:'2019-08-03',
        maxTem:'39',
        minTem:'20',
        tem:'32',
        weather:'晴',
        icon:'qing',
        cloud:'东风',
      },
      {
        date: '2019-08-03',
        maxTem: '39',
        minTem: '20',
        tem: '32',
        weather: '晴',
        icon: '/img/weather/qing.png',
        cloud: '东风',
      },
      {
        date: '2019-08-03',
        maxTem: '39',
        minTem: '20',
        tem: '32',
        weather: '晴',
        icon: '/img/weather/qing.png',
        cloud: '东风',   
      },
      {
        date: '2019-08-03',
        maxTem: '39',
        minTem: '20',
        tem: '32',
        weather: '晴',
        icon: '/img/weather/qing.png',
        cloud: '东风',    
      },
      {
        date: '2019-08-03',
        maxTem: '39',
        minTem: '20',
        tem: '32',
        weather: '晴',
        icon: '/img/weather/qing.png',
        cloud: '东风',   
      },
      {
        date: '2019-08-03',
        maxTem: '39',
        minTem: '20',
        tem: '32',
        weather: '晴',
        icon: '/img/weather/qing.png',
        cloud: '东风',    
      }
    ],
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
