package at.fh.swengb.resifo_android

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView


class PersonActivity extends AppCompatActivity {
  var person: Person = null
  var aDb:PersonDb =_
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_show_person)
    val intent: Intent = getIntent
    person = intent.getExtras.get("person").asInstanceOf[Person]
    val viewFirstName: TextView = findViewById(R.id.textViewFirstName).asInstanceOf[TextView]
    val viewLastName: TextView = findViewById(R.id.textViewLastName).asInstanceOf[TextView]
    val viewAddress: TextView = findViewById(R.id.textViewAddress).asInstanceOf[TextView]
    val viewPhone: TextView = findViewById(R.id.textViewPhone).asInstanceOf[TextView]
    viewFirstName.setText(person.firstName)
    viewLastName.setText(person.secondName)
    viewAddress.setText(person.dateOfBirth)
    viewPhone.setText(person.sex)
  }

  def editPerson(view: View): Unit = {
    val mapIntent: Intent = new Intent(this, classOf[PersDaten1])
    val bundle:Bundle = new Bundle()
    aDb = PersonDb(getApplicationContext)
    aDb.mkPersonDao().delete(person.firstName, person.secondName, person.dateOfBirth)
    bundle.putSerializable("person", person)
    mapIntent.putExtras(bundle)
    startActivity(mapIntent)
  }

  def deletePerson(view: View): Unit = {
    aDb = PersonDb(getApplicationContext)
    aDb.mkPersonDao().delete(person.firstName, person.secondName, person.dateOfBirth)
    val intent:Intent = new Intent(this, classOf[PersonListActivity])
    startActivity(intent)
  }

}