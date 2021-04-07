package com.example.lab5_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // Проверяем, какое ШС пришло в приемник
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {

            // Создаем Intent на запуск Activity
            Intent i = new Intent(context, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.putExtra("message", "Hello!");

            context.startActivity(i);
        }
    }

}
