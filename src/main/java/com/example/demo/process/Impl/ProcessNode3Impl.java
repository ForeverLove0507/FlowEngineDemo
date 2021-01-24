package com.example.demo.process.Impl;


import com.example.demo.context.Context;
import com.example.demo.process.IProcessNode;
import com.example.demo.process.ProcessNodeLink;

public class ProcessNode3Impl implements IProcessNode {

    @Override
    public int process(Context context, ProcessNodeLink processNodeLink) {
        return SUCCESS;
    }
}
