

function dateHours(dateStr) {
  var date1 = new Date(dateStr);
  var date2 = new Date();
  var date3 = date2.getTime() - new Date(date1).getTime();
  var leave1 = date3 % (24 * 3600 * 1000)    //计算天数后剩余的毫秒数
  var hours = Math.floor(leave1 / (3600 * 1000));
  return hours;
}


module.exports = {
  dateHours: dateHours
};
