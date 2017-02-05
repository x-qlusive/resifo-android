package at.fh.swengb.resifo_android

import java.util.Calendar

import android.app.{AlertDialog, DatePickerDialog}
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget._

class Unterkunftgeber9 extends AppCompatActivity {
  var person:Person = _

  def viewsBefüllen(p: Person) = {
    findViewById(R.id.unterkunftgeber)
      .asInstanceOf[EditText].setText(p.landlord)
  }

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_unterkunftgeber)


    val intent:Intent = this.getIntent()
    val bundle:Bundle = intent.getExtras()
    person = bundle.getSerializable("person").asInstanceOf[Person]
    if(person.landlord != null){
      viewsBefüllen(person)
    }
  }

  def backToDi8(view: View): Unit = {
    onBackPressed()
  }

  def dataInput10(view: View): Unit = {

    val unterkunftgeber: String = findViewById(R.id.unterkunftgeber)
      .asInstanceOf[EditText].getText.toString

    val cond1: Boolean = unterkunftgeber == null
    val cond2: Boolean = unterkunftgeber.equals("")

    if (!(cond1 | cond2)) {
      person.copy(landlord = unterkunftgeber)
    }

    val intent = new Intent(this, classOf[Meldepflichtiger10])
    val bundle: Bundle = new Bundle()
    bundle.putSerializable("person", person)
    intent.putExtras(bundle)
    startActivity(intent)
  }
}