package at.fh.swengb.resifo_android

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{RadioButton, TextView}

class ZuzugAusland7 extends AppCompatActivity {
  var person:Person = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_zuzugausland)
    val intent:Intent = this.getIntent()
    val bundle:Bundle = intent.getExtras()
    person = bundle.getSerializable("person").asInstanceOf[Person]
  }

  def backToDi5(view: View): Unit = {
    val i = new Intent(this, classOf[AnmeldungUnterkunft5])
    startActivity(i)
  }

  def dataInput8(view: View): Unit = {

    val auslandJa: RadioButton = findViewById(R.id.auslandJa).asInstanceOf[RadioButton]
    val auslandNein: RadioButton = findViewById(R.id.auslandNein).asInstanceOf[RadioButton]
    val staatsangabe: String = findViewById(R.id.staatsangabe).asInstanceOf[TextView].toString

    if (auslandJa.isChecked()) {
      val mIntent = new Intent(this, classOf[AbmeldungUnterkunft8]); // <----- START "ZMR Zahl" ACTIVITY
      startActivity(mIntent);
    }


    if (auslandNein.isChecked()) {
      val cond1: Boolean = staatsangabe == null
      val cond2: Boolean = staatsangabe.equals("")
      if (cond1 | cond2) {
        val alertDialog = new AlertDialog.Builder(this).create()
        alertDialog.setTitle("ACHTUNG")
        alertDialog.setMessage("'Staat' bitte ausfüllen")
        alertDialog.show()
      } else {
        person = person.copy(oldState = staatsangabe)
        val jaIntent = new Intent(this, classOf[AbmeldungUnterkunft8])
        val bundle:Bundle = new Bundle()
        bundle.putSerializable("person", person)
        jaIntent.putExtras(bundle)
        startActivity(jaIntent)
      }
    }

    if (!auslandJa.isChecked() && !auslandNein.isChecked()) {
      val alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setTitle("ACHTUNG");
      alertDialog.setMessage("Bitte geben Sie an, ob Sie aus dem Ausland zuziehen");
      alertDialog.show();
    }

  }
}