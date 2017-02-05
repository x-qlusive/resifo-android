package at.fh.swengb.resifo_android

/**
  * Created by Gam0r on 28.01.2017.
  */
import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.{ArrayAdapter, ListView, SimpleCursorAdapter}

import scala.collection.JavaConversions._




class PersonListActivity extends ListActivity {

  var aDb: PersonDb = _

  var myListView:ListView = _

  var listPerson: List[Person] = _

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)

    aDb = PersonDb(getApplicationContext)

    /*myListView = findViewById(R.id.myPersonList).asInstanceOf[ListView]

    val myAdapter:CustomAdapter = new CustomAdapter(this, aDb.mkPersonDao().getAllElements)

    myListView.setAdapter(myAdapter)

    myListView.setOnItemClickListener(this)*/

    val pA = new ArrayAdapter[Person](this, R.layout.activity_person_list,R.id.PersonInformation,
      aDb.mkPersonDao().getAllElements)

    setListAdapter(pA)

  }

  override def onListItemClick(l: ListView, v: View, pos: Int, i: Long) {
    aDb = PersonDb(getApplicationContext)
    listPerson = aDb.mkPersonDao().getAllElements
    val selectedPerson: Person = listPerson.get(i.toInt)
    val intent: Intent = new Intent(v.getContext, classOf[PersonActivity])
    val bundle:Bundle = new Bundle()
    bundle.putSerializable("person", selectedPerson)
    intent.putExtras(bundle)//
    startActivity(intent)
  }

}