package at.fh.swengb.resifo_android

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioButton

class AGBBestaetigung extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_agbbestaetigung)
  }

  // called by a button click - see main.xml
  def agbInfo(view: View): Unit = {
    val i = new Intent(this, classOf[AGBInformationen])
    startActivity(i)
  }

  def agbNext(view: View): Unit = {
    val baestetigung: RadioButton = findViewById(R.id.baestetigung).asInstanceOf[RadioButton]

    if (baestetigung.isChecked()) {
      val mIntent = new Intent(this, classOf[PersDaten1]); // <----- START "Personen Daten 1" ACTIVITY
      startActivity(mIntent);
    }

    if (!baestetigung.isChecked()) {
      val alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setTitle("ACHTUNG");
      alertDialog.setMessage("Sie müssen die Informationen zuvor bestätigen");
      alertDialog.show();
    }
  }

}