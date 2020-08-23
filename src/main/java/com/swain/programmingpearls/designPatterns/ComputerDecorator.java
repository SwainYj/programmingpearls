package com.swain.programmingpearls.designPatterns;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 定义Sourceable接口
 */
interface Sourceable2 {
    public void createComputer();
}

/**
 * 定义实现类Source
 */
class Source2 implements Sourceable2 {
    private final static Log logger = LogFactory.getLog(Source2.class);
    @Override
    public void createComputer() {
        logger.info("create computer by Source");
    }
}

/**
 * 定义装饰者类Decorator
 */
class Decorator implements Sourceable2 {
    private Sourceable2 sourceable2;
    private final static Log logger = LogFactory.getLog(Decorator.class);
    public Decorator(Sourceable2 sourceable2){
        super();
        this.sourceable2 = sourceable2;
    }
    @Override
    public void createComputer() {
        sourceable2.createComputer();
        logger.info("make sysytem");//在创建完电脑后给电脑装上系统
    }
}

public class ComputerDecorator {
    public static void main(String[] args) {
        Sourceable2 sourceable2 = new Source2();
        Sourceable2 obj = new Decorator(sourceable2);
        obj.createComputer();
    }
}
