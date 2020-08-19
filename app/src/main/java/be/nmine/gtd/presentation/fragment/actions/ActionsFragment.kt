package be.nmine.gtd.presentation.fragment.actions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import be.nmine.gtd.R
import be.nmine.gtd.presentation.fragment.actions.listView.ActionListAdapter
import be.nmine.gtd.presentation.fragment.actions.viewModel.ActionViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.inbox_fragment_list_view.*

@AndroidEntryPoint
class ActionsFragment : Fragment() {

    private val actionViewModel: ActionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.inbox_fragment_list_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        actionViewModel.actionNamesLiveData.observe(viewLifecycleOwner, Observer { names: List<String> ->
            recipe_list_view.adapter = ActionListAdapter(activity, names)
        })
    }

}