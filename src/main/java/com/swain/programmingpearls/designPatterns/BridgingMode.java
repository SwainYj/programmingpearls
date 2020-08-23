package com.swain.programmingpearls.designPatterns;

/**
 * 定义Driver接口
 */
interface Driver {
    void executeSQL();
}
/**
 * 定义MySQL实现类
 */
class mysqlDriver implements Driver {
    @Override
    public void executeSQL() {
        System.out.println("execute sql by mysql driver");
    }
}
/**
 * 定义oracle实现类
 */
class oracleDriver implements Driver {
    @Override
    public void executeSQL() {
        System.out.println("execute sql by oracle driver");
    }
}
/**
 * 定义DriverManagerBridge
 */
abstract class DriverManagerBridge {
    private Driver driver;
    public void executeSQL() {
        this.driver.executeSQL();
    }
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
/**
 * MyDriver用于实现用户自定义的功能，也可以直接使用DriverManagerBridge提供的功能
 */
class MyDriver extends DriverManagerBridge {
    public void execute(){
        getDriver().executeSQL();
    }
}

/**
 * 桥接模式
 */
public class BridgingMode {
    public static void main(String[] arg){
        MyDriver myDriver=new MyDriver();
        myDriver.setDriver(new mysqlDriver());
        myDriver.execute();

        myDriver.setDriver(new oracleDriver());
        myDriver.execute();
    }
}
