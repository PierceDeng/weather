
const url = "http://127.0.0.1:8888/";
const method = "POST";
const responseType = "text";

function request(path,options){
  wx.request({
    url: url+path,
    data: options.data == null ? '' : options.data,
    method: options.method == null ? method : options.method,
    dataType: 'json',
    header: options.header == null ? {} : options.header,
    responseType: options.responseType == null ? responseType : options.responseType,
    success: res =>{
      if(res.statusCode === 200){
        return options.success(res.data);
      }else{
        return successCallBack;
      }
    },
    fail: res =>{
      if(options.fail == null)
        return failCallBack;
    },
    complete: res =>{
      if(options.complete == null)
        return completeCallBack;
    }
  });
}

function successCallBack(res){
  console.log(res);

}

function failCallBack(res){
  console.log(res);
}

function completeCallBack(res){
  
}

module.exports ={
  request: request
};
