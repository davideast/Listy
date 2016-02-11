package firebase.com.listy;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class AddItemDialogFragment extends DialogFragment {

    public AddItemDialogFragment() {
        super();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.add_dialog, null);
        final TextView textView = (TextView) dialogView.findViewById(R.id.addTextView);
        final Firebase ref = FirebaseRefFactory.getItemsRef();

        builder.setView(dialogView)
                .setMessage(R.string.dialog_add_item)
                .setPositiveButton(R.string.dialog_add_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String input = textView.getText().toString();
                        ref.push().setValue(input);
                    }
                });

        return builder.create();
    }
}