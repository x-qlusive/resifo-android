package at.fh.swengb.resifo_android

import java.util.Calendar

import android.app.{AlertDialog, DatePickerDialog}
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{DatePicker, EditText, RadioButton}



class PersDaten1 extends AppCompatActivity {
  private[resifo_android] var date: EditText = null
  private[resifo_android] var datePickerDialog: DatePickerDialog = null

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_persdaten1)

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
  }

  def di1Home(view: View): Unit = {
    val i = new Intent(this, classOf[MainActivity])
    startActivity(i)
  }

  def dataInput2(view: View): Unit = {

    val vorname: EditText = findViewById(R.id.vorname).asInstanceOf[EditText]
    val nachname: EditText = findViewById(R.id.nachname).asInstanceOf[EditText]


    if (vorname == null | vorname.getText().equals("") | nachname == null | nachname.getText().equals("")) {
      val alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setTitle("ACHTUNG");
      alertDialog.setMessage("'Vorname' oder 'Nachname' wurde nicht ausgefüllt");
      alertDialog.show();

    }
    else{
      val jaIntent = new Intent(this, classOf[PersDaten2]); //
      startActivity(jaIntent);
    }

  }

}

