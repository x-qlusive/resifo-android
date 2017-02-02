package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class Meldepflichtiger10 extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_meldepflichtiger)
  }

  def backToDi9(view: View): Unit = {
    val i = new Intent(this, classOf[Unterkunftgeber9])
    startActivity(i)
  }

  def dataSave1(view: View): Unit = {
    val i = new Intent(this, classOf[MainActivity])
    startActivity(i)
  }
}