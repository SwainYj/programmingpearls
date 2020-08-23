package com.swain.programmingpearls.designPatterns;

import org.apache.kafka.common.protocol.types.Field;

/**
 * 定义需要生产的产品Computer
 */
class Computer {
    private String cpu;
    private String memory;
    private String disk;
    public void setCpu(String cpu) {this.cpu = cpu;}
    public void setMemory(String memory) {this.memory = memory;}
    public void setDisk(String disk) {this.disk = disk;}
    public String getCpu() {return this.cpu;}
    public String getMemory() {return this.memory;}
    public String getDisk() {return this.disk;}
}
/**
 *定义抽象接口ComputerBuilder来描述产品构造和装配的过程
 */
interface ComputerBuilder {
    void buildCpu();
    void buildMemory();
    void buildDisk();
    Computer buildComputer();
}
/**
 *定义ComputerBuilder接口实现类ComputerConcreteBuilder以实现构造和装配该产品的各个组件
 */
class ComputerConcreteBuilder implements ComputerBuilder{
    Computer computer;
    public ComputerConcreteBuilder() {
        computer = new Computer();
    }
    @Override
    public void buildCpu() {
        computer.setCpu("8Core");
    }
    @Override
    public void buildMemory() {
        computer.setMemory("16G");
    }
    @Override
    public void buildDisk() {
        computer.setDisk("1TG");
    }
    @Override
    public Computer buildComputer() {
        return computer;
    }
}
/**
 *定义ComputerDirector使用Builder接口实现产品的装配
 */
class ComputerDirector {
    public Computer constructComputer(ComputerBuilder computerBuilder) {
        computerBuilder.buildMemory();
        computerBuilder.buildCpu();
        computerBuilder.buildDisk();
        return computerBuilder.buildComputer();
    }
}
/**
 * 构建computer
 */
public class BuildComputer {
    public static void main(String[] args) {
        ComputerDirector computerDirector = new ComputerDirector();
        ComputerBuilder computerConcreteBuilder = new ComputerConcreteBuilder();
        Computer computer = computerDirector.constructComputer(computerConcreteBuilder);
    }
}