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

  private[resifo_android] var date: EditText = null
  private[resifo_android] var datePickerDialog: DatePickerDialog = null

  def viewsBefüllen(p: Person) = {
    findViewById(R.id.unterkunftgeber)
      .asInstanceOf[EditText].setText(p.landlord)
  }

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_unterkunftgeber)

    date = findViewById(R.id.date).asInstanceOf[EditText]
    date.setOnClickListener(new View.OnClickListener() {
      def onClick(v: View) {
        val c: Calendar = Calendar.getInstance
        val mYear: Int = c.get(Calendar.YEAR)
        val mMonth: Int = c.get(Calendar.MONTH)
        val mDay: Int = c.get(Calendar.DAY_OF_MONTH)
        datePickerDialog = new DatePickerDialog(Unterkunftgeber9.this,
          new DatePickerDialog.OnDateSetListener() {
            def onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int) {
              date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year)
            }
          }, mYear, mMonth, mDay)
        datePickerDialog.show
      }
    })
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