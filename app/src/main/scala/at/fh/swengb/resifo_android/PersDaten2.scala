package at.fh.swengb.resifo_android

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioButton

class PersDaten2 extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_persdaten2)
  }

  def backToDi1(view: View): Unit = {
    val i = new Intent(this, classOf[PersDaten1])
    startActivity(i)
  }

  def dataInput3(view: View): Unit = {
    val m: RadioButton = findViewById(R.id.maennlich).asInstanceOf[RadioButton]
    val w: RadioButton = findViewById(R.id.weiblich).asInstanceOf[RadioButton]

    if (m.isChecked()) {
      val mIntent = new Intent(this, classOf[ZMRZahl3]); // <----- START "ZMR Zahl" ACTIVITY
      startActivity(mIntent);
    }

    else if (w.isChecked()) {
      val wIntent = new Intent(this, classOf[ZMRZahl3]); // <----- START "ZMR Zahl" ACTIVITY
      startActivity(wIntent);
    }

    if (!m.isChecked() && !w.isChecked()) {
      val alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setTitle("ACHTUNG");
      alertDialog.setMessage("Sie müssen ein Geschlecht auswählen");
      alertDialog.show();
    }
  }
}