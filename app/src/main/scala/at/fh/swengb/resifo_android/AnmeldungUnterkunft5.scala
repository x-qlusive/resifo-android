package at.fh.swengb.resifo_android

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.provider.Contacts.Intents
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{Button, RadioButton}

class AnmeldungUnterkunft5 extends AppCompatActivity {
  var person:Person = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_data_anmeldungunterkunft)
    val intent:Intent = this.getIntent()
    val bundle:Bundle = intent.getExtras()
    person = bundle.getSerializable("person").asInstanceOf[Person]
  }

  def backToDi4(view: View): Unit = {
    val i = new Intent(this, classOf[Reisedokument4])
    startActivity(i)
  }

  def dataInput6(view: View): Unit = {
    val strasse = findViewById(R.id.anmeldungStrasse).toString
    val stiege = findViewById(R.id.anmeldungStiege).toString
    val ort = findViewById(R.id.anmeldungOrt).toString
    val plz = findViewById(R.id.anmeldungPlz).toString
    val tuer = findViewById(R.id.anmeldungTuer).toString
    val nr = findViewById(R.id.anmeldungHausnr).toString

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

    val Nein: RadioButton = findViewById(R.id.hauptNein).asInstanceOf[RadioButton]
    val Ja: RadioButton = findViewById(R.id.hauptJa).asInstanceOf[RadioButton]

    if (Ja.isChecked()) {
      val jaIntent = new Intent(this, classOf[ZuzugAusland7])
      person = person.copy(newStreet = strasse, newDoorNr = tuer, newHouseNr = nr,
        newLevel = stiege, newCity = ort, newPostal = plz)
      val bundle: Bundle = new Bundle()
      bundle.putSerializable("person", person)
      jaIntent.putExtras(bundle)
      startActivity(jaIntent)
    }
    else if (Nein.isChecked()) {
      val neinIntent = new Intent(this, classOf[HauptwohnsitzNein6])
      person = person.copy(newStreet = strasse, newDoorNr = tuer, newHouseNr = nr,
        newLevel = stiege, newCity = ort, newPostal = plz)
      val bundle: Bundle = new Bundle()
      bundle.putSerializable("person", person)
      neinIntent.putExtras(bundle)
      startActivity(neinIntent)
    }

    if (!Ja.isChecked() && !Nein.isChecked() && (cond1 | cond2 | cond3 | cond4 | cond5 | cond6 | cond7 |
      cond8 | cond9 | cond10 | cond11 | cond12)) {
      val alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setTitle("ACHTUNG");
      alertDialog.setMessage("Bitte füllen Sie alle Felder aus");
      alertDialog.show();
    }

    }


}