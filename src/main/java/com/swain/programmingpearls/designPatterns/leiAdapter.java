package com.swain.programmingpearls.designPatterns;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

/**
 * 定义Source类
 */
class Source {
    private final static Log logger = LogFactory.getLog(Source.class);
    public void editTextFile() { //text文本编辑
        logger.info("a text file editing");
    }
}
/**
 * 定义Targetable接口
 */
interface Targetable {
    void editTextFile();
    void editWordFile();
}
/**
 *定义Adapter继承Source类并实现Targetable接口
 */
class Adapter extends Source implements Targetable{
    private final static Log logger = LogFactory.getLog(Adapter.class);
    @Override
    public void editWordFile() {
        logger.info("a word file editing");
    }
}

/**
 * 对象适配器类
 */
class ObjectAdapter implements Targetable {
    private final static Log logger = LogFactory.getLog(ObjectAdapter.class);
    private Source source;
    public ObjectAdapter(Source source) {
        super();
        this.source = source;
    }
    @Override
    public void editTextFile() {
        this.source.editTextFile();
    }
    @Override
    public void editWordFile() {
        logger.info("a word file editing");
    }
}

/**
 * 使用类的适配器
 */
public class leiAdapter {
    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.editTextFile();
        target.editWordFile();
    }
}

/**
 * 接口适配器
 */

/**
 *定义公共接口Sourceable
 */
interface Sourceable {
    void editTextFile();
    void editWordFile();
}
/**
 * 定义抽象类AbstractAdapter
 */
abstract class AbstractAdapter implements Sourceable {
    @Override
    public void editTextFile() {}
    @Override
    public void editWordFile() {}
}
/**
 * 定义SourceSub1类 按需事先editTextFile()
 */
class SourceSub1 extends AbstractAdapter {
    private final static Log logger = LogFactory.getLog(SourceSub1.class);
    @Override
    public void editTextFile() {
        logger.info("a text file editing");
    }
}
