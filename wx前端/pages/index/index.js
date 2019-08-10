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
  },
  onLoad:function(options){
    this.setData({
      windowHeight: app.globalData.windowH * 2,
      windowWidth: app.globalData.windowW+15,
      navH:app.globalData.navHeight*2,
    });
  },
  onShow:function(){
    _self = this;
    wx.getStorage({
      key: 'weather',
      success: function (res) {
        _self.initData(res);
      },
      fail: function () {
        wx.reLaunch({
          url: '/pages/auth/location/location',
        })
      }
    });
  },
  initData:function(res){
    this.setData({
      localtion: res.data.city+"市",
      todayTem: res.data.data[0].tem,
      todayWeather: res.data.data[0].wea,
      weatherIcon: res.data.data[0].wea_img,
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
    var modelSerie = res.modelSerie;
    modelSerie[0].format = (res) =>{return res+"°"};
    var max = parseInt(this.data.todayTemMax) + 1;
    var min = this.data.todayTemMin - 1;
    chartsLine = new uCharts({
      $this: _self,
      canvasId: "canvasLine",
      type: 'line',
      fontSize: 12,
      categories: res.categories,
      series: modelSerie,
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
        min: min,
        max: max,
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
          content: this.data.weekDay[0].index[0].desc,
          confirmColor:"#41078a",
          showCancel:false,
        };
        break;
      case '2':
        opts = {
          title: "提醒",
          content: this.data.weekDay[0].index[1].desc,
          confirmColor: "#1296db",
          showCancel: false,
        }
        break;
      case '3':
        opts = {
          title: "提醒",
          content: this.data.weekDay[0].index[2].desc,
          confirmColor: "#d4237a",
          showCancel: false,
        }
        break;
      case '4':
        opts = {
          title: "提醒",
          content: this.data.weekDay[0].index[3].desc,
          confirmColor: "#d81e06",
          showCancel: false,
        }
        break;
      case '5':
        opts = {
          title: "提醒",
          content: this.data.weekDay[0].index[4].desc,
          confirmColor: "#c99c2d",
          showCancel: false,
        }
        break;
      case '6':
        opts = {
          title: "提醒",
          content: this.data.weekDay[0].index[5].desc,
          confirmColor: "#1afa29",
          showCancel: false,
        }
        break;
    }
    wx.showModal(opts);
  },
  changeCity:function(){
    wx.navigateTo({
      url: '/pages/search/search',
    })
  }

})
