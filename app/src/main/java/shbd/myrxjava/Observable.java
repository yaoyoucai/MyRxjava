package shbd.myrxjava;


/**
 * 项目名称：MyRxjava
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/1/10 14:05
 * 修改人：yh
 * 修改时间：2017/1/10 14:05
 * 修改备注：
 */
public class Observable<T> {
    protected OnSubscribe onSubscribe;

    private Observable(OnSubscribe onAttach) {
        this.onSubscribe = onAttach;
    }

    public static <T> Observable<T> create(OnSubscribe<T> onAttach) {
        return new Observable(onAttach);
    }

    public void subscribe(Subscriber<T> subscriber) {
        onSubscribe.attach(subscriber);
    }

    public interface OnSubscribe<T> {
        void attach(Subscriber<T> subscriber);
    }

    public <R> Observable<R> map(IFun<? super T, ? extends R> fun) {
        OperatorMap operatorMap = new OperatorMap(fun);
        //根据操作符生成新的Observable,并返回,以便实现链式操作
        Observable observable = lift(operatorMap);
        return observable;
    }

    public <R> Observable<R> lift(final Operator<? extends R, ? extends T> operator) {
        return new Observable<>(new OnSubscribe() {
            @Override
            public void attach(Subscriber subscriber) {
                Subscriber<? extends T> convert = operator.convert(subscriber);
                Observable.this.onSubscribe.attach(convert);
            }
        });
    }

    public interface Operator<R, T> extends IFun<Subscriber<? super R>, Subscriber<? super T>> {
    }
}
