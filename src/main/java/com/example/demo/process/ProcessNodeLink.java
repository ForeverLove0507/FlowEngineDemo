package com.example.demo.process;


import com.example.demo.context.Context;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ProcessNodeLink {
    private Map<String, IProcessNode> processMap;
    private List<ProcessNodeEnum> processNodeEnums;
    private int index;
    private Map<Object, Object> data;

    private ProcessNodeLink() {
    }

    public ProcessNodeLink(Map<String, IProcessNode> processMap) {
        this.processNodeEnums = new ArrayList<>();
        this.data = new HashMap<>();
        this.index = 0;
        this.processMap = processMap;
    }

    public synchronized void startProcess(Context context) {
        runNext(context);
    }

    private synchronized void runNext(Context context) {
        if (index == processNodeEnums.size()) {
            return;
        }
        ProcessNodeEnum processNodeEnum = processNodeEnums.get(index);
        int processResult = processMap.get(processNodeEnum.getName()).process(context, this);
        switch (processResult) {
            case IProcessNode.SUCCESS:
                index++;
                runNext(context);
                break;
            case IProcessNode.BREAK:
                return;
            case IProcessNode.TRY_AGAIN:
                runNext(context);
                break;
            default:
                break;
        }
    }

    public synchronized boolean hasNext() {
        return index < processNodeEnums.size() - 1;
    }

    public void addProcessNode(ProcessNodeEnum processNodeEnum) {
        if (processMap.containsKey(processNodeEnum.getName())) {
            processNodeEnums.add(processNodeEnum);
        } else {

        }
    }

    public void putData(Object key, Object value) {
        data.put(key, value);
    }

    public <V> V getData(Object key, Class<V> c) {
        return (V) data.get(key);
    }

    public <V> V getData(Object key, V defaultValue) {
        return (V) data.getOrDefault(key, defaultValue);
    }

    public Object getOrDefault(Object key, Object defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }

    public Object getData(Object key) {
        return data.get(key);
    }
}
