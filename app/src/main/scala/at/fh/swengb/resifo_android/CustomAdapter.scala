package at.fh.swengb.resifo_android

/**
  * Created by niki on 05.02.2017.
  */

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import scala.collection.JavaConversions._
import java.util.List


class CustomAdapter(var context: Context, var listPerson: List[Person]) extends android.widget.BaseAdapter {
  var inflter: LayoutInflater = null
  inflter = (LayoutInflater.from(context))


  def getCount: Int = {
    return listPerson.size
  }

  def getItemId(i: Int): Long = {
    return i
  }

  def getView(i: Int, view: View, viewGroup: ViewGroup): View = {
    var viewVar:View = view
    if (view == null) {
      viewVar = inflter.inflate(R.layout.activity_list_eintrag, null)
    }
    val viewName: TextView = viewVar.findViewById(R.id.textViewListName).asInstanceOf[TextView]
    val viewAddress: TextView = viewVar.findViewById(R.id.textViewListAddress).asInstanceOf[TextView]
    val viewPhone: TextView = viewVar.findViewById(R.id.textViewListPhone).asInstanceOf[TextView]

    val person: Person = listPerson.get(i)
    viewName.setText(person.firstName + " " + person.secondName)
    viewAddress.setText(person.dateOfBirth)
    viewPhone.setText(person.sex)
    return view
  }

  override def getItem(position: Int): AnyRef =
    return listPerson.get(position)
}

