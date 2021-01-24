package com.example.demo.action;

import com.example.demo.common.CommonResult;
import com.example.demo.context.Context;

public interface ActionCallBack<T extends CommonResult, C extends Context> {
    void paramValidate(C context);

    void bizValidate(C context);

    default void beforeProcess(C context) {
    }

    void process(C context);

    default void afterProcess(C context) {
    }

    T assemble(C context);
}
