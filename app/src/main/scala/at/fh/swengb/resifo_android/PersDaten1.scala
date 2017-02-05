package at.fh.swengb.resifo_android

import java.util.Calendar

import android.app.{AlertDialog, DatePickerDialog}
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget._


class PersDaten1 extends AppCompatActivity {
  private[resifo_android] var date: EditText = null
  private[resifo_android] var datePickerDialog: DatePickerDialog = null

  var person:Person = _

  def viewsBefüllen(p: Person) = {
    findViewById(R.id.nachname).asInstanceOf[EditText].setText(p.secondName)
    findViewById(R.id.vorname).asInstanceOf[EditText].setText(p.firstName)
    findViewById(R.id.date).asInstanceOf[EditText].setText(p.dateOfBirth)
  }

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_persdaten1)
    val intent:Intent = this.getIntent()
    val bundle:Bundle = intent.getExtras()
    person = bundle.getSerializable("person").asInstanceOf[Person]
    date = findViewById(R.id.date).asInstanceOf[EditText]
    date.setOnClickListener(new View.OnClickListener() {
      def onClick(v: View) {
        val c: Calendar = Calendar.getInstance
        val mYear: Int = c.get(Calendar.YEAR)
        val mMonth: Int = c.get(Calendar.MONTH)
        val mDay: Int = c.get(Calendar.DAY_OF_MONTH)
        datePickerDialog = new DatePickerDialog(PersDaten1.this, new DatePickerDialog.OnDateSetListener() {
          def onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int) {
            date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year)
          }
        }, mYear, mMonth, mDay)
        datePickerDialog.show
      }
    })
    if(person.firstName != null){
      viewsBefüllen(person)
    }
    val spinner = findViewById(R.id.akadgrad).asInstanceOf[Spinner]
    val adapter = ArrayAdapter.createFromResource(this, R.array.array_akadgrad, android.R.layout.simple_spinner_item)
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    spinner.setAdapter(adapter)
  }

  def di1Home(view: View): Unit = {
    val i = new Intent(this, classOf[MainActivity])
    startActivity(i)
  }

  def dataInput2(view: View): Unit = {

    val vorname: String = findViewById(R.id.vorname).asInstanceOf[EditText].getText.toString
    val nachname: String = findViewById(R.id.nachname).asInstanceOf[EditText].getText.toString

    val cond1: Boolean = vorname == null
    val cond2: Boolean = vorname.equals("")
    val cond3: Boolean = nachname == null
    val cond4: Boolean = nachname.equals("")

    if (cond1 | cond2 | cond3 | cond4) {
      val alertDialog = new AlertDialog.Builder(this).create()
      alertDialog.setTitle("ACHTUNG")
      alertDialog.setMessage("'Vorname' oder 'Nachname' wurde nicht ausgefüllt")
      alertDialog.show()
    } else {
      person = person.copy(firstName = vorname, secondName = nachname, dateOfBirth = date.getText.toString)
      val jaIntent = new Intent(this, classOf[PersDaten2])
      val bundle:Bundle = new Bundle()
      bundle.putSerializable("person", person)
      jaIntent.putExtras(bundle)
      startActivity(jaIntent)
    }

  }

}

