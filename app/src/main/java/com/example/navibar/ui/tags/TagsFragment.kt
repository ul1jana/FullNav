package com.example.navibar.ui.tags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navibar.databinding.FragmentTagsBinding

class TagsFragment : Fragment() {

    private var _binding: FragmentTagsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val tagsViewModel =
            ViewModelProvider(this).get(TagsViewModel::class.java)

        _binding = FragmentTagsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTags
        tagsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}