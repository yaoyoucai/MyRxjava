package shbd.myrxjava;

/**
 * 项目名称：MyRxjava
 * 类描述：观察者接口
 * 创建人：yh
 * 创建时间：2017/1/10 13:57
 * 修改人：yh
 * 修改时间：2017/1/10 13:57
 * 修改备注：
 */
public interface Subscriber<T> {
    void onNext(T state);
}
