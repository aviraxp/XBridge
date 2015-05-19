package daylemk.xposed.xbridge.ui;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import daylemk.xposed.xbridge.action.Action;
import daylemk.xposed.xbridge.action.PlayAction;
import daylemk.xposed.xbridge.data.MainPreferences;
import daylemk.xposed.xbridge.utils.Log;

/**
 * Created by DayLemK on 2015/5/18.
 * the abstract fragment of all fragment in xbridge activity
 */
public abstract class AbstractPreferenceFragment extends PreferenceFragment{
    public static final String TAG = "AbstractPreferenceFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the preference of the fragment on create
        MainPreferences.setSharedPreferences(getPreferenceManager());
        // load the preference every time
        // EDIT: no need
//        MainPreferences.loadPreference();
        // first time on UI, load keys and values
        if (PlayAction.keyShow == null) {
            MainPreferences.loadPreferenceKeys(getResources());
            Log.d(TAG, "on create: reload preference keys");
            MainPreferences.loadPreference(getPreferenceManager());
        }
    }
}
