package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class ZMRZahl3 extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_zmrzahl)
  }


  def backToDi2(view: View): Unit = {
    val i = new Intent(this, classOf[PersDaten2])
    startActivity(i)
  }

  def dataInput4(view: View): Unit = {
    val i = new Intent(this, classOf[Reisedokument4])
    startActivity(i)
  }
}