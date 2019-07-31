package com.zzzfyrw.common.util.okHttp.callback;

import okhttp3.Call;
import okhttp3.Response;

public abstract class BaseCallBack {

    public abstract String onFailure(Call call);

    public abstract String onSuccess(Response response);

}
