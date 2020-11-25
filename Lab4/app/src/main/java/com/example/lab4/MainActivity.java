package com.example.lab4;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnOpenInGoogleMaps(View view){

        EditText teamAddress = (EditText) findViewById(R.id.address);

        //Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddress.getText());

        //Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        //Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        //Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }
    public void OnSetAvatarButton (View view){
        //Application Context and Activity

        Intent intent = new Intent (getApplicationContext(), ProfileActivity.class);
        startActivityForResult(intent,0);
    }
    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;

        //Getting the Avatar Image we show to our users
        ImageView avatarImage = (ImageView) findViewById(R.id.avatar);

        //Figuring out the correct Image
        String drawableName = "ic_logo_00";
        switch (data.getIntExtra("imageID", R.id.iteam)) {
            case R.id.iteam:
                drawableName = "ic_logo_00";
                break;
            case R.id.fury:
                drawableName = "ic_logo_01";
                break;
            case R.id.blackstar:
                drawableName = "ic_logo_02";
                break;
            case R.id.mteam:
                drawableName = "ic_logo_03";
                break;
            case R.id.barcelone:
                drawableName = "ic_logo_04";
                break;
            case R.id.canada:
                drawableName = "ic_logo_05";
                break;
            default:
                drawableName = "ic_logo_00";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }

}