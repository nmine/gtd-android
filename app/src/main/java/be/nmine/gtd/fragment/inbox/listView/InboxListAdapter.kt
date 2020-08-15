package be.nmine.gtd.fragment.inbox.listView

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.FragmentActivity
import be.nmine.gtd.R
import be.nmine.gtd.StuffDTO

class InboxListAdapter(private val context: FragmentActivity?, private val description: List<String>)
    : ArrayAdapter<String>(context!!, R.layout.inbox_list_view_items, description) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context!!.layoutInflater
        val rowView = inflater.inflate(R.layout.inbox_list_view_items, null, true)

        val subtitleText = rowView.findViewById(R.id.description) as TextView
        initThreeDotsMenu(rowView, subtitleText, position)

        return rowView
    }

    private fun initThreeDotsMenu(
        rowView: View,
        subtitleText: TextView,
        position: Int
    ) {
        val three_dots = rowView.findViewById(R.id.three_dots) as AppCompatImageButton

        subtitleText.text = description[position]
        three_dots.setOnClickListener {
            val popup = PopupMenu(context, it)
            popup.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu__to_agenda -> {
                        true
                    }
                    else -> false
                }
            }
            popup.inflate(R.menu.inbox_menu_pop_up_action_list)
            popup.show()
        }
    }
}
