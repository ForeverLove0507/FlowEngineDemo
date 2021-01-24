package com.example.demo.process;


import com.example.demo.context.Context;

public interface IProcessNode {
    int SUCCESS = 0;
    int BREAK = 1;
    int TRY_AGAIN = 2;

    int process(Context context, ProcessNodeLink processNodeLink);
}
