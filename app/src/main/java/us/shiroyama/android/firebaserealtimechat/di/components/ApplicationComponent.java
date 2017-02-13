package us.shiroyama.android.firebaserealtimechat.di.components;

import javax.inject.Singleton;

import dagger.Component;
import us.shiroyama.android.firebaserealtimechat.di.modules.ActivityModule;
import us.shiroyama.android.firebaserealtimechat.di.modules.ApplicationModule;

/**
 * Application {@link Component}
 *
 * @author Fumihiko Shiroyama (fu.shiroyama@gmail.com)
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    ActivityComponent plus(ActivityModule module);
}
