
const url = "http://127.0.0.1:8888/";
const method = "POST";
const responseType = "text";
const header = {
  "content-type":'application/json; charset=utf-8'
}

function request(path,options){
  wx.request({
    url: url+path,
    data: options.data == null ? '' : options.data,
    method: options.method == null ? method : options.method,
    dataType: 'json',
    header: options.header == null ? header : options.header,
    responseType: options.responseType == null ? responseType : options.responseType,
    success: res =>{
      if (res.statusCode === 200 && options.success){
        return options.success(res.data);
      }else{
        return successCallBack(res);
      }
    },
    fail: res =>{
      if(options.fail == null)
        return failCallBack(res);
      else
        return options.fail;
    },
    complete: res =>{
      if(options.complete == null)
        return completeCallBack(res);
      else
        return options.complete;
    }
  });
}

function successCallBack(res){
  console.log(res);
}

function failCallBack(res){
  wx.showToast({
    title: '请检查网络设置',
    icon: 'loading',
    duration: 2000
  });
}

function completeCallBack(res){

}

module.exports ={
  request: request
};
