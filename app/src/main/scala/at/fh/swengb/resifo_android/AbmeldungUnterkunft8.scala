package at.fh.swengb.resifo_android

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioButton

class AbmeldungUnterkunft8 extends AppCompatActivity {
  var person:Person = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_abmeldungunterkunft)
    val intent:Intent = this.getIntent()
    val bundle:Bundle = intent.getExtras()
    person = bundle.getSerializable("person").asInstanceOf[Person]
  }

  def backToDi7(view: View): Unit = {
    val i = new Intent(this, classOf[ZuzugAusland7])
    startActivity(i)
  }

  def dataInput9(view: View): Unit = {
    val strasse = findViewById(R.id.abmeldungStrasse).toString
    val stiege = findViewById(R.id.abmeldungStiege).toString
    val ort = findViewById(R.id.abmeldungOrt).toString
    val plz = findViewById(R.id.abmeldungPlz).toString
    val tuer = findViewById(R.id.abmeldungTuer).toString
    val nr = findViewById(R.id.abmeldungHausnr).toString

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

    val abmeldungJa: RadioButton = findViewById(R.id.abmeldungJa).asInstanceOf[RadioButton]
    val abmeldungNein: RadioButton = findViewById(R.id.abmeldungNein).asInstanceOf[RadioButton]
    val staat: String = findViewById(R.id.abmeldungStaat).toString

    if (abmeldungJa.isChecked()) {
      val mIntent = new Intent(this, classOf[Unterkunftgeber9]) // <----- START "Unterkunftgeber" ACTIVITY
      person = person.copy(oldStreet = strasse, oldDoorNr = tuer, oldHouseNr = nr,
        oldLevel = stiege, oldCity = ort, oldPostal = plz)
      val bundle: Bundle = new Bundle()
      bundle.putSerializable("person", person)
      mIntent.putExtras(bundle)
      startActivity(mIntent)
    }

    else if (abmeldungNein.isChecked()) {
      val cond1: Boolean = staat == null
      val cond2: Boolean = staat.equals("")

      if (cond1 | cond2) {
        val alertDialog = new AlertDialog.Builder(this).create()
        alertDialog.setTitle("ACHTUNG")
        alertDialog.setMessage("Bitte den Staat angeben, in den Sie verziehen")
        alertDialog.show()
      } else {
        val wIntent = new Intent(this, classOf[Unterkunftgeber9]); // <----- START "Unterkunftgeber" ACTIVITY
        person = person.copy(oldStreet = strasse, oldDoorNr = tuer, oldHouseNr = nr,
          oldLevel = stiege, oldCity = ort, oldPostal = plz, newState = staat)
        val bundle: Bundle = new Bundle()
        bundle.putSerializable("person", person)
        wIntent.putExtras(bundle)
        startActivity(wIntent)
      }
    }

    if (!abmeldungJa.isChecked() && !abmeldungNein.isChecked()&& (cond1 | cond2 | cond3 | cond4 | cond5 | cond6 | cond7 |
      cond8 | cond9 | cond10 | cond11 | cond12)) {
      val alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setTitle("ACHTUNG");
      alertDialog.setMessage("Bitte Füllen Sie alle Felder aus");
      alertDialog.show();
    }
  }
}