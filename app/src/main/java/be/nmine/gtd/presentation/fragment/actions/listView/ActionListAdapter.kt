package be.nmine.gtd.presentation.fragment.actions.listView

import android.content.ContentValues.TAG
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.FragmentActivity
import be.nmine.gtd.R
import be.nmine.gtd.domain.action.Action
import be.nmine.gtd.presentation.fragment.actions.dialog.DialogNewNextActionFragment
import be.nmine.gtd.presentation.fragment.actions.viewModel.ActionViewModel

class ActionListAdapter(
    private val context: FragmentActivity?,
    private val description: List<String>,
    private val actionViewModel: ActionViewModel
)
    : ArrayAdapter<String>(context!!, R.layout.action_list_view_items, description) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context!!.layoutInflater
        val rowView = inflater.inflate(R.layout.action_list_view_items, null, true)

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
        three_dots.setOnClickListener { view ->
            val popup = PopupMenu(context, view)
            popup.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_delete -> {
                        actionViewModel.deleteAction(Action(description[position]))
                        true
                    }
                    R.id.menu_move_to_next_action -> {
                        if (context != null) {
                            val dialogNewNextActionFragment = DialogNewNextActionFragment()
                            val bundle = Bundle()
                            bundle.putString("currentAction", description[position] )
                            dialogNewNextActionFragment.arguments = bundle
                            dialogNewNextActionFragment.show(context.supportFragmentManager, TAG)
                        }
                        true
                    }
                    else -> false
                }
            }
            popup.inflate(R.menu.action_menu_pop_up_action_list)
            popup.show()
        }
    }
}
