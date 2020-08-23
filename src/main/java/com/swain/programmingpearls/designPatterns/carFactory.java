package com.swain.programmingpearls.designPatterns;

public class carFactory {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Car jeep = factory.createCar("jeep");
        Car ferraris = factory.createCar("ferraris");
        System.out.println(jeep.brand());
        System.out.println(ferraris.brand());
    }
}

/**
 * 定义接口
 */
interface Car {
    String brand();
}

/**
 *定义实现类
 */
class jeep implements Car {
    @Override
    public String brand() {
        return "this is jeep car";
    }
}

class ferraris implements Car {
    @Override
    public String brand() {
        return "this is ferraris car";
    }
}

/**
 * 定义工厂类
 */
class Factory {
    public Car createCar (String carName) {
        if ("jeep".equals(carName)) {
            return new jeep();
        }
        if ("ferraris".equals(carName)) {
            return new ferraris();
        }
        return null;
    }
}