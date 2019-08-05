//index.js
import uCharts from '../../utils/charts/u-charts.min.js';

const app = getApp();
var _self;
var chartsLine;

Page({
  data: {
    windowHeight:0,
    windowWidth:0,
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
    chartData: {
      categories: ['8:00', '11:00', '14:00', '17:00', '20:00', '23:00'],
      series: [{
        name: '时间温度',
        data: [35, 20, 25, 37, 4, 20],
        color: '#48D1CC',
        textColor: '#000000', 
        textSize: 10,
        format:(val) =>{return val+"°"}
      }]
    },
  },
  onLoad:function(options){
    this.setData({
      windowHeight: app.globalData.windowH * 2,
      windowWidth: app.globalData.windowW+15,
    });
    _self=this;
    this.initCharts();
    console.log(this.data.windowHeight);
  },
  toMyPage:function(){
    console.log(2);
  },
  initCharts:function(){
    chartsLine = new uCharts({
      $this: _self,
      canvasId: "canvasLine",
      type: 'line',
      fontSize: 12,
      categories: this.data.chartData.categories,
      series: this.data.chartData.series,
      enableScroll: true,
      animation: true,
      legend: true,
      dataLabel: true,
      dataPointShape: true,
      padding:[25,25,5,0],
      xAxis: {
        disableGrid: true,
        itemCount: 6,
        scrollShow: false,
        scrollAlign: 'left',
      },
      yAxis: {
        //disabled:true
        gridColor:"#778899",
        gridType: 'dash',
        splitNumber: 4,
        min: this.data.todayTemMin,
        max: this.data.todayTemMax,
        format: (val) => { return val.toFixed(0) + '°' }
      },
      extra: {
        line: {
          type: 'straight'
        }
      },
      width: this.data.windowWidth,
      height: 200,
    });
  },
  showModel:function(event){
    var type = event.currentTarget.dataset.type;
    if (!type) return ;
    var opts;
    switch (type){
      case '1': 
        opts= {
          title:"提醒",
          content:'111111',
          confirmColor:"#41078a",
          showCancel:false,
        };
        wx.showModal(opts);
        break;
      case '2':
        opts = {
          title: "提醒",
          content: '2222222',
          confirmColor: "#1296db",
          showCancel: false,
        }
        wx.showModal(opts);
        break;
      case '3':
        opts = {
          title: "提醒",
          content: '33333',
          confirmColor: "#d4237a",
          showCancel: false,
        }
        wx.showModal(opts);
        break;
      case '4':
        opts = {
          title: "提醒",
          content: '444444',
          confirmColor: "#d81e06",
          showCancel: false,
        }
        wx.showModal(opts);
        break;
      case '5':
        opts = {
          title: "提醒",
          content: '555555',
          confirmColor: "#c99c2d",
          showCancel: false,
        }
        wx.showModal(opts);
        break;
      case '6':
        opts = {
          title: "提醒",
          content: '6',
          confirmColor: "#1afa29",
          showCancel: false,
        }
        wx.showModal(opts);
        break;
    }
  },
  openModel:function(opts){
    wx.showModal(opts);
  },

})
