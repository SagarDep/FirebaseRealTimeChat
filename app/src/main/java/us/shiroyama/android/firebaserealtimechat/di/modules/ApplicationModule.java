package us.shiroyama.android.firebaserealtimechat.di.modules;

import android.app.Application;
import android.content.Context;

import com.squareup.otto.Bus;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import us.shiroyama.android.firebaserealtimechat.di.scopes.ContextType;
import us.shiroyama.android.firebaserealtimechat.view.util.BusHolder;

/**
 * Application {@link Module}
 *
 * @author Fumihiko Shiroyama (fu.shiroyama@gmail.com)
 */

@Module(includes = {
        FirebaseModule.class,
        RealmModule.class,
})
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application providesApplication() {
        return application;
    }

    @Provides
    @Singleton
    @Named(ContextType.APPLICATION)
    public Context providesContext() {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    public Bus providesBus() {
        return BusHolder.EVENT_BUS;
    }

}
