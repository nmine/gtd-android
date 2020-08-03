package be.nmine.gtd.fragment.listview

import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.FragmentActivity
import be.nmine.gtd.R
import kotlinx.android.synthetic.main.custom_list.*

class MyListAdapter(private val context: FragmentActivity?, private val title: Array<String>, private val description: Array<String>)
    : ArrayAdapter<String>(context!!, R.layout.custom_list, title) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context!!.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list, null, true)

        val subtitleText = rowView.findViewById(R.id.description) as TextView
        val three_dots = rowView.findViewById(R.id.three_dots) as AppCompatImageButton

        subtitleText.text = description[position]
        three_dots.setOnClickListener{
            val popup = PopupMenu(context,it)
            popup.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.menu__to_agenda -> {
                        true
                    }
                    else -> false
                }
            }
            popup.inflate(R.menu.menu_stuff)
            popup.show()
        }

        return rowView
    }
}
