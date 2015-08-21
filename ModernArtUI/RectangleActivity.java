package com.example.administrator.modernartui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class RectangleActivity extends Activity {

    private static final String TAG = "RectangleActivity";
    private DialogFragment mDialog;
    private SeekBar colorChange;
    private Button mShutdownButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);
        final ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        final ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        final ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        final ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
        final ImageView imageView5 = (ImageView) findViewById(R.id.imageView5);
        final ColorDrawable colorDraw1 = (ColorDrawable) imageView1.getDrawable();
        final ColorDrawable colorDraw2 = (ColorDrawable) imageView2.getDrawable();
        final ColorDrawable colorDraw3 = (ColorDrawable) imageView3.getDrawable();
        final ColorDrawable colorDraw4 = (ColorDrawable) imageView4.getDrawable();
        final ColorDrawable colorDraw5 = (ColorDrawable) imageView5.getDrawable();
        
        final int color1A = Color.alpha(colorDraw1.getColor());
        final int color1R = Color.red(colorDraw1.getColor());
        final int color1G = Color.green(colorDraw1.getColor());
        final int color1B = Color.blue(colorDraw1.getColor());
        
        final int color2A = Color.alpha(colorDraw2.getColor());
        final int color2R = Color.red(colorDraw2.getColor());
        final int color2G = Color.green(colorDraw2.getColor());
        final int color2B = Color.blue(colorDraw2.getColor());
        
        final int color3A = Color.alpha(colorDraw3.getColor());
        final int color3R = Color.red(colorDraw3.getColor());
        final int color3G = Color.green(colorDraw3.getColor());
        final int color3B = Color.blue(colorDraw3.getColor());

        final int color4A = Color.alpha(colorDraw4.getColor());
        final int color4R = Color.red(colorDraw4.getColor());
        final int color4G = Color.green(colorDraw4.getColor());
        final int color4B = Color.blue(colorDraw4.getColor());
        
        final int color5A = Color.alpha(colorDraw5.getColor());
        final int color5R = Color.red(colorDraw5.getColor());
        final int color5G = Color.green(colorDraw5.getColor());
        final int color5B = Color.blue(colorDraw5.getColor());
        
        colorChange = (SeekBar) findViewById(R.id.seekBar);
        colorChange.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged;
            
            int color1RCopy;
            int color1GCopy;
            int color1BCopy;

            int color2RCopy;
            int color2GCopy;
            int color2BCopy;

            int color3RCopy;
            int color3GCopy;
            int color3BCopy;

            int color5RCopy;
            int color5GCopy;
            int color5BCopy;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                progressChanged = progress;
                    color1RCopy = color1R + progressChanged;
                    color1GCopy = color1G - progressChanged;
                    color1BCopy = color1B - progressChanged;

                    color2RCopy = color2R - progressChanged;
                    color2GCopy = color2G + progressChanged;
                    color2BCopy = color2B - progressChanged;

                    color3RCopy = color3R - progressChanged;
                    color3GCopy = color3G + progressChanged;
                    color3BCopy = color3B + progressChanged;

                    color5RCopy = color5R + progressChanged;
                    color5GCopy = color5G + progressChanged;
                    color5BCopy = color5B - progressChanged;
/*                color1RCopy = (color1RCopy>255)?255:color1RCopy;
                color1RCopy = (color1RCopy<0)?0:color1RCopy;
                color1GCopy = (color1GCopy>255)?255:color1GCopy;
                color1GCopy = (color1GCopy<0)?0:color1GCopy;*/
                colorDraw1.setColor(Color.argb(color1A, color1RCopy, color1GCopy,color1BCopy));
                colorDraw2.setColor(Color.argb(color2A, color2RCopy, color2GCopy,color2BCopy));
                colorDraw3.setColor(Color.argb(color3A, color3RCopy, color3GCopy,color3BCopy));
                colorDraw5.setColor(Color.argb(color5A, color5RCopy, color5GCopy,color5BCopy));
                imageView1.setImageDrawable(colorDraw1);
                imageView2.setImageDrawable(colorDraw2);
                imageView3.setImageDrawable(colorDraw3);
                imageView5.setImageDrawable(colorDraw5);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(RectangleActivity.this, "Seek bar progress:" + progressChanged
                                + "\nTop left RGB:"+ color1RCopy+" "+color1GCopy+" "+color1BCopy
                                + "\nBottom left RGB:"+ color2RCopy+" "+color2GCopy+" "+color2BCopy
                                + "\nTop right RGB:"+ color3RCopy+" "+color3GCopy+" "+color3BCopy
                                + "\nMiddle right RGB:"+ color4R+" "+color4G+" "+color4B
                                + "\nBottom right RGB:"+ color5RCopy+" "+color5GCopy+" "+color5BCopy,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rectangle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.more_info) {
/*            // Create a new AlertDialogFragment
            mDialog = MOMADialogFragment.newInstance();

            // Show AlertDialogFragment
            mDialog.show(getFragmentManager(), "Alert");*/
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Abort or complete ShutDown based on value of shouldContinue
    private void continueShutdown(boolean shouldContinue) {
        if (shouldContinue) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org"));
            startActivity(browserIntent);

        } else {

            // Abort ShutDown and dismiss dialog
            mDialog.dismiss();
        }
    }
    // Class that creates the AlertDialog
    public static class MOMADialogFragment extends DialogFragment {

        public static MOMADialogFragment newInstance() {
            return new MOMADialogFragment();
        }

        // Build AlertDialog using AlertDialog.Builder
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new AlertDialog.Builder(getActivity())
                    .setMessage("Click here to learn more")
                    .setTitle("Inspired by the work of artists such as Piet Mondrian and Ben Nicholson.")
                            // User cannot dismiss dialog by hitting back button
                    .setCancelable(false)
                            // Set up No Button
                    .setNegativeButton("Not Now",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    ((RectangleActivity) getActivity())
                                            .continueShutdown(false);
                                }
                            })
                            // Set up Yes Button
                    .setPositiveButton("Visit MOMA",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        final DialogInterface dialog, int id) {
                                    ((RectangleActivity) getActivity())
                                            .continueShutdown(true);
                                }
            }).create();
        }
    }
}
