package at.fh.swengb.resifo_android

import java.util.Calendar

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{DatePicker, EditText}

class Reisedokument4 extends AppCompatActivity {
  private[resifo_android] var date: EditText = null
  private[resifo_android] var datePickerDialog: DatePickerDialog = null

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
  }

  def backToDi3(view: View): Unit = {
    val i = new Intent(this, classOf[ZMRZahl3])
    startActivity(i)
  }

  def dataInput5(view: View): Unit = {
    val i = new Intent(this, classOf[AnmeldungUnterkunft5])
    startActivity(i)
  }
}