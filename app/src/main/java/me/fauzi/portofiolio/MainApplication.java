package me.fauzi.portofiolio;

import android.app.Application;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;
import com.orhanobut.hawk.LogLevel;

/**
 * Created by akhma on 02/10/2016.
 */
public class MainApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Hawk.init(this)
      .setEncryptionMethod(HawkBuilder.EncryptionMethod.MEDIUM)
      .setStorage(HawkBuilder.newSqliteStorage(this))
      .setLogLevel(LogLevel.FULL)
      .build();
  }
}
