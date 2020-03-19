

var summer = "https://zzzfyrw-test.oss-cn-hangzhou.aliyuncs.com/weather/summer.jpg"
var spring = "https://zzzfyrw-test.oss-cn-hangzhou.aliyuncs.com/weather/spring.jpg"
var autumn = "https://zzzfyrw-test.oss-cn-hangzhou.aliyuncs.com/weather/autumn.jpg"
var winter = "https://zzzfyrw-test.oss-cn-hangzhou.aliyuncs.com/weather/winter.jpg"


function getSeason(){
  let bg = spring;
  let date = new Date();
  let month = date.getMonth() + 1;
  switch(month){
    case 3:
    case 4:
    case 5:
      bg = spring;
      break;
    case 6:
    case 7:
    case 8:
      bg = summer;
      break;
    case 9:
    case 10:
    case 11:
      bg = autumn;
      break;
    case 12:
    case 1:
    case 2:
      bg = winter;
      break;
  }
  return bg;
}


module.exports = {
  getSeason: getSeason
};