package us.shiroyama.android.firebaserealtimechat.di.components;

import dagger.Component;
import dagger.Subcomponent;
import us.shiroyama.android.firebaserealtimechat.di.modules.ActivityModule;
import us.shiroyama.android.firebaserealtimechat.di.modules.FragmentModule;
import us.shiroyama.android.firebaserealtimechat.di.scopes.ActivityScope;
import us.shiroyama.android.firebaserealtimechat.view.activity.ChatActivity;
import us.shiroyama.android.firebaserealtimechat.view.activity.LoginActivity;

/**
 * Activity {@link Component}
 *
 * @author Fumihiko Shiroyama (fu.shiroyama@gmail.com)
 */

@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(LoginActivity activity);

    void inject(ChatActivity activity);

    FragmentComponent plus(FragmentModule module);
}
