package at.fh.swengb.resifo_android

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class HauptwohnsitzNein6 extends AppCompatActivity {
  var person: Person = _

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_hauptwohnsitznein)
    val intent: Intent = this.getIntent()
    val bundle: Bundle = intent.getExtras()
    person = bundle.getSerializable("person").asInstanceOf[Person]
  }

  def backToDi5(view: View): Unit = {
    val i = new Intent(this, classOf[AnmeldungUnterkunft5])
    startActivity(i)
  }

  def dataInput7(view: View): Unit = {
    val strasse = findViewById(R.id.hwbleibtStrasse).toString
    val stiege = findViewById(R.id.hwbleibtStiege).toString
    val ort = findViewById(R.id.hwbleibtOrt).toString
    val plz = findViewById(R.id.hwbleibtPlz).toString
    val tuer = findViewById(R.id.hwbleibtTuer).toString
    val nr = findViewById(R.id.hwbleibtHausnr).toString

    val cond1: Boolean = strasse == null
    val cond2: Boolean = strasse.equals("")
    val cond3: Boolean = stiege == null
    val cond4: Boolean = stiege.equals("")
    val cond5: Boolean = ort == null
    val cond6: Boolean = ort.equals("")
    val cond7: Boolean = plz == null
    val cond8: Boolean = plz.equals("")
    val cond9: Boolean = tuer == null
    val cond10: Boolean = tuer.equals("")
    val cond11: Boolean = nr == null
    val cond12: Boolean = nr.equals("")

    if (cond1 | cond2 | cond3 | cond4 | cond5 | cond6 | cond7 |
      cond8 | cond9 | cond10 | cond11 | cond12) {
      val alertDialog = new AlertDialog.Builder(this).create()
      alertDialog.setTitle("ACHTUNG")
      alertDialog.setMessage("Bitte füllen Sie alle Felder aus")
      alertDialog.show()
    } else {
      val jaIntent = new Intent(this, classOf[ZuzugAusland7])
      person = person.copy(mainStreet = strasse, mainDoorNr = tuer, mainHouseNr = nr,
        mainLevel = stiege, mainCity = ort, mainPostal = plz)
      val bundle: Bundle = new Bundle()
      bundle.putSerializable("person", person)
      jaIntent.putExtras(bundle)
      startActivity(jaIntent)
    }
  }
}