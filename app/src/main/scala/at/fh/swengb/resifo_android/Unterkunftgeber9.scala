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
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_unterkunftgeber)


    val intent:Intent = this.getIntent()
    val bundle:Bundle = intent.getExtras()
    person = bundle.getSerializable("person").asInstanceOf[Person]
  }

  def backToDi8(view: View): Unit = {
    val i = new Intent(this, classOf[AbmeldungUnterkunft8])
    startActivity(i)
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