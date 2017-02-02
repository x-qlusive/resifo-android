package at.fh.swengb.resifo_android

import android.app.AlertDialog
import android.content.{DialogInterface, Intent}
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioButton

class ZMRZahl3 extends AppCompatActivity {
  var person:Person = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_zmrzahl)
    val intent:Intent = this.getIntent()
    val bundle:Bundle = intent.getExtras()
    person = bundle.getSerializable("person").asInstanceOf[Person]
  }



  def backToDi2(view: View): Unit = {
    val i = new Intent(this, classOf[PersDaten2])
    startActivity(i)
  }

  def dataInput4(view: View): Unit = {

    val aut: RadioButton = findViewById(R.id.aut).asInstanceOf[RadioButton]
    val sonstige: RadioButton = findViewById(R.id.sonstige).asInstanceOf[RadioButton]
    val staatsangehörigkeit: String = findViewById(R.id.staatsangehörigkeit).toString
    var isAut:Boolean = false
    var isFilled:Boolean = false
    //TODO: Code duplication entfernen
    if (aut.isChecked()) {
      isAut = true
      person = person.copy(state = "Österreich")
    }

    else if (sonstige.isChecked()) {
      val cond1: Boolean = staatsangehörigkeit == null
      val cond2: Boolean = staatsangehörigkeit.equals("")

      if (cond1 | cond2 ) {
        val alertDialog = new AlertDialog.Builder(this).create()
        alertDialog.setTitle("ACHTUNG")
        alertDialog.setMessage("'Staatsangehörigkeit' wurde nicht ausgefüllt")
        alertDialog.show()
      } else {

      person = person.copy(state = staatsangehörigkeit)
      val sonstigeIntent = new Intent(this, classOf[Reisedokument4]); // <----- START "Hauptwohnsitz Nein" ACTIVITY
      startActivity(sonstigeIntent)}
    }

    if (!aut.isChecked() && !sonstige.isChecked()) {
      val alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setTitle("ACHTUNG");
      alertDialog.setMessage("Sie müssen eine Staatsangehörigkeit auswählen");
      alertDialog.show();
    }


  }
}