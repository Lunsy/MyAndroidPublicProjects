package com.example.mykotlinlearning

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.mykotlinlearning.databinding.ActivityMainBinding
import com.example.mykotlinlearning.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {

    private var _binding: FragmentBlankBinding?  = null
    private val binding: FragmentBlankBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBlankBinding.inflate(inflater, container,
            false)
        //val view: FrameLayout = binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textFragment.text = "Done it"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}

/*
 private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        val view : ConstraintLayout = binding.root
        setContentView(view)

        binding.helloTextView.text = "Bye"
    }
*/