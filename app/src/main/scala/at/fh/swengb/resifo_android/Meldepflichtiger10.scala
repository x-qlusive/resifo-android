package at.fh.swengb.resifo_android

import java.util.Calendar

import android.app.{AlertDialog, DatePickerDialog}
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{DatePicker, EditText}

class Meldepflichtiger10 extends AppCompatActivity {
  var person:Person =_

  private[resifo_android] var date: EditText = null
  private[resifo_android] var datePickerDialog: DatePickerDialog = null

  def viewsBefüllen(p: Person) = {
    findViewById(R.id.date).asInstanceOf[EditText].setText(p.date)
  }

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_meldepflichtiger)

    date = findViewById(R.id.date).asInstanceOf[EditText]
    date.setOnClickListener(new View.OnClickListener() {
      def onClick(v: View) {
        val c: Calendar = Calendar.getInstance
        val mYear: Int = c.get(Calendar.YEAR)
        val mMonth: Int = c.get(Calendar.MONTH)
        val mDay: Int = c.get(Calendar.DAY_OF_MONTH)
        datePickerDialog = new DatePickerDialog(Meldepflichtiger10.this,
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
    if(person.date != null){
      viewsBefüllen(person)
    }
  }

  def backToDi9(view: View): Unit = {
    onBackPressed()
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
      person = person.copy(date = date.getText.toString )
      val db : PersonDb = PersonDb(getApplicationContext())
      db.mkPersonDao().insert(person)
      val i = new Intent(this, classOf[MainActivity])
      startActivity(i)
    }
  }
}