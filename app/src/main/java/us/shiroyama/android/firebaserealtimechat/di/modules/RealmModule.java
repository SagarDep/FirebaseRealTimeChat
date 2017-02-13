package us.shiroyama.android.firebaserealtimechat.di.modules;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import us.shiroyama.android.firebaserealtimechat.BuildConfig;
import us.shiroyama.android.firebaserealtimechat.di.scopes.ContextType;
import us.shiroyama.android.firebaserealtimechat.realm.MyRealmMigration;

/**
 * Realm {@link Module}
 *
 * @author Fumihiko Shiroyama (fu.shiroyama@gmail.com)
 */

@Module
public class RealmModule {

    @Singleton
    @Provides
    public RealmConfiguration providesRealmConfiguration(@Named(ContextType.APPLICATION) Context context) {
        Realm.init(context);
        return new RealmConfiguration.Builder()
                .modules(Realm.getDefaultModule())
                .schemaVersion(BuildConfig.REALM_SCHEMA_VERSION)
                .migration(new MyRealmMigration())
                .build();
    }

    @Singleton
    @Provides
    public Realm providesRealm(RealmConfiguration realmConfiguration) {
        return Realm.getInstance(realmConfiguration);
    }

}
