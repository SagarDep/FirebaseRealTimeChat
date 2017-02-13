package us.shiroyama.android.firebaserealtimechat.view.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;

import us.shiroyama.android.firebaserealtimechat.di.components.FragmentComponent;
import us.shiroyama.android.firebaserealtimechat.di.modules.FragmentModule;
import us.shiroyama.android.firebaserealtimechat.view.activity.BaseActivity;

/**
 * Base Fragment providing {@link FragmentComponent}
 *
 * @author Fumihiko Shiroyama (fu.shiroyama@gmail.com)
 */

public abstract class BaseFragment extends Fragment {
    private FragmentComponent fragmentComponent;

    /**
     * @return {@link FragmentComponent}
     */
    protected FragmentComponent getComponent() {
        if (fragmentComponent == null) {
            Activity activity = getActivity();
            if (!(activity instanceof BaseActivity)) {
                throw new IllegalStateException("Activity must be the subclass of BaseActivity");
            }
            fragmentComponent = ((BaseActivity) activity).getComponent().plus(new FragmentModule(this));
        }
        return fragmentComponent;
    }
}
