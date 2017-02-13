package us.shiroyama.android.firebaserealtimechat.di.modules;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import us.shiroyama.android.firebaserealtimechat.di.scopes.FragmentScope;

/**
 * Fragment {@link Module}
 *
 * @author Fumihiko Shiroyama (fu.shiroyama@gmail.com)
 */

@Module
public class FragmentModule {
    private final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @FragmentScope
    @Provides
    public FragmentManager providesFragmentManager() {
        return fragment.getFragmentManager();
    }
}
