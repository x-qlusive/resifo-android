package at.fh.swengb.resifo_android

/**
  * Created by Gam0r on 28.01.2017.
  */
/*object Person {

  def mkRandom: Person = Person(Gen.Aword, Gen.Aword)

}*/

case class Person(firstName: String, secondName: String,
                  unmarrriedName: String, dateOfBirth: String,
                  sex:Int, religion: String, birthCity:String,
                  civilStatus:String, state:String, zmr:Int,
                  documentNr: Int, documentIssueDate: String,
                  newStreet: String, newHouseNr: String, newLevel: Int,
                  newDoorNr: Int, mainStreet: String, mainHouseNr: String, mainLevel: Int,
                  mainDoorNr: Int, oldState:String, oldStreet: String, oldHouseNr: String, oldLevel: Int,
                  oldDoorNr: Int, newState:String, landlord:String)