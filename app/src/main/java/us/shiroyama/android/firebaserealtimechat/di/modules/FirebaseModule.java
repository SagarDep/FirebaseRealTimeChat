package us.shiroyama.android.firebaserealtimechat.di.modules;

import android.content.Context;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import us.shiroyama.android.firebaserealtimechat.BuildConfig;
import us.shiroyama.android.firebaserealtimechat.R;
import us.shiroyama.android.firebaserealtimechat.di.scopes.ContextType;

/**
 * Firebase {@link Module}
 *
 * @author Fumihiko Shiroyama (fu.shiroyama@gmail.com)
 */

@Module
public class FirebaseModule {

    @Singleton
    @Provides
    public FirebaseAnalytics providesFirebaseAnalytics(@Named(ContextType.APPLICATION) Context context) {
        return FirebaseAnalytics.getInstance(context);
    }

    @Singleton
    @Provides
    public FirebaseAuth providesFirebaseAuth() {
        return FirebaseAuth.getInstance();
    }

    @Singleton
    @Provides
    public FirebaseRemoteConfigSettings providesFirebaseRemoteConfigSettings() {
        return new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();
    }

    @Singleton
    @Provides
    public FirebaseRemoteConfig providesFirebaseRemoteConfig(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        firebaseRemoteConfig.setConfigSettings(firebaseRemoteConfigSettings);
        firebaseRemoteConfig.setDefaults(R.xml.remote_config_defaults);
        return firebaseRemoteConfig;
    }

    @Singleton
    @Provides
    public FirebaseDatabase providesFirebaseDatabase() {
        return FirebaseDatabase.getInstance();
    }

    @Singleton
    @Provides
    public DatabaseReference providesDatabaseReference(FirebaseDatabase firebaseDatabase) {
        return firebaseDatabase.getReference();
    }

    @Singleton
    @Provides
    public FirebaseStorage providesFirebaseStorage() {
        return FirebaseStorage.getInstance();
    }

    @Singleton
    @Provides
    public StorageReference providesStorageReference(FirebaseStorage firebaseStorage) {
        return firebaseStorage.getReferenceFromUrl(BuildConfig.FIREBASE_STORAGE_BUCKET);
    }

}
