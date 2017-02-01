package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class ZuzugAusland7 extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_zuzugausland)
  }

  def backToDi6(view: View): Unit = {
    val i = new Intent(this, classOf[HauptwohnsitzNein6])
    startActivity(i)
  }

  def dataInput8(view: View): Unit = {
    val i = new Intent(this, classOf[AbmeldungUnterkunft8])
    startActivity(i)
  }
}