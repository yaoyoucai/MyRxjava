package shbd.myrxjava;

/**
 * 项目名称：MyRxjava
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/1/10 16:06
 * 修改人：yh
 * 修改时间：2017/1/10 16:06
 * 修改备注：
 */
public class OperatorMap<T, R> implements Observable.Operator<R, T> {
    private IFun<? super T, ? extends R> convert;

    public OperatorMap(IFun<? super T, ? extends R> convert) {
        this.convert = convert;
    }

    @Override
    public Subscriber<? super T> convert(final Subscriber<? super R> subscriber) {
        return new Subscriber<T>() {
            @Override
            public void onNext(T state) {
                subscriber.onNext(convert.convert(state));
            }
        };
    }
}
