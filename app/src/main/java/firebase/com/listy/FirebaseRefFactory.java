package firebase.com.listy;

import com.firebase.client.Firebase;

public class FirebaseRefFactory {

    final static private String mUrl = "https://fsr003.firebaseio.com";

    public static Firebase getRef(String path) {
        if (path == null || path.isEmpty()) {
            return new Firebase(mUrl);
        }
        return new Firebase(mUrl).child(path);
    }

    public static Firebase getRef() { return getRef(null); }

    public static Firebase getItemsRef() { return getRef("items"); }


}
