package com.example.demo.service.common;


import com.example.demo.action.ActionCallBack;
import com.example.demo.common.CommonResult;
import com.example.demo.context.Context;

public class ServiceTemplateImpl implements ServiceTemplate {
    @Override
    public CommonResult invoke(Context context, ActionCallBack action) {
        //参数校验
        paramValidate(context, action);
        //业务校验
        bizValidate(context, action);
        //事务执行前置扩展点
        beforeProcessCallBack(context, action);
        //事务执行
        processCallBack(context, action);
        //事务执行后置扩展点
        afterProcessCallBack(context, action);
        //数据装配
        return assemble(context, action);
    }

    private CommonResult assemble(Context context, ActionCallBack action) {
        System.out.println("assemble");
        return action.assemble(context);
    }

    private void afterProcessCallBack(Context context, ActionCallBack action) {
        System.out.println("afterProcessCallBack");
        action.afterProcess(context);
    }

    private void processCallBack(Context context, ActionCallBack action) {
        System.out.println("processCallBack");
        action.process(context);
    }

    private void beforeProcessCallBack(Context context, ActionCallBack action) {
        System.out.println("beforeProcessCallBack");
        action.beforeProcess(context);
    }

    private void bizValidate(Context context, ActionCallBack action) {
        System.out.println("bizValidate");
        action.bizValidate(context);
    }

    private void paramValidate(Context context, ActionCallBack action) {
        System.out.println("paramValidate");
        action.paramValidate(context);
    }
}
