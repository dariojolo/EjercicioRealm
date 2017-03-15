package dariojolo.com.ejerciciorealm.app;

import android.app.Application;
import android.util.Log;

import java.util.concurrent.atomic.AtomicInteger;

import dariojolo.com.ejerciciorealm.model.Ciudad;
import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by rodrigrl on 15/03/2017.
 */

public class MyApplication extends Application {
    public static AtomicInteger CiudadID = new AtomicInteger();
    private static final String TAG = "MyApplication";

    @Override
    public void onCreate(){
        super.onCreate();
        setUpRealmConfig();
        Realm realm = Realm.getDefaultInstance();
        CiudadID = getIdByTable(realm, Ciudad.class);
        realm.close();
    }
    private void setUpRealmConfig(){
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .migration(new MyMigration())
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        /*RealmConfiguration config = new RealmConfiguration
                .Builder(getApplicationContext())
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config); */
    }
    private class MyMigration implements RealmMigration {
        @Override
        public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
            Log.w(TAG, "migrate() called with: " + "realm = [" + realm + "]," +
                    "oldVersion = [" + oldVersion + "], newVersion = [" + newVersion + "]");
        }
    }
    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T>anyClass){
        RealmResults<T> results = realm.where(anyClass).findAll();
        if (results.size()>0){
            return new AtomicInteger(results.max("id").intValue());
        }else{
            return new AtomicInteger();
        }
    }
}
