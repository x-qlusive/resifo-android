package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class HauptwohnsitzNein6 extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_hauptwohnsitznein)
  }

  def backToDi5(view: View): Unit = {
    val i = new Intent(this, classOf[AnmeldungUnterkunft5])
    startActivity(i)
  }

  def dataInput7(view: View): Unit = {
    val i = new Intent(this, classOf[ZuzugAusland7])
    startActivity(i)
  }
}