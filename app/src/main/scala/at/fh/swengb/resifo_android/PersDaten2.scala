package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class PersDaten2 extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_persdaten2)
  }

  def backToDi1(view: View): Unit = {
    val i = new Intent(this, classOf[PersDaten1])
    startActivity(i)
  }

  def dataInput3(view: View): Unit = {
    val i = new Intent(this, classOf[ZMRZahl3])
    startActivity(i)
  }
}