package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class AbmeldungUnterkunft8 extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_abmeldungunterkunft)
  }

  def backToDi7(view: View): Unit = {
    val i = new Intent(this, classOf[ZuzugAusland7])
    startActivity(i)
  }

  def dataInput9(view: View): Unit = {
    val i = new Intent(this, classOf[Unterkunftgeber9])
    startActivity(i)
  }
}