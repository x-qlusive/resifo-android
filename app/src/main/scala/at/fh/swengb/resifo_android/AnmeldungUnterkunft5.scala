package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class AnmeldungUnterkunft5 extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_anmeldungunterkunft)
  }

  def backToDi4(view: View): Unit = {
    val i = new Intent(this, classOf[Reisedokument4])
    startActivity(i)
  }

  def dataInput6(view: View): Unit = {
    val i = new Intent(this, classOf[HauptwohnsitzNein6])
    startActivity(i)
  }
}