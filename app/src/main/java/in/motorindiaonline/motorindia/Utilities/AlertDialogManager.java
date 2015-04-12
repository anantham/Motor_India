package in.motorindiaonline.motorindia.Utilities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

public class AlertDialogManager {

    /**
     * Function to display simple Alert Dialog
     * @param context - application context
     * @param title - alert dialog title
     * @param message - alert message
     * @param status - success/failure (used to set cancelable)
     * */

     public void showAlertDialog(Context context, String title, String message, Boolean status) {
         new AlertDialog.Builder(context)
                 .setTitle(title)
                 .setMessage(message)
                 .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         Log.i(CommonUtilities.TAG,"ok has been clicked");
                     }
                 })
                 .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         Log.i(CommonUtilities.TAG,"Cancel has been clicked");
                     }
                 })
                 .setIcon(android.R.drawable.ic_dialog_alert)
                 .setCancelable(status)
                 .show();
    }
}