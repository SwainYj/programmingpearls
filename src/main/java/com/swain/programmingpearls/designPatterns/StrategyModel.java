package com.swain.programmingpearls.designPatterns;

/**
 * 定义TravelStrategy
 */
interface TravelStategy {
    void travelModel();
}
/**
 * 定义TravelStrategy的两种实现方式TravelByAirStrategy和TravelByCarStrategy
 */
class TravelByAir implements TravelStategy {
    @Override
    public void travelModel() {
        System.out.println("travel by air model");
    }
}
class TravelBycar implements TravelStategy {
    @Override
    public void travelModel() {
        System.out.println("travel by car model");
    }
}
/**
 * 定义策略模式实现的核心类Context，在该类中持有TravelStrategy实例并通过setTravelStrategy()实现了不同策略的切换。
 */
class TravelContext {
    private TravelStategy travelStategy;
    public TravelStategy getTravelStategy() {
        return this.travelStategy;
    }
    public void setTravelStategy(TravelStategy travelStategy) {
        this.travelStategy = travelStategy;
    }
    public void TravelModel() {
        this.travelStategy.travelModel();
    }

}

/**
 * 旅行策略
 */
public class StrategyModel {
    public static void main(String[] args) {
        TravelContext travelContext = new TravelContext();
        //开车策略
        TravelBycar travelBycar = new TravelBycar();
        travelContext.setTravelStategy(travelBycar);
        travelContext.TravelModel();
        //飞机策略
        TravelByAir travelByAir = new TravelByAir();
        travelContext.setTravelStategy(travelByAir);
        travelContext.TravelModel();
    }
}
