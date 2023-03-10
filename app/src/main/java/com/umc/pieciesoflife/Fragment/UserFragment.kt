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
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.umc.pieciesoflife.R
import com.umc.pieciesoflife.Adapter.UserVPAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso
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

    var profileImgUrl = ""
    var nickname = ""
    var score by Delegates.notNull<Int>()
    var level by Delegates.notNull<Int>()
    var userId by Delegates.notNull<Int>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_user, container, false)
        viewPager = view.findViewById(R.id.viewPager)
        tabLayout = view.findViewById(R.id.tabLayout)

        val userName = view.findViewById<TextView>(R.id.username)
        val imgProfile = view.findViewById<ImageView>(R.id.img_profile)
        val pagerAdapter = UserVPAdapter(requireActivity())

        // accessToken ??????
        var accessToken = GlobalApplication.prefs.getString("accessToken", "default-value")
        var jwtToken = GlobalApplication.prefs.getString("jwtToken", "default-value")

        Log.d("???", accessToken)
        Log.d("?????? ?????? ????????????", jwtToken)

        // user ?????? ??????
        val call: UserService = RetrofitClient.userService
        call.getUserInfo("Bearer $jwtToken").enqueue(object : Callback<User> {
            // ?????? ??????
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("getUserInfo", t.message!!)
            }

            // ?????? ??????
            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onResponse(call: Call<User>, response: Response<User>) {
                response.body()?.let {
                    if (it.data.profileImgUrl != null) {
                        profileImgUrl = it.data.profileImgUrl
                        Picasso.get().load(profileImgUrl).into(imgProfile)
                    } else { // ?????? ????????? ?????? -> intent??? ??? ????????? ?????? ??????
                        imgProfile.setImageResource(R.drawable.ic_default_profileimg)
                    }
                    nickname = it.data.nickname
                    score = it.data.score
                    level = it.data.level
                    userId = it.data.userId

                    userName.setText(nickname)

                    Log.d(
                        "??????",
                        "userId : $userId \nprofile : $profileImgUrl \nnickname : $nickname \nscore : $score \nlevel : $level"
                    )
                } ?: Log.d("Body is null", "????????? ?????????.")
            }
        })

        // ->??????
        val btnNoti = view.findViewById<ImageButton>(R.id.btn_noti)
        btnNoti.setOnClickListener {
            val intent = Intent(context, NotiActivity::class.java)
            startActivity(intent)
        }

        // ->?????? ????????? ??????
        val btnEdit = view.findViewById<ImageButton>(R.id.btn_edit)
        btnEdit.setOnClickListener {
            val intent = Intent(context, DialogUserEditActivity::class.java)
            intent.putExtra("nickname", nickname)
            if (profileImgUrl != null) {
                intent.putExtra("imgProfile", profileImgUrl)
            } else {
                intent.putExtra("defaultFile", R.drawable.ic_default_profileimg)
            }

            intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK   //  ??? NEW_TASK ???????????? ????????? ?????? task??? ?????? ???????????????.
            startActivity(intent)
        }

        // ->????????? ????????? ??????
        val btnNewStory = view.findViewById<Button>(R.id.btn_new_story)
        btnNewStory.setOnClickListener {
            val intent = Intent(context, StartNewstoryAcitivity::class.java)
            startActivity(intent)
        }

        //ViewPager
        // 2?????? fragment add
        pagerAdapter.addFragment(UserBookFragment())
        pagerAdapter.addFragment(UserChatFragment())
        // adapter ??????
        // userMessageFragment??? userId????????????
        viewPager.adapter = pagerAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // UserChatFragment??? userId ??? ?????????
                when(position) {
                    1->
                    {
                        val result = userId.toString()
                        setFragmentResult("requestKey", bundleOf("bundleKey" to result))
                        parentFragmentManager.beginTransaction()
                            .replace(R.id.fragment_user, UserChatFragment())
                            .commit()
                    }

                }
                Log.e("ViewPagerFragment", "Page ?????? ?????? ????????????? ${position + 1}")
            }
        })

        //Tablayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "?????? ????????? ?????? ?????????"
                1 -> tab.text = "?????????"
            }
        }.attach()


        val myPageCall: MyPageService = RetrofitClient.myPageService
        myPageCall.getMyPage("Bearer $jwtToken").enqueue(object : Callback<MyPage> {
            // ?????? ??????
            override fun onFailure(call: Call<MyPage>, t: Throwable) {
                Log.d("??????????????? ?????? ??????", t.message!!)
            }

            override fun onResponse(call: Call<MyPage>, response: Response<MyPage>) {
                response.body()?.let {
                    Log.d("??????????????? ?????? ??????", "${it.data.story}")
                } ?: Log.d("??????????????? body null!!!", "????????? ?????????.")
            }
        })


        return view
    }

}



