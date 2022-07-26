package com.example.a3_fragmentlivedatalifecycleowner

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a3_fragmentlivedatalifecycleowner.databinding.FragmentBlank1Binding
import com.example.a3_fragmentlivedatalifecycleowner.databinding.FragmentBlank2Binding


class BlankFragment2 : Fragment() {

    private val TAG = "BlankFragment2"

    private var _binding : FragmentBlank2Binding? = null
    private val binding get() =_binding!!

    private val viewModel : BlankViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBlank2Binding.inflate(inflater, container, false)
        val view = binding.root

//        viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.text1.text = viewModel.liveCount.value.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestoryView")
    }
    //사라질 때 마다 이게 실행됨.


    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
    //하지만 이 부분은 실행이 되지 않음.
    //뒤로가기를 누르면 이 부분까지 실행이 됨.
}