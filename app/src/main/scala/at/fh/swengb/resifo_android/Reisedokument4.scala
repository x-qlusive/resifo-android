package at.fh.swengb.resifo_android

import java.util.Calendar

import android.app.{AlertDialog, DatePickerDialog}
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{ArrayAdapter, DatePicker, EditText, Spinner}

class Reisedokument4 extends AppCompatActivity {
  private[resifo_android] var date: EditText = null
  private[resifo_android] var datePickerDialog: DatePickerDialog = null
  var person:Person = _

  def viewsBefüllen(p: Person) = {
    findViewById(R.id.reisedokumentNummer).asInstanceOf[EditText].setText(p.documentNr)
    findViewById(R.id.ausstellendebehoerde).asInstanceOf[EditText].setText(p.documentAgency)
    findViewById(R.id.date).asInstanceOf[EditText].setText(p.documentIssueDate)
  }

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_reisedokument)

    date = findViewById(R.id.date).asInstanceOf[EditText]
    date.setOnClickListener(new View.OnClickListener() {
      def onClick(v: View) {
        val c: Calendar = Calendar.getInstance
        val mYear: Int = c.get(Calendar.YEAR)
        val mMonth: Int = c.get(Calendar.MONTH)
        val mDay: Int = c.get(Calendar.DAY_OF_MONTH)
        datePickerDialog = new DatePickerDialog(Reisedokument4.this, new DatePickerDialog.OnDateSetListener() {
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
    if(person.documentNr != null){
      viewsBefüllen(person)
    }

    val spinner = findViewById(R.id.reisedokument).asInstanceOf[Spinner]
    val adapter = ArrayAdapter.createFromResource(this, R.array.array_reisedokument, android.R.layout.simple_spinner_item)
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    spinner.setAdapter(adapter)
  }

  def backToDi3(view: View): Unit = {
    onBackPressed()
  }
  /*
  *   Check for input for the other views
  *
   */
  def dataInput5(view: View): Unit = {

    val dokument: String = findViewById(R.id.reisedokument).toString
    val dokumentNr: String = findViewById(R.id.reisedokumentNummer).toString
    val dokumentBH: String = findViewById(R.id.ausstellendebehoerde).toString

    val cond1: Boolean = dokument == null
    val cond2: Boolean = dokument.equals("")
    val cond3: Boolean = dokumentNr == null
    val cond4: Boolean = dokumentNr.equals("")
    val cond5: Boolean = dokumentBH == null
    val cond6: Boolean = dokumentBH.equals("")

    if (cond1 | cond2 | cond3 | cond4 | cond5 | cond6 ) {
      val alertDialog = new AlertDialog.Builder(this).create()
      alertDialog.setTitle("ACHTUNG")
      alertDialog.setMessage("Achtung Dokument, Dokument Nummer sowie ausstellende Behörde " +
        "müssen ausgefüllt werden")
      alertDialog.show()
    } else {
      val jaIntent = new Intent(this, classOf[AnmeldungUnterkunft5])
      person = person.copy(documentAgency = dokumentBH, documentType = dokument,
        documentNr = dokumentNr, documentIssueDate = date.getText.toString)
      val bundle:Bundle = new Bundle()
      bundle.putSerializable("person", person)
      jaIntent.putExtras(bundle)
      startActivity(jaIntent);
    }
  }
}