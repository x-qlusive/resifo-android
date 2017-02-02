package at.fh.swengb.resifo_android

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{RadioButton, TextView}

class ZuzugAusland7 extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_zuzugausland)
  }

  def backToDi5(view: View): Unit = {
    val i = new Intent(this, classOf[AnmeldungUnterkunft5])
    startActivity(i)
  }

  def dataInput8(view: View): Unit = {

    val auslandJa: RadioButton = findViewById(R.id.auslandJa).asInstanceOf[RadioButton]
    val auslandNein: RadioButton = findViewById(R.id.auslandNein).asInstanceOf[RadioButton]
    val staatsangabe: TextView = findViewById(R.id.staatsangabe).asInstanceOf[TextView]

    if (auslandJa.isChecked()) {
      val mIntent = new Intent(this, classOf[AbmeldungUnterkunft8]); // <----- START "ZMR Zahl" ACTIVITY
      startActivity(mIntent);
    }


    if (auslandNein.isChecked()) {
      val wIntent = new Intent(this, classOf[AbmeldungUnterkunft8]); // <----- START "ZMR Zahl" ACTIVITY
      startActivity(wIntent);
    }

    if (!auslandJa.isChecked() && !auslandNein.isChecked()) {
      val alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setTitle("ACHTUNG");
      alertDialog.setMessage("Zuzug aus dem Auswahl muss ausgewählt sein");
      alertDialog.show();
    }

  }
}