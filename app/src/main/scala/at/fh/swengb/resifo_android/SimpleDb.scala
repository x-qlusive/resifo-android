package at.fh.swengb.resifo_android

/**
  * Created by Gam0r on 28.01.2017.
  */
import android.content.{ContentValues, Context, CursorLoader}
import android.database.Cursor
import android.database.sqlite.{SQLiteDatabase, SQLiteOpenHelper}

import scala.collection.mutable.ListBuffer

object SimpleDb {

  val Name = "certificateOFRegistration"
}

/**
  * A simple wrapper around SQLiteOpenHelper to ease SQLite access.
  *
  * Created by lad on 19/01/2017.
  */
case class SimpleDb(context: Context) extends SQLiteOpenHelper(context, SimpleDb.Name, null, 1) {

  override def onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int): Unit = ()

  override def onCreate(db: SQLiteDatabase): Unit = {

    // perform initial setup
    /*
    val personDao = SqlitePersonDao(db)

    personDao.init()

    for (i <- 1 to 100) personDao.insert(Person.mkRandom)

  }
*/}
  def mkPersonDao(): SqlitePersonDao = {
      SqlitePersonDao(getWritableDatabase)
    }


  trait BaseDao[T] {

    def insert(t: T): Long

    def update(t: T): Int

    // ... and other functions
  }

 /* def mkContentValues(p: Person): ContentValues = {
    val cv = new ContentValues
    cv.put("firstName", p.firstName)
    cv.put("secondName", p.secondName)
    cv.put("unmarriedName", p.unmarriedName)
    cv.put("dateOfBirth", p.dateOfBirth)
    cv.put("sex", p.sex)
    cv.put("religion", p.religion)
    cv.put("birthCity", p.birthCity)
    cv.put("civilStatus", p.civilStatus)
    cv.put("state", p.state)
    cv.put("zmr", p.zmr)
    cv.put("documentNr", p.documentNr)
    cv.put("documentIssueDate", p.documentIssueDate)
    cv.put("newStreet", p.newStreet)
    cv.put("newHouseNr", p.newHouseNr)
    cv.put("newLevel", p.newLevel)
    cv.put("newDoorNr", p.newDoorNr)
    cv.put("mainStreet", p.mainStreet)
    cv.put("mainHouseNr", p.mainHouseNr)
    cv.put("mainLevel", p.mainLevel)
    cv.put("mainDoorNr", p.mainDoorNr)
    cv.put("oldState", p.oldState)
    cv.put("oldStreet", p.oldStreet)
    cv.put("oldHouseNr", p.oldHouseNr)
    cv.put("oldLevel", p.oldLevel)
    cv.put("oldDoorNr", p.oldDoorNr)
    cv.put("newState", p.newState)
    cv.put("landlord", p.landlord)
    cv
  }
*/
  /**
    * Hides details of database table 'Person'
    *
    * @param db
    */
  case class SqlitePersonDao(db: SQLiteDatabase) extends BaseDao[Person] {

    def init(): Unit = db.execSQL("create table person (id INTEGER PRIMARY KEY ASC, firstName TEXT, secondName TEXT, unmarriedName TEXT, dateOfBirth TEXT ," +
      "sex TEXT, religion TEXT, birthCity TEXT, civilStatus TEXT, state TEXT, zmr TEXT, documentNr TEXT, documentIssueDate TEXT, " +
      "newStreet TEXT, newHouseNr TEXT, newLevel TEXT, newDoorNr TEXT, mainStreet TEXT, mainHouseNr TEXT, mainLevel TEXT, mainDoorNr TEXT, " +
      "oldState TEXT, oldStreet TEXT, oldHouseNr TEXT, oldLevel TEXT, oldDoorNr String, newState TEXT, landlord TEXT);")

    /**
      * Insert a person to the database.
      *
      * @param p
      */
    def insert(p: Person): Long = ??? /*{
      val cv: ContentValues = mkContentValues(p)
      db.insert("person", null, cv)
    }
*/
    def deleteByFirstName(firstName: String): Unit = {
      db.delete("person", "firstName = ?", Array(firstName))
    }

    def update(p: Person): Int = ??? /*
    {
      db.update("person", mkContentValues(p), "firstName = ? and secondName = ? and  " +
        "unmarriedName = ? and dateOfBirth = ? and sex = ? and religion = ? and birthCity = ? " +
        "and civilStatus = ? and state = ? and zmr = ? and documentNr = ? and documentIssueDate = ? " +
        "and newStreet = ? and newHouseNr = ? and newLevel = ? and newDoorNr = ? and mainStreet = ? and " +
        "mainHouseNr = ? and mainLevel = ? and mainDoorNr = ? and oldState = ? and oldStreet = ? and " +
        "oldHouseNr = ? and oldLevel = ? and oldDoorNr = ? and newState = ? and landlord = ?",
        Array(p.firstName, p.secondName,  p.unmarriedName, p.dateOfBirth,
        p.sex, p.religion, p.birthCity, p.civilStatus, p.state , p.zmr, p.documentNr,
        p.documentIssueDate, p.newStreet, p.newHouseNr, p.newLevel, p.newDoorNr,
        p.mainStreet, p.mainHouseNr, p.mainLevel, p.mainDoorNr, p.oldState,
        p.oldStreet, p.oldHouseNr, p.oldLevel, p.oldDoorNr, p.newState, p.landlord))
    }
*/
    /**
      * Returns a list of persons matching given firstName, or Nil if there is none
      *
      * param firstName the firstName to search for
      * return
      *//*
    def findByFirstName(firstName: String): List[Person] = {
      var someCursor: Option[Cursor] = None
      try {
        someCursor = someCursorForFirstnameQuery(firstName)
        someCursor match {
          case None =>
            System.err.println("Could not execute query due to some reason")
            Nil
          case Some(c) =>
            val lb = new ListBuffer[Person]()
            while (c.moveToNext()) {
              val id = c.getInt(c.getColumnIndex("id"))
              val firstName = c.getString(c.getColumnIndex("firstName"))
              val secondName = c.getString(c.getColumnIndex("secondName"))
              lb.append(Person(firstName, secondName))
            }
            lb.toList
        }
      } finally {
        someCursor foreach (_.close())
      }

    }*/

    /**
      * Returns an optional cursor for a firstname query on the person table.
      *
      * @param firstName
      * @return
      */
    private def someCursorForFirstnameQuery(firstName: String): Option[Cursor] = {
      Option(db.query("person", Array("id", "firstName", "secondName"), "firstName = ?", Array(firstName), null, null, null))
    }

    private def somePersonCursor(): Option[Cursor] = {
      Option(db.query("person", Array("id", "firstName", "secondName"), null, null, null, null, null))
    }


  }


}