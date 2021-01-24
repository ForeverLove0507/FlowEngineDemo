package com.example.demo.service.common;

import com.example.demo.action.ActionCallBack;
import com.example.demo.common.CommonResult;
import com.example.demo.context.Context;

public interface ServiceTemplate<T extends CommonResult, C extends Context> {

    /**
     * @param context
     * @param action
     * @return
     */
    T invoke(C context, ActionCallBack<T, C> action);
}
