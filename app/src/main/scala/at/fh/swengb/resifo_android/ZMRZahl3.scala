package at.fh.swengb.resifo_android

import android.app.AlertDialog
import android.content.{DialogInterface, Intent}
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{EditText, RadioButton}

class ZMRZahl3 extends AppCompatActivity {
  var person:Person = _

  def viewsBefüllen(p: Person) = {
    if (p.state == "Österreich"){
      findViewById(R.id.aut).asInstanceOf[RadioButton].setChecked(true)
    }
    else{
      findViewById(R.id.sonstige).asInstanceOf[RadioButton].setChecked(true)
      findViewById(R.id.staatsangehörigkeit).asInstanceOf[EditText].setText(p.state)
    }
  }

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_zmrzahl)
    val intent:Intent = this.getIntent()
    val bundle:Bundle = intent.getExtras()
    person = bundle.getSerializable("person").asInstanceOf[Person]
    if(person.state != null){
      viewsBefüllen(person)
    }
  }



  def backToDi2(view: View): Unit = {
    onBackPressed()
  }

  def dataInput4(view: View): Unit = {

    val aut: RadioButton = findViewById(R.id.aut).asInstanceOf[RadioButton]
    val sonstige: RadioButton = findViewById(R.id.sonstige).asInstanceOf[RadioButton]
    val staatsangehörigkeit: String = findViewById(R.id.staatsangehörigkeit).toString
    var isFilled:Boolean = false
    //TODO: Code duplication entfernen
    if (aut.isChecked()) {
      isFilled = true
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
        isFilled = true
      person = person.copy(state = staatsangehörigkeit)
      }
    }

    if (!aut.isChecked() && !sonstige.isChecked()) {
      val alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setTitle("ACHTUNG");
      alertDialog.setMessage("Sie müssen eine Staatsangehörigkeit auswählen");
      alertDialog.show();
    }

    if (isFilled == true){
      val sonstigeIntent = new Intent(this, classOf[Reisedokument4]) // <----- START "Hauptwohnsitz Nein" ACTIVITY
      val bundle:Bundle = new Bundle()
      bundle.putSerializable("person", person)
      sonstigeIntent.putExtras(bundle)
      startActivity(sonstigeIntent)
    }


  }
}