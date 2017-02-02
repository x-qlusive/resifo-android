package at.fh.swengb.resifo_android

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioButton

class AbmeldungUnterkunft8 extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_abmeldungunterkunft)
  }

  def backToDi7(view: View): Unit = {
    val i = new Intent(this, classOf[ZuzugAusland7])
    startActivity(i)
  }

  def dataInput9(view: View): Unit = {
    val i = new Intent(this, classOf[Unterkunftgeber9])
    startActivity(i)

    val abmeldungJa: RadioButton = findViewById(R.id.abmeldungJa).asInstanceOf[RadioButton]
    val abmeldungNein: RadioButton = findViewById(R.id.abmeldungNein).asInstanceOf[RadioButton]

    if (abmeldungJa.isChecked()) {
      val mIntent = new Intent(this, classOf[Unterkunftgeber9]); // <----- START "Unterkunftgeber" ACTIVITY
      startActivity(mIntent);
    }

    else if (abmeldungNein.isChecked()) {
      val wIntent = new Intent(this, classOf[Unterkunftgeber9]); // <----- START "Unterkunftgeber" ACTIVITY
      startActivity(wIntent);
    }

    if (!abmeldungJa.isChecked() && !abmeldungNein.isChecked()) {
      val alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setTitle("ACHTUNG");
      alertDialog.setMessage("Sie müssen angeben ob Sie ins Ausland ziehen");
      alertDialog.show();
    }
  }
}