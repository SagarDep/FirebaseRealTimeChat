package us.shiroyama.android.firebaserealtimechat.view.activity;

import android.support.v7.app.AppCompatActivity;

import us.shiroyama.android.firebaserealtimechat.MyApplication;
import us.shiroyama.android.firebaserealtimechat.di.components.ActivityComponent;
import us.shiroyama.android.firebaserealtimechat.di.modules.ActivityModule;

/**
 * Base Activity providing {@link ActivityComponent}
 *
 * @author Fumihiko Shiroyama (fu.shiroyama@gmail.com)
 */

public abstract class BaseActivity extends AppCompatActivity {
    private ActivityComponent activityComponent;

    /**
     * @return {@link ActivityComponent}
     */
    public ActivityComponent getComponent() {
        if (activityComponent == null) {
            MyApplication myApplication = (MyApplication) getApplication();
            activityComponent = myApplication.getComponent().plus(new ActivityModule(this));
        }
        return activityComponent;
    }
}
