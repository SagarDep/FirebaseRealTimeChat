package us.shiroyama.android.firebaserealtimechat.di.components;

import dagger.Component;
import dagger.Subcomponent;
import us.shiroyama.android.firebaserealtimechat.di.modules.FragmentModule;
import us.shiroyama.android.firebaserealtimechat.di.scopes.FragmentScope;

/**
 * Fragment {@link Component}
 *
 * @author Fumihiko Shiroyama (fu.shiroyama@gmail.com)
 */

@FragmentScope
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
}
