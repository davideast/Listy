package firebase.com.listy;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class AddItemDialogFragment extends AppCompatDialogFragment {

    public AddItemDialogFragment() {
        super();
    }

    ItemAddedHandler mItemAddedHandler;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.add_dialog, null);
        final TextView textView = (TextView) dialogView.findViewById(R.id.addTextView);

        builder.setView(dialogView)
                .setMessage(R.string.dialog_add_item)
                .setPositiveButton(R.string.dialog_add_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String input = textView.getText().toString();
                        mItemAddedHandler.onItemAdded(input);
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mItemAddedHandler = (ItemAddedHandler) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener");
        }
    }

}

