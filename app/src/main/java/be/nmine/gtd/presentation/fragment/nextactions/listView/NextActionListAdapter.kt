package be.nmine.gtd.presentation.fragment.nextactions.listView

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import be.nmine.gtd.R
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
        return rowView
    }
}
