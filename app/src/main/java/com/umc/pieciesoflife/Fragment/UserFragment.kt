package com.umc.pieciesoflife.Fragment

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.viewpager2.widget.ViewPager2
import com.umc.pieciesoflife.R
import com.umc.pieciesoflife.Adapter.UserVPAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.umc.pieciesoflife.Acitivity.DialogUserEditActivity
import com.umc.pieciesoflife.Acitivity.LoginActivity
import com.umc.pieciesoflife.Acitivity.NotiActivity
import com.umc.pieciesoflife.Acitivity.StartNewstoryAcitivity
import com.umc.pieciesoflife.DTO.User
import com.umc.pieciesoflife.Retrofit.RetrofitClient
import com.umc.pieciesoflife.databinding.FragmentUserBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserFragment : Fragment() {


    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var viewBinding: FragmentUserBinding

    val accessToken = "LoginActivity().accessToken"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentUserBinding.inflate(inflater, container, false)
        val view:View = inflater.inflate(R.layout.fragment_user, container, false)
        viewPager = view.findViewById(R.id.viewPager)
        tabLayout =  view.findViewById(R.id.tabLayout)
        val pagerAdapter = UserVPAdapter(requireActivity())

        // ->알림
        val btnNoti = view.findViewById<ImageButton>(R.id.btn_noti)
        btnNoti.setOnClickListener {
            val intent = Intent(context, NotiActivity::class.java)
            startActivity(intent)
        }

        // ->유저 프로필 편집
        val btnEdit = view.findViewById<ImageButton>(R.id.btn_edit)
        btnEdit.setOnClickListener {
            val intent = Intent(context, DialogUserEditActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK   //  ← NEW_TASK 추가하지 않으면 기존 task와 같이 관리됩니다.
            startActivity(intent)
        }


        // ->새로운 이야기 작성
        val btnNewStory = view.findViewById<Button>(R.id.btn_new_story)
        btnNewStory.setOnClickListener {
            startActivity(Intent(context, StartNewstoryAcitivity::class.java))
        }

        //ViewPager
        // 2개의 fragment add
        pagerAdapter.addFragment(UserBookFragment())
        pagerAdapter.addFragment(UserMessageFragment())
        // adapter 연결
        viewPager.adapter = pagerAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int){
                super.onPageSelected(position)
                Log.e("ViewPagerFragment", "Page 이거 뜨면 되는거다? ${position+1}")
            }
        })

        //Tablayout
        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            when(position) {
                0 -> tab.text = "내가 좋아요 누른 자서전"
                1 -> tab.text = "쪽지함"
            }
        }.attach()

//        val profileImg = LoginActivity().profileImgUrl
//        val ninkname = LoginActivity().ninkname
//        val score = 0
//        val level = 0

        val userService = RetrofitClient.userService
        userService.getUserInfo("Bearer $accessToken").enqueue(object : Callback<User> {
            // 전송 실패
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("getUserInfo", t.message!!)
            }

            // 전송 성공
            override fun onResponse(call: Call<User>, response: Response<User>) {
                val result = response.body()
                Log.d("getUserInfo", " $result")
                Log.i(javaClass.simpleName, "api 받아오기 성공 : ${response.body()?.data}")

                Log.d("getUserInfo", "response : ${response.body()}") // 정상출력

                // 전송은 성공 but 서버 4xx 에러
                Log.d("getUserInfo: 에러바디", "response : ${response.errorBody()}")
                Log.d("getUserInfo: 메시지", "response : ${response.message()}")
                Log.d("getUserInfo: 코드", "response : ${response.code()}")


            }
        })



        return view
    }



    }



