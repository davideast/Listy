package firebase.com.listy;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.firebase.client.Firebase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemAddedHandler {

    // Reference to /items node
    // new Firebase("<my-firebase-app>.firebaseio.com/items")
    Firebase mRef = FirebaseRefFactory.getItemsRef();

    // Data
    ArrayList<String> mItems = new ArrayList<>();
    ArrayAdapter mAdapter;

    // UI
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        mListView = (ListView) findViewById(R.id.listView);

        // Create FAB button to display DialogFragment
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show DialogFrament onClick
                AppCompatDialogFragment newFragment = new AddItemDialogFragment();
                newFragment.show(getSupportFragmentManager(), "Add Item");
            }
        });
    }

    @Override
    public void onItemAdded(String item) {
        mItems.add(item);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onStart() {
        super.onStart();

        mItems.add("First item");
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mItems);
        mListView.setAdapter(mAdapter);

    }
}
