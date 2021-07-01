/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_won, container, false)
        binding.nextMatchButton.setOnClickListener{view: View->
            //view.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
            view.findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }
        setHasOptionsMenu(true)

        //val args = GameWonFragmentArgs.fromBundle(requireArguments())

//        Toast.makeText(context, "NumCorrect: ${args.numCurrect}," +
//                "NumQuestions: ${args.numQuestions}",
//            Toast.LENGTH_LONG).show()

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.winner_menu, menu)
        // 동영상 강의 5분 02초, 2차 어플 실행까지 완료 되었습니다.
        //check if the activity resolves
        // 동영상 강의 5분 02초에 5. 업데이트 내용이 없습니다.
        // 5. 업데이트 내용을 참고하여 코드를 수정합니다.
//        if (null == getShareIntent().resolveActivity(activity!!.packageManger)){
          if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {

            //hide the menu if th doesn't resolve
            menu.findItem(R.id.share)?.setVisible(false)
        }

    }
    // Creating our Share Intent
    private fun getShareIntent() : Intent {
        //val args = GameWonFragmentArgs.fromBundle(arguments)
        //2. 업데이트 노트로 최신화합니다. 동영상강의 1분 26초
        val args = GameWonFragmentArgs.fromBundle(requireArguments())

        // 동영상 강의 3분 53초 부분입니다.
        // 3분 30초 부분의 코드 실행까지는 문제없이 공유 아이콘이 활성화 되었습니다.
//        val shareIntent = Intent(Intent.ACTION_SEND)
//        shareIntent.setType("text/plain")
//            .putExtra(Intent.EXTRA_TEXT,
//                  getString(R.string.share_success_text, args.numCurrect,
//                    args.numQuestions))
//        return shareIntent

        return ShareCompat.IntentBuilder.from(activity!!)
                .setText(getString(R.string.share_success_text, args.numCurrect, args.numQuestions))
                .setType("text/plain")
                .intent


    }

    private fun shareSuccess() {
        startActivity(getShareIntent())

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }

        return super.onOptionsItemSelected(item)
    }
}
