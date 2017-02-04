package at.fh.swengb.resifo_android

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText

class Meldepflichtiger10 extends AppCompatActivity {
  var person:Person =_
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_meldepflichtiger)
    val intent:Intent = this.getIntent()
    val bundle:Bundle = intent.getExtras()
    person = bundle.getSerializable("person").asInstanceOf[Person]
  }

  def backToDi9(view: View): Unit = {
    val i = new Intent(this, classOf[Unterkunftgeber9])
    startActivity(i)
  }

  def dataSave1(view: View): Unit = {

    val unterschrift = findViewById(R.id.meldepflichtiger)
      .asInstanceOf[EditText].getText.toString

    val cond1: Boolean = unterschrift == null
    val cond2: Boolean = unterschrift.equals("")

    if (cond1 | cond2) {
      val alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setTitle("ACHTUNG");
      alertDialog.setMessage("Bitte geben Sie Ihren Namen an");
      alertDialog.show();
    }
    else if(unterschrift != (person.firstName + " " + person.secondName)){
      val alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setTitle("ACHTUNG");
      alertDialog.setMessage("Ihr Name und die angegebene Unterschrift müssen ident sein");
      alertDialog.show();
    }
    else {
      val db : SimpleDb = SimpleDb(getApplicationContext())
      db.mkPersonDao().insert(person)
      val i = new Intent(this, classOf[MainActivity])
      startActivity(i)
    }
  }
}