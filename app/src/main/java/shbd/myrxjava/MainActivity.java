package shbd.myrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTextView;
    Observable mSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textview);
        mTextView.setOnClickListener(this);

        Observable.OnSubscribe<Integer> onAttach = new Observable.OnSubscribe<Integer>() {
            @Override
            public void attach(Subscriber<Integer> subscriber) {
                subscriber.onNext(3435);
            }
        };

        mSubject = Observable.create(onAttach);
    }

    @Override
    public void onClick(View view) {
        mSubject.subscribe(new Subscriber<Integer>() {
            @Override
            public void onNext(Integer state) {
                Log.e("TAG", "哈哈," + state + ",我又有东西可以看啦");
            }
        });
    }
}
