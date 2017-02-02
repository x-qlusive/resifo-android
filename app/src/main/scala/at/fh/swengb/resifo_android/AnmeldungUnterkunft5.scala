package at.fh.swengb.resifo_android

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.provider.Contacts.Intents
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{Button, RadioButton}

class AnmeldungUnterkunft5 extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_anmeldungunterkunft)
  }

  def backToDi4(view: View): Unit = {
    val i = new Intent(this, classOf[Reisedokument4])
    startActivity(i)
  }

  def dataInput6(view: View): Unit = {

    val Nein: RadioButton = findViewById(R.id.hauptNein).asInstanceOf[RadioButton]
    val Ja: RadioButton = findViewById(R.id.hauptJa).asInstanceOf[RadioButton]

    if (Ja.isChecked()) {
      val jaIntent = new Intent(this, classOf[ZuzugAusland7]); // <----- START "Zuzug aus Ausland" ACTIVITY
      startActivity(jaIntent);
    }
    else if (Nein.isChecked()) {
      val neinIntent = new Intent(this, classOf[HauptwohnsitzNein6]); // <----- START "Hauptwohnsitz Nein" ACTIVITY
      startActivity(neinIntent);
    }

    if (!Ja.isChecked() && !Nein.isChecked()) {
      val alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setTitle("ACHTUNG");
      alertDialog.setMessage("Bitte wählen Sie aus ob es sich um einen Hauptwohnsitz handelt");
      alertDialog.show();
    }

    }


}