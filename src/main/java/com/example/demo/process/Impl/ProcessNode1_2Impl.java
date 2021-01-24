package com.example.demo.process.Impl;

import com.example.demo.context.Context;
import com.example.demo.process.ProcessNodeLink;

public class ProcessNode1_2Impl implements ProcessNode1Impl {
    @Override
    public int process(Context context, ProcessNodeLink processNodeLink) {
        System.out.println("ProcessNode1-2 processing");
        return SUCCESS;
    }
}
