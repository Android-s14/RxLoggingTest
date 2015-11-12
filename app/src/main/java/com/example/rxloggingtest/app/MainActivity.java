package com.example.rxloggingtest.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.fernandocejas.frodo.annotation.RxLogObservable;

import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getObservable().subscribe(new Action1<Boolean>() {
			@Override
			public void call(Boolean aBoolean) {
				Log.d("Rx", aBoolean.toString());
			}
		});
	}

	@RxLogObservable
	private Observable<Boolean> getObservable() {
		return Observable.just(true, false).subscribeOn(Schedulers.io());
	}

}
