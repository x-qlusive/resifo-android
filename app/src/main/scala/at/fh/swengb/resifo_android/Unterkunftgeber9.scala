package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class Unterkunftgeber9 extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_unterkunftgeber)
  }

  def backToDi8(view: View): Unit = {
    val i = new Intent(this, classOf[AbmeldungUnterkunft8])
    startActivity(i)
  }

  def dataInput10(view: View): Unit = {
    val i = new Intent(this, classOf[Meldepflichtiger10])
    startActivity(i)
  }
}