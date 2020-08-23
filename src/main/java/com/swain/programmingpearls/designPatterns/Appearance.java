package com.swain.programmingpearls.designPatterns;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Dashboard类来代表仪表盘，并定义了startup()和shutdown()来控制仪表盘的启动和关闭。
 */
class Dashboard {
    private final static Log logger = LogFactory.getLog(Dashboard.class);
    public void start() {
        logger.info("dashboard statr..");
    }
    public void shutdown() {
        logger.info("dashboard shutdown..");
    }
}
/**
 * Engine类来代表发动机
 */
class Engine {
    private final static Log logger = LogFactory.getLog(Engine.class);
    public void start() {
        logger.info("engine statr..");
    }
    public void shutdown() {
        logger.info("engine shutdown..");
    }
}

/**
 * 门面类Starter，在Starter中定义了startup方法，该方法先调用engine的启动方法启动引擎，再调用dashboard的启动方法启动仪表盘
 */
class Starter {
    private final static Log logger = LogFactory.getLog(Starter.class);
    private Dashboard dashboard;
    private Engine engine;
    public Starter() {
        this.dashboard = new Dashboard();
        this.engine = new Engine();
    }
    public void start() {
        engine.start();
        dashboard.start();
    }
    public void shutdown() {
        dashboard.shutdown();
        engine.shutdown();
    }
}

/**
 * 外观模式
 */
public class Appearance {
    public static void main(String[] args) {
        Starter starter = new Starter();
        starter.start();
        System.out.println("zou la ");
        starter.shutdown();
    }
}
