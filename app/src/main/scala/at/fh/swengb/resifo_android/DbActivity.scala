package at.fh.swengb.resifo_android

/**
  * Created by Gam0r on 28.01.2017.
  */
import android.app.Activity
import android.content.{ContentValues, Context, Intent}
import android.database.Cursor
import android.database.sqlite.{SQLiteDatabase, SQLiteOpenHelper}
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText

import scala.collection.JavaConversions._
import scala.util.Random


/**
  * Shows how to lookup user Interface elements via findViewById, and more importantly
  * an example how to use SQLiteOpenHelper class
  */
class DbActivity extends Activity {

  var aDb: SimpleDb = _

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.first)
    aDb = SimpleDb(getApplicationContext)
  }




  def saveToDb(view: View): Unit = {
    val firstName: String = findViewById(R.id.firstName).asInstanceOf[EditText].getText.toString
    val secondName: String = findViewById(R.id.secondName).asInstanceOf[EditText].getText.toString

    // I WANT TO WRITE TO THE DATABASE
    val unmarriedName: String = ???
    val dateOfBirth: String = ???
    val sex:String = ???
    val religion: String = ???
    val birthCity: String = ???
    val civilStatus: String = ???
    val state: String = ???
    val zmr: String = ???
    val documentNr: String = ???
    val documentIssueDate: String = ???
    val newStreet: String = ???
    val newHouseNr: String = ???
    val newLevel: String = ???
    val newDoorNr: String = ???
    val mainStreet: String = ???
    val mainHouseNr: String = ???
    val mainLevel: String = ???
    val mainDoorNr: String = ???
    val oldState: String = ???
    val oldStreet: String = ???
    val oldHouseNr: String = ???
    val oldLevel: String = ???
    val oldDoorNr: String = ???
    val newState: String = ???
    val landlord: String = ???

    //Daten aus den Views müssen hier eingetragen werden
    /*val person:Person = Person(firstName, secondName, unmarriedName, dateOfBirth,
      sex, religion, birthCity, civilStatus, state , zmr,documentNr,
      documentIssueDate, newStreet, newHouseNr, newLevel, newDoorNr,
      mainStreet, mainHouseNr, mainLevel, mainDoorNr, oldState,
      oldStreet, oldHouseNr, oldLevel, oldDoorNr, newState, landlord)
    val personDao = aDb.mkPersonDao()
    personDao.insert(person)*/
  }

  def loadFromDb(view: View): Unit = {
    val i = new Intent(this, classOf[MyListActivity])
    startActivity(i)

  }
}