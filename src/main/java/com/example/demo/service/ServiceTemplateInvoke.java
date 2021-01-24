package com.example.demo.service;


import com.example.demo.common.CommonResult;
import com.example.demo.context.*;
import com.example.demo.process.ProcessNodeEnum;
import com.example.demo.process.ProcessNodeLink;
import com.example.demo.process.ProcessNodeLinkFactory;
import com.example.demo.action.actionImpl.RefundByPriceAction;
import com.example.demo.action.actionImpl.RefundByQuantityAction;
import com.example.demo.action.actionImpl.ReturnCouponAction;
import com.example.demo.service.common.ServiceTemplate;
import com.example.demo.service.common.ServiceTemplateImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ServiceTemplateInvoke {
    @Autowired
    private ProcessNodeLinkFactory processNodeLinkFactory;
    
    public void delDispute() {
        //构造退券上下文，生成"根据金额退款"能力
        Context context1 = new Context();
        context1.put(new Object());
        RefundByPriceAction refundByPriceAction = genRefundByPriceAction();

        //构造退款上下文,生成"退券"能力
        Context context2 = new Context();
        context2.put(new Object());
        ReturnCouponAction returnCouponAction = genReturnCouponAction();

        //触发退券、退款流程
        ServiceTemplate serviceTemplate1 = new ServiceTemplateImpl();
        final CommonResult result1 = serviceTemplate1.invoke(context1, refundByPriceAction);
        final CommonResult result2 = serviceTemplate1.invoke(context1, returnCouponAction);
        System.out.println(result1.getData());
        System.out.println(result2.getData());
    }

    //生成"退券"能力
    public ReturnCouponAction genReturnCouponAction() {
        //构造退券能力需要的处理节点
        List<ProcessNodeEnum> processNodeEnums = new ArrayList<>();
        processNodeEnums.add(ProcessNodeEnum.NODE1);
        processNodeEnums.add(ProcessNodeEnum.NODE3);
        ProcessNodeLink processNodeLink1 = processNodeLinkFactory.createProcessLink(processNodeEnums);
        return new ReturnCouponAction(processNodeLink1);
    }

    //生成"根据金额退款"能力
    public RefundByPriceAction genRefundByPriceAction() {
        //构造能力需要的处理节点
        List<ProcessNodeEnum> processNodeEnums = new ArrayList<>();
        processNodeEnums.add(ProcessNodeEnum.NODE1);
        processNodeEnums.add(ProcessNodeEnum.NODE3);
        ProcessNodeLink processNodeLink2 = processNodeLinkFactory.createProcessLink(processNodeEnums);
        return new RefundByPriceAction(processNodeLink2);
    }

    //生成"根据数量退款"能力
    public RefundByQuantityAction genRefundByQuantityAction() {
        List<ProcessNodeEnum> processNodeEnums = new ArrayList<>();
        processNodeEnums.add(ProcessNodeEnum.NODE2);
        processNodeEnums.add(ProcessNodeEnum.NODE3);
        ProcessNodeLink processNodeLink2 = processNodeLinkFactory.createProcessLink(processNodeEnums);
        return new RefundByQuantityAction(processNodeLink2);
    }
}
