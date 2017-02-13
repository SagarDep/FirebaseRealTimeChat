package us.shiroyama.android.firebaserealtimechat.di.modules;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import us.shiroyama.android.firebaserealtimechat.di.scopes.ActivityScope;
import us.shiroyama.android.firebaserealtimechat.di.scopes.ContextType;

/**
 * Activity {@link Module}
 *
 * @author Fumihiko Shiroyama (fu.shiroyama@gmail.com)
 */

@Module
public class ActivityModule {
    private final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    public AppCompatActivity providesAppCompatActivity() {
        return activity;
    }

    @ActivityScope
    @Provides
    public Activity providesActivity() {
        return activity;
    }

    @ActivityScope
    @Provides
    @Named(ContextType.ACTIVITY)
    public Context providesContext() {
        return activity;
    }

    @ActivityScope
    @Provides
    public LayoutInflater providesLayoutInflater() {
        return activity.getLayoutInflater();
    }
}
