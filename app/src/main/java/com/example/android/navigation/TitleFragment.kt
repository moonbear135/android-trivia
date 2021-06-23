package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentTitleBinding


/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding: FragmentTitleBinding = DataBindingUtil.inflate(
           inflater, R.layout.fragment_title,container,false)
        binding.playButton.setOnClickListener { view: View->
            Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)
            //2-3장 9절 kotlin용으로 코드를 바꾸는 방법 KTX를 이용 안드로이드 뷰 클래스 확장 기능
        }
        return binding.root
    }

}