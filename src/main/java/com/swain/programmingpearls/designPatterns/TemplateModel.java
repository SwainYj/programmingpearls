package com.swain.programmingpearls.designPatterns;

/**
 * 定义AbstractTemplate模板类
 */
abstract class AbstractTemplate {
    public void templeMethod() { //模板方法用于核心流程 和 算法的定义
        checkNumber();
        queueUp();
        handleBusiness();
        serviceEvaluation();
    }
    public void checkNumber() {//取号
        System.out.println("checkNumber.....");
    }
    public void queueUp() {//排队
        System.out.println("queue up.....");
    }
    public abstract void handleBusiness();
    public void serviceEvaluation() {//评价
        System.out.println("business finished, pingjia.... ");
    }
}
/**
 * 定义SaveMoney的业务实现
 */
class SaveMoney extends AbstractTemplate {
    @Override
    public void handleBusiness() {
        System.out.println("save money...");
    }
}
/**
 * 定义TakeMoney的业务实现
 */
class TakeMoney extends AbstractTemplate {
    @Override
    public void handleBusiness() {
        System.out.println("take money...");
    }
}

/**
 * 模板方法模式
 */
public class TemplateModel {
    public static void main(String[] args) {
        //办理存取业务
        AbstractTemplate template1 = new SaveMoney();
        template1.templeMethod();
        //办理取钱业务
        AbstractTemplate template2 = new TakeMoney();
        template2.templeMethod();
    }
}
