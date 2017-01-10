package shbd.myrxjava;

/**
 * 项目名称：MyRxjava
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/1/10 15:45
 * 修改人：yh
 * 修改时间：2017/1/10 15:45
 * 修改备注：
 */
public interface IFun<T, R> {
    R convert(T t);
}
