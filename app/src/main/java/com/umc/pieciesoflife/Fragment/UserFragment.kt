package com.umc.pieciesoflife.Fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.umc.pieciesoflife.R
import com.umc.pieciesoflife.Adapter.UserVPAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.umc.pieciesoflife.Acitivity.DialogUserEditActivity
import com.umc.pieciesoflife.Acitivity.NotiActivity
import com.umc.pieciesoflife.Acitivity.StartNewstoryAcitivity
import com.umc.pieciesoflife.DTO.MyPageDto.MyPage
import com.umc.pieciesoflife.Interface.UserService
import com.umc.pieciesoflife.Retrofit.RetrofitClient
import com.umc.pieciesoflife.DTO.UserDto.User
import com.umc.pieciesoflife.GlobalApplication
import com.umc.pieciesoflife.Interface.MyPageService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.properties.Delegates


class UserFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    var profileImgUrl =""
    lateinit var nickname :String
    var score by Delegates.notNull<Int>()
    var level by Delegates.notNull<Int>()

//    val accessToken = LoginActivity().accessToken

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_user, container, false)
        viewPager = view.findViewById(R.id.viewPager)
        tabLayout =  view.findViewById(R.id.tabLayout)

        val userName = view.findViewById<TextView>(R.id.username)
        val imgProfile = view.findViewById<ImageView>(R.id.img_profile)
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
            intent.putExtra("nickname",nickname)
            if(profileImgUrl != null) {
                intent.putExtra("imgProfile", profileImgUrl)
            } else {
                intent.putExtra("defaultFile", "R.drawable.ic_pol")
            }

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

        // accessToken 조회
        var accessToken =  GlobalApplication.prefs.getString("accessToken", "default-value")
        var jwtToken = GlobalApplication.prefs.getString("jwtToken", "default-value")

        Log.d("힝", accessToken)
        Log.d("내가 받은 서버톤큰", jwtToken)


        val myPageCall : MyPageService = RetrofitClient.myPageService
        myPageCall.getMyPage("Bearer $jwtToken").enqueue(object : Callback<MyPage> {
            // 전송 실패
            override fun onFailure(call: Call<MyPage>, t: Throwable) {
                Log.d("getUserInfo", t.message!!)
            }

            override fun onResponse(call: Call<MyPage>, response: Response<MyPage>) {
                response.body()?.let {
                    Log.d("MyPage call" , "${response.body()}")
                } ?: Log.d("Body is null", "몸통은 비었다.")
            }
        })




        val call: UserService = RetrofitClient.userService
        call.getUserInfo("Bearer $jwtToken").enqueue(object : Callback<User> {
            // 전송 실패
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("getUserInfo", t.message!!)
            }

            // 전송 성공
            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onResponse(call: Call<User>, response: Response<User>){
                response.body()?.let {
                    if(it.data.profileImgUrl != null) {
                        profileImgUrl = it.data.profileImgUrl
                        Glide.with(imgProfile.context)
                            .load(profileImgUrl)
                            .into(imgProfile)
                    } else { // 기본 이미지 지정 -> intent로 값 넘겨야 해서 지정
                        imgProfile.setImageResource(R.drawable.ic_pol)
                    }
                     nickname = it.data.nickname
                     score = it.data.score
                     level = it.data.level

                     userName.setText(nickname)

                    Log.d("성공" , "profile : $profileImgUrl \nnickname : $nickname \nscore : $score \nlevel : $level")
                } ?: Log.d("Body is null", "몸통은 비었다.")
            }
        })

        return view
    }



    }



