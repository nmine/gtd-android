package be.nmine.gtd.presentation.fragment.nextactions.viewModel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import be.nmine.gtd.R
import be.nmine.gtd.presentation.fragment.nextactions.viewModel.listView.NextActionListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.inbox_fragment_list_view.*

@AndroidEntryPoint
class NextActionsFragment : Fragment() {

    private val nextActionViewModel: NextActionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.inbox_fragment_list_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        nextActionViewModel.nextActionNamesLiveData.observe(viewLifecycleOwner, Observer { names: List<String> ->
            recipe_list_view.adapter = NextActionListAdapter(activity, names,nextActionViewModel)
        })
    }

}