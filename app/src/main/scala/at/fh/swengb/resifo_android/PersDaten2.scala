package at.fh.swengb.resifo_android

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{ArrayAdapter, EditText, RadioButton, Spinner}


class PersDaten2 extends AppCompatActivity {
  var person:Person = _

  def viewsBefüllen(p: Person) = {
    if (p.sex == "männlich")
      {
        findViewById(R.id.maennlich).asInstanceOf[RadioButton].setChecked(true)
      }
    else{
      findViewById(R.id.weiblich).asInstanceOf[RadioButton].setChecked(true)
    }
    findViewById(R.id.familienstand).asInstanceOf[EditText].setText(p.civilStatus)
    findViewById(R.id.geburtsort).asInstanceOf[EditText].setText(p.birthCity)
  }

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_persdaten2)
    val intent:Intent = this.getIntent()
    val bundle:Bundle = intent.getExtras()
    person = bundle.getSerializable("person").asInstanceOf[Person]
    if(person.sex != null){
      viewsBefüllen(person)
    }
    val spinner = findViewById(R.id.religion).asInstanceOf[Spinner]
    val adapter = ArrayAdapter.createFromResource(this, R.array.array_religion, android.R.layout.simple_spinner_item)
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    spinner.setAdapter(adapter)

  }

  def backToDi1(view: View): Unit = {
    onBackPressed()
  }

  def dataInput3(view: View): Unit = {
    val m: RadioButton = findViewById(R.id.maennlich).asInstanceOf[RadioButton]
    val w: RadioButton = findViewById(R.id.weiblich).asInstanceOf[RadioButton]

    val familienstand: String = findViewById(R.id.familienstand).asInstanceOf[EditText].getText.toString
    val geburtsort: String = findViewById(R.id.geburtsort).asInstanceOf[EditText].getText.toString

    if (m.isChecked()) {
      person = person.copy(sex = "männlich")
    }

    else if (w.isChecked()) {
      person = person.copy(sex = "weiblich")
    }

    if (!m.isChecked() && !w.isChecked()) {
      val alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setTitle("ACHTUNG");
      alertDialog.setMessage("Sie müssen ein Geschlecht auswählen");
      alertDialog.show();
    }


    val cond1: Boolean = familienstand == null
    val cond2: Boolean = familienstand.equals("")
    val cond3: Boolean = geburtsort == null
    val cond4: Boolean = geburtsort.equals("")

    if (cond1 | cond2 ) {
      val alertDialog = new AlertDialog.Builder(this).create()
      alertDialog.setTitle("ACHTUNG")
      alertDialog.setMessage("Bitte alle Felder ausfüllen")
      alertDialog.show()
    } else {
      val jaIntent = new Intent(this, classOf[ZMRZahl3])
      person = person.copy(civilStatus = familienstand, birthCity = geburtsort)
      val bundle:Bundle = new Bundle()
      bundle.putSerializable("person", person)
      jaIntent.putExtras(bundle)//
      startActivity(jaIntent)
    }
  }
}