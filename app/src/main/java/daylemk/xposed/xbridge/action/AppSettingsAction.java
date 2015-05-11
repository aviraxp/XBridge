package daylemk.xposed.xbridge.action;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;

import daylemk.xposed.xbridge.data.MainPreferences;
import daylemk.xposed.xbridge.hook.Hook;

/**
 * @author DayLemK
 * @version 1.0
 * 28-四月-2015 9:16:48
 */
public class AppSettingsAction extends Action {
    public static final String TAG = "AppSettingsAction";
    public static final String STR_DESC = "View in AppSettings";
    public static final String PKG_NAME = "de.robv.android.xposed.mods.appsettings";
    public static final String ACTIVITY_CLASS_NAME = PKG_NAME + ".settings.ApplicationSettings";
    public static final String ARG_PACKAGE_NAME = "package";

    public static final String CLASS_NAME = AppSettingsAction.class.getSimpleName();
    public static final String PREF_SHOW_IN_RECENT_TASK = MainPreferences.PREF_SHOW_IN_RECENT_TASK +
            CLASS_NAME;
    public static final boolean PREF_SHOW_IN_RECENT_TASK_DEFAULT = true;
    public static final String PREF_SHOW_IN_STATUS_BAR = MainPreferences.PREF_SHOW_IN_STATUS_BAR +
            CLASS_NAME;
    public static final boolean PREF_SHOW_IN_STATUS_BAR_DEFAULT = true;
    public static final String PREF_SHOW_IN_APP_INFO = MainPreferences.PREF_SHOW_IN_APP_INFO +
            CLASS_NAME;
    public static final boolean PREF_SHOW_IN_APP_INFO_DEFAULT = true;
    // TODO: true for testing
    public static boolean isShowInRecentTask = true;
    public static boolean isShowInStatusBar = true;
    public static boolean isShowInAppInfo = true;

    public static Drawable sIcon = null;

    @Override
    protected Intent getIntent(Hook hook, String pkgName) {
        Intent intent = new Intent();
        intent.setClassName(PKG_NAME, ACTIVITY_CLASS_NAME);
        intent.putExtra(ARG_PACKAGE_NAME, pkgName);
        return intent;
    }

    @Override
    protected void handleData(Context context, String pkgName) {
    }

    @Override
    public Drawable getIcon(PackageManager packageManager)
    {
        if(sIcon == null){
            sIcon = getPackageIcon(packageManager, PKG_NAME);
        }
        return sIcon;
    }

    @Override
    public String getMenuTitle() {
        return STR_DESC;
    }

}