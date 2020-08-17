package be.nmine.gtd.presentation.fragment.actions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import be.nmine.gtd.R
import be.nmine.gtd.presentation.fragment.actions.viewModel.ActionViewModel
import be.nmine.gtd.presentation.fragment.actions.listView.ActionListAdapter
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
        val actionNamesLiveData: LiveData<List<String>> = actionViewModel
            .flow
            .asLiveData()
            .map { list: List<ActionDTO?> -> list.map { actionDTO -> actionDTO!!.name } }
        actionNamesLiveData.observe(viewLifecycleOwner, Observer { names: List<String> ->
            recipe_list_view.adapter = ActionListAdapter(activity, names)
        })
    }

}