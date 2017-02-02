package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class AGBBestaetigung extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_agbbestaetigung)
  }

  // called by a button click - see main.xml
  def agbInfo(view: View): Unit = {
    val i = new Intent(this, classOf[AGBInformationen])
    startActivity(i)
  }

  def agbNext(view: View): Unit = {
    val i = new Intent(this, classOf[PersDaten1])
    startActivity(i)
  }
}