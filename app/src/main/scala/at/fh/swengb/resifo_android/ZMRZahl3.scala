package at.fh.swengb.resifo_android

import android.app.AlertDialog
import android.content.{DialogInterface, Intent}
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioButton

class ZMRZahl3 extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_zmrzahl)
  }


  def backToDi2(view: View): Unit = {
    val i = new Intent(this, classOf[PersDaten2])
    startActivity(i)
  }

  def dataInput4(view: View): Unit = {

    val aut: RadioButton = findViewById(R.id.aut).asInstanceOf[RadioButton]
    val sonstige: RadioButton = findViewById(R.id.sonstige).asInstanceOf[RadioButton]
    val staatsangehörigkeit: View = findViewById(R.id.staatsangehörigkeit);

    if (aut.isChecked()) {
      val autIntent = new Intent(this, classOf[Reisedokument4]); // <----- START "Zuzug aus Ausland" ACTIVITY
      startActivity(autIntent);
    }

    else if (sonstige.isChecked()) {
      val sonstigeIntent = new Intent(this, classOf[Reisedokument4]); // <----- START "Hauptwohnsitz Nein" ACTIVITY
      startActivity(sonstigeIntent);
    }

    if (!aut.isChecked() && !sonstige.isChecked()) {
      val alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setTitle("ACHTUNG");
      alertDialog.setMessage("Sie müssen eine Staatsangehörigkeit auswählen");
      alertDialog.show();
    }


  }
}