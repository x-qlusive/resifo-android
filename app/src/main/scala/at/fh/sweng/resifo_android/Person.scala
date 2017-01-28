package at.fh.sweng.resifo_android

/**
  * Created by Gam0r on 28.01.2017.
  */
object Person {

  def mkRandom: Person = Person(Gen.Aword, Gen.Aword)

}

case class Person(firstName: String, secondName: String)