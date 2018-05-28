package com.example.franko.expertwisc.Tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;

public class PBDialog extends ProgressDialog{
    private ProgressDialog progressDialog;
    private int progressDialogStatus = 0;
    private Handler progressDialogHandler =  new Handler();

    public PBDialog(Context context) {
        super(context);
    }


    public void setProgressBar(){
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(true);
        progressDialog.setMessage("Cargando...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);
        progressDialog.setMax(100);
        progressDialog.show();
        progressDialogStatus = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressDialogStatus < 100){
                    progressDialogStatus += 30;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    progressDialogHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.setProgress(progressDialogStatus);
                        }
                    });
                }
                if (progressDialogStatus >= 100) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressDialog.dismiss();
                }

            }
        }).start();
    }

}

