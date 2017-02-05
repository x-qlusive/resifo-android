package at.fh.swengb.resifo_android;

/**
 * Created by Gam0r on 05.02.2017.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class maps extends AppCompatActivity {

    Button batn;
    TextView Hausnummer;
    TextView PLZ;
    TextView Ort;
    TextView Strasse;

    AppLocationService appLocationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_anmeldungunterkunft);
        Ort = (TextView) findViewById(R.id.anmeldungOrt);
        PLZ = (TextView) findViewById(R.id.anmeldungPlz);
        Strasse = (TextView) findViewById(R.id.anmeldungStrasse);
        Hausnummer = (TextView) findViewById(R.id.anmeldungHausnr);
        appLocationService = new AppLocationService(
                maps.this);


        batn = (Button) findViewById(R.id.anmeldunggps);
        batn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Location location = appLocationService
                        .getLocation(LocationManager.GPS_PROVIDER);

                //you can hard-code the lat & long if you have issues with getting it
                //remove the below if-condition and use the following couple of lines
                //double latitude = 37.422005;
                //double longitude = -122.084095

                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    //double latitude = 47.069718;
                    //double longitude = 15.409874;
                    LocationAddress locationAddress = new LocationAddress();
                    locationAddress.getAddressFromLocation(latitude, longitude,
                            getApplicationContext(), new GeocoderHandler());
                } else {
                    showSettingsAlert();
                }

            }
        });

    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                maps.this);
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        maps.this.startActivity(intent);
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            String location[] = locationAddress.split("\\r\\n|\\n|\\r");
            Strasse.setText(location[0].replaceAll("[0-9.,]+",""));
            Hausnummer.setText(location[2]);
            PLZ.setText(location[1].replaceAll("[^0-9.,]+",""));
            Ort.setText(location[1].replaceAll("[0-9.,]+",""));


        }
    }
}