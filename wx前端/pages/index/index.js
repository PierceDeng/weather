//index.js
import uCharts from '../../utils/charts/u-charts.min.js';

const app = getApp();
var _self;
var chartsLine;

Page({
  data: {
    windowHeight:0,
    windowWidth:0,
    navH:0,
    left:'/img/icon/user.png',
    weatherIcon: '',
    localtion:'',
    todayTemMax: 0,
    todayTemMin: 0,
    todayTem: 0,
    todayWeather: '',
    todaySkyNumber: '',
    todaySky: '',
    todayHumidity:"",
    todayCloud: '',
    todayCloudSpeed: '',
    todayWeek: '',
    weekDay:[],
    chartData: {},
  },
  onLoad:function(options){
    this.setData({
      windowHeight: app.globalData.windowH * 2,
      windowWidth: app.globalData.windowW+15,
      navH:app.globalData.navHeight*2,
    });
    _self=this;
    wx.getStorage({
      key: 'weather',
      success: function (res) {
        _self.initData(res);
      },
    })
    
  },
  initData:function(res){
    console.log(res);
    this.setData({
      localtion: res.data.city+"市",
      todayTem: res.data.data[0].tem,
      todayWeather: res.data.data[0].wea,
      weatherIcon: "/img/weather/" + res.data.data[0].wea_img +".png",
      todaySkyNumber: res.data.data[0].air,
      todaySky: res.data.data[0].air_level,
      todayHumidity: res.data.data[0].humidity,
      todayCloud: res.data.data[0].win[0],
      todayCloudSpeed: res.data.data[0].win_speed,
      todayWeek: res.data.data[0].week,
      todayTemMax: res.data.data[0].tem1,
      todayTemMin: res.data.data[0].tem2,
      weekDay: res.data.data,
    })
    this.initCharts(res.data.chartData);
  },
  toMyPage:function(){
    console.log("暂未开放");
  },
  initCharts:function(res){
    chartsLine = new uCharts({
      $this: _self,
      canvasId: "canvasLine",
      type: 'line',
      fontSize: 12,
      categories: res.categories,
      series: res.modelSerie,
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
        splitNumber: 3,
        min: (this.data.todayTemMin - 1),
        max: (this.data.todayTemMax + 1),
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
        break;
      case '2':
        opts = {
          title: "提醒",
          content: '2222222',
          confirmColor: "#1296db",
          showCancel: false,
        }
        break;
      case '3':
        opts = {
          title: "提醒",
          content: '33333',
          confirmColor: "#d4237a",
          showCancel: false,
        }
        break;
      case '4':
        opts = {
          title: "提醒",
          content: '444444',
          confirmColor: "#d81e06",
          showCancel: false,
        }
        break;
      case '5':
        opts = {
          title: "提醒",
          content: '555555',
          confirmColor: "#c99c2d",
          showCancel: false,
        }
        break;
      case '6':
        opts = {
          title: "提醒",
          content: '6',
          confirmColor: "#1afa29",
          showCancel: false,
        }
        break;
    }
    wx.showModal(opts);
  },

})
