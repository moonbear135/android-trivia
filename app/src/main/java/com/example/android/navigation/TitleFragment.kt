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
        //2-3,9절 4분 54초부분
        //메인페이지에서 버튼을 눌러서 게임페이지로 작동하게 버튼 활성화시키기
       // binding.playButton.setOnClickListener { view: View ->
       //     Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)
       // }

        //2-3,9절 5분 03초부분
        //앞에 작성했던 코드를 Kotlin전용으로 변경 -> 좀더 관용적인 표현
        //android KTX라고 알려져 있는 '제트 팩 프로젝트'의 일부 확장기능
        binding.playButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
        )

       // view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)

        return binding.root
    }

}