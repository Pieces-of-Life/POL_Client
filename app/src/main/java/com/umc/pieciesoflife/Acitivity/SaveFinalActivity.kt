package com.umc.pieciesoflife.Acitivity

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentManager
import com.squareup.picasso.Picasso
import com.umc.pieciesoflife.DTO.StoryDto.StoryPost
import com.umc.pieciesoflife.DTO.StoryDto.StoryPostResult
import com.umc.pieciesoflife.DTO.StoryDto.StoryQna
import com.umc.pieciesoflife.DTO.StoryDto.StoryTag
import com.umc.pieciesoflife.DTO.UserDto.User
import com.umc.pieciesoflife.GlobalApplication
import com.umc.pieciesoflife.Interface.StoryService
import com.umc.pieciesoflife.Interface.UserService
import com.umc.pieciesoflife.R
import com.umc.pieciesoflife.Retrofit.RetrofitClient
import com.umc.pieciesoflife.databinding.ActivitySaveFinalBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class SaveFinalActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySaveFinalBinding
    var jwtToken = GlobalApplication.prefs.getString("jwtToken", "default-value")

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySaveFinalBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        var storyQnaList = intent.getSerializableExtra("storyQnaList") as ArrayList<StoryQna>
        var storyTagList = intent.getSerializableExtra("storyTagList") as ArrayList<StoryTag>
        var bookTitle = intent.getSerializableExtra("bookTitle") as String
        var bookIntro = intent.getSerializableExtra("bookIntro") as String
        var bookColor = intent.getSerializableExtra("bookColor") as String
        var nickname = intent.getSerializableExtra("nickname") as String
        var profileImgUrl = intent.getSerializableExtra("profileImgUrl") as String
        val manager: FragmentManager = supportFragmentManager
      //  val transaction: FragmentTransaction = manager.beginTransaction()
        val date: LocalDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
        val formatted_date = date.format(formatter)
        val imgProfile = findViewById<ImageView>(R.id.book_postProfile)

        //?????? ?????? ??????
        //?????? ?????? ??????
        viewBinding.bookPost.setImageResource(R.drawable.ic_book)
        viewBinding.bookPost.setColorFilter(Color.parseColor(bookColor))
        //??????
        viewBinding.bookPostTitle.setText(bookTitle)
        viewBinding.textViewTitle.setText(bookTitle)
        viewBinding.bookPostUserName.setText(nickname)
        viewBinding.finishText.setText("${nickname}??????\n???????????? ???????????????!")
        //?????????
        // user ?????? ??????
        val call: UserService = RetrofitClient.userService
        call.getUserInfo("Bearer ${RetrofitClient.jwtToken}").enqueue(object : Callback<User> {
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
                    viewBinding.bookPostUserName.setText(nickname)
                    Log.d("??????", "nickname : $nickname")
                } ?: Log.d("Body is null", "????????? ?????????.")
            }
        })
        //??????
        viewBinding.textViewDate.setText(formatted_date)
        //????????????
        viewBinding.textViewIntro.setText(bookIntro)

        //?????? ????????? ?????? ?????????
        val storyData = StoryPost(bookTitle, bookColor, bookIntro, storyQnaList, storyTagList)
        Log.i("storydata","$storyData") //dto ??????


        // ????????? ?????? ???, ?????? MyBookFragment ?????? UserFragment(????????? ????????? ???????????? ???????????? ???)??? ??????
        viewBinding.buttonFinish.setOnClickListener {
            // StoryService ?????? ??????
            val call: StoryService = RetrofitClient.storyService
            call.postStory("application/json","Bearer $jwtToken", storyData).enqueue(object: Callback<StoryPostResult> {
                override fun onResponse(call: Call<StoryPostResult>, response: Response<StoryPostResult>) {
                    if (response.isSuccessful) {
                        // ????????? ??????
                        Log.d("storyPost","${response.body()}")
                    }
                }
                override fun onFailure(call: Call<StoryPostResult>, t: Throwable) {
                    // ????????? ??????
                    Log.d("storyPost", "???????????????. ${t.message}")
                    t.printStackTrace()
                }
            })
            // MyBookFragment?????? ????????? ????????? ???????????? ????????? ?????? Activity?????? ?????? ??????
            this@SaveFinalActivity.finishAffinity()
//            transaction.replace(R.id.mainFrameLayout, MyBookFragment()).commit()
        }
    }
}