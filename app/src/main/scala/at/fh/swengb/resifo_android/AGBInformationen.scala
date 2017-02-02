package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class AGBInformationen extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_agbinformationen)
  }

  def infoNext(view: View): Unit = {
    val i = new Intent(this, classOf[AGBBestaetigung])
    startActivity(i)
  }
}