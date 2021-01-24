package com.example.demo.process.Impl;


import com.example.demo.context.Context;
import com.example.demo.process.IProcessNode;
import com.example.demo.process.ProcessNodeLink;
import org.springframework.stereotype.Service;

@Service
public interface ProcessNode1Impl extends IProcessNode {

    @Override
    public int process(Context context, ProcessNodeLink processNodeLink);
}
