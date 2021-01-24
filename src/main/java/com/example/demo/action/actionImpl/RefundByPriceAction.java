package com.example.demo.action.actionImpl;

import com.example.demo.common.CommonResult;
import com.example.demo.action.ActionCallBack;
import com.example.demo.context.Context;
import com.example.demo.process.ProcessNodeLink;


public class RefundByPriceAction implements ActionCallBack {
    private ProcessNodeLink processNodeLink;

    public RefundByPriceAction(ProcessNodeLink processNodeLink) {
        this.processNodeLink = processNodeLink;
    }


    @Override
    public void paramValidate(Context context) {
        System.out.println("paramValidate");
    }

    @Override
    public void bizValidate(Context context) {
        System.out.println("bizValidate");
    }


    @Override
    public void process(Context context) {
        processNodeLink.startProcess(context);
    }


    @Override
    public CommonResult assemble(Context context) {
        return null;
    }
}
