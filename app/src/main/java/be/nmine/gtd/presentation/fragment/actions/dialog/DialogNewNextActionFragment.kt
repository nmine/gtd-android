package be.nmine.gtd.presentation.fragment.actions.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import be.nmine.gtd.R
import be.nmine.gtd.domain.action.Action
import be.nmine.gtd.presentation.fragment.actions.viewModel.ActionViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.dialog_next_action.*

@AndroidEntryPoint
class DialogNewNextActionFragment : DialogFragment() {

    private val actionViewModel: ActionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.dialog_next_action, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val get:String = arguments?.get("title") as String
        dialog_text_action_item.text = get
        dialog_button_create_next_action.setOnClickListener {
            val nextActionName = dialog_edit_text_next_action.text.toString()
            actionViewModel.moveToNextAction(Action(nextActionName))
            dialog?.dismiss()
            Toast.makeText(activity,"Next Action : '$nextActionName' created",Toast.LENGTH_SHORT).show()
        }
    }

}