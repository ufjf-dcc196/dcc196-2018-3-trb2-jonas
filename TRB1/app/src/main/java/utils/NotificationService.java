package utils;

import android.view.View;
import android.widget.Toast;

public class NotificationService {
    public static void sendToast(View view, String message){
        Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
