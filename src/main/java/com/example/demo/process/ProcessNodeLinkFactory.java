package com.example.demo.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProcessNodeLinkFactory {
    @Autowired
    private Map<String, IProcessNode> processMap;

    public ProcessNodeLink createProcessLink(List<ProcessNodeEnum> processNodeEnums) {
        ProcessNodeLink processNodeLink = new ProcessNodeLink(processMap);
        if (processNodeEnums == null || processNodeEnums.isEmpty()) {
            return processNodeLink;
        }
        for (ProcessNodeEnum processNodeEnum : processNodeEnums) {
            processNodeLink.addProcessNode(processNodeEnum);
        }
        return processNodeLink;
    }
}
