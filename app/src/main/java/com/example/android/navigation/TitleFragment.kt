package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
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
      //  binding.playButton.setOnClickListener(
      //      Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
        //)

        binding.playButton.setOnClickListener { v : View ->
            v.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }


       // view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)

       //2-3,17절 menu overflow_ment.xml에서 만든 것을 연결해 줄것입니다.
        setHasOptionsMenu(true)

        return binding.root
    }
    //2-3,17절 onCreateOptionMenu를 추가한 것입니다.
    //동영상 강의 2분 22초 쯤에 해당합니다.
    //inflater?.inflate(R.menu.overflow_menu, menu) 부분에서
    // overflow_menu 뒤에 ' , ' / ' . ' 두가지를 잘 구분해야합니다.
    // ' . '을 사용 했을 때 에러가 발생합니다.

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)

    }
    //동영상 강의 2분 53초 부분입니다.
    //NavigationUI을 쓰기 위해서 설정을 해줍니다.
    //동영상 강의 맨마지막 부분에서 menuFargment의 경우는
    //별도의 연결이 없어도 기능을 이용하여 바로 보여주는 것을 하기 때문에
    //연결을 할 필요가 없다고 합니다.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
        super.onOptionsItemSelected(item)
    }
}