package at.fh.swengb.resifo_android

/**
  * Created by Gam0r on 28.01.2017.
  */
object Person {

  def mkRandom: Person = Person(Gen.Aword, Gen.Aword,Gen.Aword, Gen.Aword, Gen.Aword,
    Gen.Aword,Gen.Aword, Gen.Aword, Gen.Aword, Gen.Aword,Gen.Aword, Gen.Aword, Gen.Aword,
    Gen.Aword,Gen.Aword, Gen.Aword, Gen.Aword, Gen.Aword,Gen.Aword, Gen.Aword, Gen.Aword,
    Gen.Aword, Gen.Aword, Gen.Aword, Gen.Aword, Gen.Aword,Gen.Aword, Gen.Aword, Gen.Aword,
    Gen.Aword, Gen.Aword, Gen.Aword, Gen.Aword, Gen.Aword, Gen.Aword, Gen.Aword)


}

case class Person(firstName: String, secondName: String,
                  unmarriedName: String, dateOfBirth: String,
                  sex:String, religion: String, birthCity:String,
                  civilStatus:String, state:String, zmr:String,
                  documentType:String, documentAgency:String,
                  documentNr: String, documentIssueDate: String,
                  newStreet: String, newHouseNr:String, newLevel: String,
                  newDoorNr: String, newCity : String, newPostal: String, mainStreet: String,
                  mainHouseNr: String, mainLevel: String, mainDoorNr: String, mainCity: String,
                  mainPostal: String,  oldState:String, oldStreet: String, oldHouseNr: String,
                  oldLevel: String, oldDoorNr: String, oldCity: String, oldPostal: String,
                  newState:String, landlord:String, date:String) {


  override def toString(): String = {
    "Vorname: %s, Nachname: %s, Geburtsdatum: %s, Geschlecht: %s".format(firstName, secondName, dateOfBirth, sex)
  }

}