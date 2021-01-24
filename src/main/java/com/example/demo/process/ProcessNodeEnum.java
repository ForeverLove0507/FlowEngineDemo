package com.example.demo.process;

public enum ProcessNodeEnum {
    NODE1("processNode1_1Impl", "流程节点1"),
    NODE2("processNode2Impl", "流程节点2"),
    NODE3("processNode3Impl", "流程节点3"),
    ;
    private final String name;
    private final String remark;

    ProcessNodeEnum(String name, String remark) {
        this.name = name;
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public String getRemark() {
        return remark;
    }
}
