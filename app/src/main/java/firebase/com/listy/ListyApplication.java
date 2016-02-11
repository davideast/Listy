package firebase.com.listy;

import com.firebase.client.Firebase;

/**
 * Created by deast on 2/11/16.
 */
public class ListyApplication extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
