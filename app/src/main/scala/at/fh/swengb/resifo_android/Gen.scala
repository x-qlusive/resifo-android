package at.fh.swengb.resifo_android

/**
  * Created by Gam0r on 28.01.2017.
  */
import scala.util.Random


object Gen {

  val lower = 'a' to 'z'
  val upper = 'A' to 'Z'

  def aLower: Char = lower(Random.nextInt(lower.length))

  def aUpper: Char = upper(Random.nextInt(upper.length))

  def aword: String = List.fill(Random.nextInt(15))(aLower).mkString("")

  def Aword: String = aUpper + aword

}