package be.nmine.gtd.presentation.fragment.nextactions.listView

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.FragmentActivity
import be.nmine.gtd.R
import be.nmine.gtd.domain.nextaction.NextAction
import be.nmine.gtd.presentation.fragment.nextactions.viewModel.NextActionViewModel

class NextActionListAdapter(
    private val context: FragmentActivity?,
    private val description: List<String>,
    private val nextActionViewModel: NextActionViewModel
)
    : ArrayAdapter<String>(context!!, R.layout.next_action_list_view_items, description) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context!!.layoutInflater
        val rowView = inflater.inflate(R.layout.next_action_list_view_items, null, true)

        val subtitleText = rowView.findViewById(R.id.description) as TextView
        subtitleText.text = description[position]
        initThreeDotsMenu(rowView, subtitleText, position)
        return rowView
    }

    private fun initThreeDotsMenu(rowView: View?, subtitleText: TextView, position: Int) {
        val three_dots = rowView?.findViewById(R.id.three_dots) as AppCompatImageButton
        three_dots.setOnClickListener { view ->
            val popup = PopupMenu(context, view)
            popup.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_delete -> {
                        val nextActionName = description[position]
                        nextActionViewModel.deleteNextAction(NextAction(nextActionName))
                        Toast.makeText(context,"Next Action : '$nextActionName' deleted", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
            popup.inflate(R.menu.next_action_menu_pop_up_action_list)
            popup.show()
        }

    }
}
