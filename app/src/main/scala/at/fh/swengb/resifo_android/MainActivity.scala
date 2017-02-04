package at.fh.swengb.resifo_android

/**
  * Created by Gam0r on 28.01.2017.
  */

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter


/**
  * Entry point of the appliation.
  *
  * Shows how to use Intents to change between Activities
  */
class MainActivity extends Activity {
  //var lala:SimpleDb = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main)

    /*lala = SimpleDb(getApplicationContext)
    lala.mkPersonDao().insert(Person ....)
    So können Personen hinzugefügt werden*/



  }


  // called by a button click - see main.xml
  def newEntry(view: View): Unit = {
    val i = new Intent(this, classOf[AGBBestaetigung])
    startActivity(i)
  }

  def eintragAnzeigen(view: View): Unit = {
    val i = new Intent(this, classOf[MyListActivity])
    startActivity(i)
  }
}