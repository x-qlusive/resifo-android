package at.fh.swengb.resifo_android

/**
  * Created by Gam0r on 28.01.2017.
  */
import android.content.{ContentValues, Context}
import android.database.Cursor
import android.database.sqlite.{SQLiteDatabase, SQLiteOpenHelper}

import scala.collection.mutable.ListBuffer

object PersonDb {

  val Name = "certificateOFRegistration"
}

/**
  * A simple wrapper around SQLiteOpenHelper to ease SQLite access.
  *
  * Created by lad on 19/01/2017.
  */
case class PersonDb(context: Context) extends SQLiteOpenHelper(context, PersonDb.Name, null, 1) {

  override def onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int): Unit = ()

  override def onCreate(db: SQLiteDatabase): Unit = {

    // perform initial setup

    val personDao = SqlitePersonDao(db)

    personDao.init()

    for (i <- 1 to 5) {
      System.err.println("Person will be created")
      personDao.insert(Person.mkRandom)
    }

  }

  def mkPersonDao(): SqlitePersonDao = {
      SqlitePersonDao(getWritableDatabase)
    }


  trait BaseDao[T] {

    def insert(t: T): Long

    def update(t: T): Int

    // ... and other functions
  }

  def mkContentValues(p: Person): ContentValues = {
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
    cv.put("documentType", p.documentType)
    cv.put("documentAgency", p.documentAgency)
    cv.put("documentNr", p.documentNr)
    cv.put("documentIssueDate", p.documentIssueDate)
    cv.put("newStreet", p.newStreet)
    cv.put("newHouseNr", p.newHouseNr)
    cv.put("newLevel", p.newLevel)
    cv.put("newDoorNr", p.newDoorNr)
    cv.put("newCity", p.newCity)
    cv.put("newPostal", p.newPostal)
    cv.put("mainStreet", p.mainStreet)
    cv.put("mainHouseNr", p.mainHouseNr)
    cv.put("mainLevel", p.mainLevel)
    cv.put("mainDoorNr", p.mainDoorNr)
    cv.put("mainCity", p.mainCity)
    cv.put("mainPostal", p.mainPostal)
    cv.put("oldState", p.oldState)
    cv.put("oldStreet", p.oldStreet)
    cv.put("oldHouseNr", p.oldHouseNr)
    cv.put("oldLevel", p.oldLevel)
    cv.put("oldDoorNr", p.oldDoorNr)
    cv.put("oldCity", p.oldCity)
    cv.put("oldPostal", p.oldPostal)
    cv.put("newState", p.newState)
    cv.put("landlord", p.landlord)
    cv.put("date", p.date)
    cv
  }

  /**
    * Hides details of database table 'Person'
    *
    * @param db
    */
  case class SqlitePersonDao(db: SQLiteDatabase) extends BaseDao[Person] {

    def init(): Unit = {
      db.execSQL("create table person (id INTEGER PRIMARY KEY ASC, firstName TEXT, secondName TEXT, " +
        "unmarriedName TEXT, dateOfBirth TEXT ,sex TEXT, religion TEXT, birthCity TEXT, " +
        "civilStatus TEXT, state TEXT, zmr TEXT, documentType TEXT, documentAgency TEXT," +
        "documentNr TEXT, documentIssueDate TEXT, newStreet TEXT, newHouseNr TEXT, newLevel TEXT, " +
        "newDoorNr TEXT, newCity TEXT, newPostal TEXT, mainStreet TEXT, mainHouseNr TEXT, " +
        "mainLevel TEXT, mainDoorNr TEXT, mainCity TEXT, mainPostal TEXT, oldState TEXT, " +
        "oldStreet TEXT, oldHouseNr TEXT, oldLevel TEXT, oldDoorNr TEXT, oldCity TEXT, " +
        "oldPostal TEXT, newState TEXT, landlord TEXT, date TEXT);")

    System.err.println("DATABASE INITIALISED")
    }


    /**
      * Insert a person to the database.
      *
      * @param p
      */
    def insert(p: Person): Long = {
      val cv: ContentValues = mkContentValues(p)
      db.insert("person", null, cv)
    }

    def delete(firstName: String, secondName: String, dayOfBirth: String): Unit = {
      db.delete("person", "firstName = ? and secondName = ? and dateOfBirth = ?",
        Array(firstName, secondName, dayOfBirth))
    }

    def update(p: Person): Int =
    {
      db.update("person", mkContentValues(p), "firstName = ? and secondName = ? and  " +
        "unmarriedName = ? and dateOfBirth = ? and sex = ? and religion = ? and birthCity = ? " +
        "and civilStatus = ? and state = ? and zmr = ? and documentType = ? and documentAgency = ? " +
        "and documentNr = ? and documentIssueDate = ? and newStreet = ? and newHouseNr = ? and newLevel = ? " +
        "and newDoorNr = ? and newCity = ? and newPostal = ? and mainStreet = ? and mainHouseNr = ? " +
        "and mainLevel = ? and mainDoorNr = ? and mainCity = ? and mainPostal = ? oldState = ? " +
        "and oldStreet = ? and oldHouseNr = ? and oldLevel = ? and oldDoorNr = ? and oldCity = ? " +
        "and oldPostal = ? and newState = ? and landlord = ? and date = ?",
        Array(p.firstName, p.secondName,  p.unmarriedName, p.dateOfBirth,
        p.sex, p.religion, p.birthCity, p.civilStatus, p.state , p.zmr,
          p.documentType, p.documentAgency, p.documentNr, p.documentIssueDate, p.newStreet,
          p.newHouseNr, p.newLevel, p.newDoorNr, p.newCity, p.newPostal,
        p.mainStreet, p.mainHouseNr, p.mainLevel, p.mainDoorNr, p.mainCity, p.mainPostal, p.oldState,
        p.oldStreet, p.oldHouseNr, p.oldLevel, p.oldDoorNr, p.oldCity, p.oldPostal,p.newState, p.landlord, p.date))
    }

    /**
      * Returns a list of persons matching given firstName, or Nil if there is none
      *
      * param firstName the firstName to search for
      * return
      */
    def getAllElements: List[Person] = {
      var someCursor: Option[Cursor] = None
      try {
        someCursor = somePersonCursor()
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
              val unmarriedName = c.getString(c.getColumnIndex("unmarriedName"))
              val dateOfBirth = c.getString(c.getColumnIndex("dateOfBirth"))
              val sex = c.getString(c.getColumnIndex("sex"))
              val religion = c.getString(c.getColumnIndex("religion"))
              val birthCity = c.getString(c.getColumnIndex("birthCity"))
              val civilStatus = c.getString(c.getColumnIndex("civilStatus"))
              val state = c.getString(c.getColumnIndex("state"))
              val zmr = c.getString(c.getColumnIndex("zmr"))
              val documentType = c.getString(c.getColumnIndex("documentType"))
              val documentAgency = c.getString(c.getColumnIndex("documentAgency"))
              val documentNr = c.getString(c.getColumnIndex("documentNr"))
              val documentIssueDate = c.getString(c.getColumnIndex("documentIssueDate"))
              val newStreet = c.getString(c.getColumnIndex("newStreet"))
              val newHouseNr = c.getString(c.getColumnIndex("newHouseNr"))
              val newLevel = c.getString(c.getColumnIndex("newLevel"))
              val newDoorNr = c.getString(c.getColumnIndex("newDoorNr"))
              val newCity = c.getString(c.getColumnIndex("newCity"))
              val newPostal = c.getString(c.getColumnIndex("newPostal"))
              val mainStreet = c.getString(c.getColumnIndex("mainStreet"))
              val mainHouseNr = c.getString(c.getColumnIndex("mainHouseNr"))
              val mainLevel = c.getString(c.getColumnIndex("mainLevel"))
              val mainDoorNr = c.getString(c.getColumnIndex("mainDoorNr"))
              val mainCity = c.getString(c.getColumnIndex("mainCity"))
              val mainPostal = c.getString(c.getColumnIndex("mainPostal"))
              val oldState = c.getString(c.getColumnIndex("oldState"))
              val oldStreet = c.getString(c.getColumnIndex("oldStreet"))
              val oldHouseNr = c.getString(c.getColumnIndex("oldHouseNr"))
              val oldLevel = c.getString(c.getColumnIndex("oldLevel"))
              val oldDoorNr = c.getString(c.getColumnIndex("oldDoorNr"))
              val oldCity = c.getString(c.getColumnIndex("oldCity"))
              val oldPostal = c.getString(c.getColumnIndex("oldPostal"))
              val newState = c.getString(c.getColumnIndex("newState"))
              val landlord = c.getString(c.getColumnIndex("landlord"))
              val date = c.getString(c.getColumnIndex("date"))
              lb.append(Person(firstName, secondName,unmarriedName, dateOfBirth,
                sex, religion, birthCity,
                civilStatus, state, zmr, documentType, documentAgency,
                documentNr, documentIssueDate,
                newStreet, newHouseNr, newLevel,
                newDoorNr, newCity, newPostal, mainStreet, mainHouseNr, mainLevel,
                mainDoorNr,mainCity, mainPostal, oldState, oldStreet, oldHouseNr, oldLevel,
                oldDoorNr, oldCity, oldPostal, newState, landlord, date))
            }
            lb.toList

        }
      } finally {
        someCursor foreach (_.close())
      }

    }

    /**
      * Returns an optional cursor for a firstname query on the person table.
      *
      *
      */


    private def somePersonCursor(): Option[Cursor] = {
      Option(db.query("person", Array("id", "firstName", "secondName", "firstName", "secondName",
        "unmarriedName", "dateOfBirth","sex","religion","birthCity", "civilStatus", "state","zmr",
        "documentType", "documentAgency", "documentNr", "documentIssueDate","newStreet",
        "newHouseNr","newLevel", "newDoorNr", "newCity", "newPostal", "mainStreet","mainHouseNr",
        "mainLevel","mainDoorNr", "mainCity", "mainPostal", "oldState", "oldStreet","oldHouseNr",
        "oldLevel", "oldDoorNr", "oldCity", "oldPostal", "newState", "landlord", "date"),
        null, null, null, null, null))
    }


  }


}