package com.umc.pieciesoflife.Acitivity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.umc.pieciesoflife.DTO.UserDto.User
import com.umc.pieciesoflife.DTO.UserDto.UserEdit
import com.umc.pieciesoflife.GlobalApplication
import com.umc.pieciesoflife.Interface.UserService
import com.umc.pieciesoflife.Retrofit.RetrofitClient
import com.umc.pieciesoflife.databinding.ActivityUserEditBinding
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File


class UserEditActivity:AppCompatActivity() {
    private lateinit var viewBinding: ActivityUserEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityUserEditBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        var profileImgUrl = ""
        var defaultFile = ""

        val userIntent = intent

        var jwtToken = GlobalApplication.prefs.getString("jwtToken", "default-value")

        var nickname = userIntent.getStringExtra("nickname")
        viewBinding.editNickName.setText(nickname)

        if(userIntent.getStringExtra("imgProfile")!=null) {
            profileImgUrl = userIntent.getStringExtra("imgProfile")!!
            Picasso.get().load(profileImgUrl).into(viewBinding.imgProfile)
        } else {
            viewBinding.imgProfile.setImageResource(com.umc.pieciesoflife.R.drawable.ic_default_profileimg)
        }

        viewBinding.btnCamera.setOnClickListener{
            selectGallery()
            val imgFile = File("profileImg")
            Log.d("?????????????????????", "$imgFile")
            val imgRequestFile = RequestBody.create(MediaType.parse("image/png"), imgFile)
            val imgBody = MultipartBody.Part.createFormData("file", imgFile.name, imgRequestFile)
            Picasso.get().load(imgFile).into(viewBinding.imgProfile)
//            Picasso.get().load(profileImgUrl).into(viewBinding.imgProfile)
//            Glide.with(this)
//                .load(imageResult)
//                .into(viewBinding.imgProfile)
        }


        // ????????????
        viewBinding.btnUserEditCancel.setOnClickListener {
            this@UserEditActivity.finishAffinity()
      }

        // ???????????? ?????? ?????????
        viewBinding.btnUserEditOk.setOnClickListener{
            val editImg = viewBinding.imgProfile
            val editName = viewBinding.editNickName

            val call: UserService = RetrofitClient.userService

            if(editImg.equals("") || editImg.equals(null)) {
                profileImgUrl = userIntent.getStringExtra("imgProfile")!!
                Picasso.get().load(profileImgUrl).into(viewBinding.imgProfile)
            } else {
                val imgFile = File("editImg")
                val imgRequestFile = RequestBody.create(MediaType.parse("image/png"), imgFile)
                val imgBody = MultipartBody.Part.createFormData("file", imgFile.name, imgRequestFile)
                call.patchUserProfile("multipart/form-data","Bearer $jwtToken","$editName", imgBody).enqueue(object : Callback<UserEdit> {
                    // ?????? ??????
                    override fun onFailure(call: Call<UserEdit>, t: Throwable) {
                        Log.d("???????????????????????????", t.message!!)
                    }

                    // ?????? ??????
                    override fun onResponse(call: Call<UserEdit>, response: Response<UserEdit>){
                        response.body()?.let {
                            var aa = it.data.nickname
                            var bb = it.data.profileImgUrl

                            Log.d("??????" , "profile : $bb \nnickname : $aa ")
                        } ?: Log.d("Body is null", "????????? ?????????.")
                    }
                })
            }

            this@UserEditActivity.finishAffinity()
            Toast.makeText(this, "???????????? ???????????????", Toast.LENGTH_SHORT ).show()
        }

    }

    companion object{
        const val REVIEW_MIN_LENGTH = 10
        // ????????? ?????? ??????
        const val REQ_GALLERY = 1

        // API ?????? ??? PArameter key ???
        const val PARAM_KEY_IMAGE = "image"
        const val PARAM_KEY_PRODUCT_ID = "product_id"
        const val PARAM_KEY_REVIEW = "review_content"
        const val PARAM_KEY_RATING = "rating"
    }



    // ????????? ??????????????? ?????? ??????
    private val imageResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        result ->
        if(result.resultCode == RESULT_OK) {
            val imageUri = result.data?.data
            imageUri?.let {

                // ?????? ???????????? ?????? ?????? ????????? ??????
                var imageFile = File(getRealPathFromURI(it))

                // ????????? ?????????
                Glide.with(this)
                    .load(imageUri)
                    .fitCenter()
                    .into(viewBinding.imgProfile)
            }
        }
    }

    // ????????? ?????? ?????? ??????
    fun getRealPathFromURI(uri: Uri):String{
        val buildName = Build.MANUFACTURER
        if(buildName.equals("Xiaomi")) {
            return uri.path!!
        }
        var columnIndex = 0
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(uri,proj,null,null,null)
        if(cursor!!.moveToFirst()){
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        val result = cursor.getString(columnIndex)
        cursor.close()
        return result
    }

    // ????????? ????????? ?????????
    private fun selectGallery() {
        val writePermission = ContextCompat.checkSelfPermission(this,
        Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val readPermission = ContextCompat.checkSelfPermission(this,
        Manifest.permission.READ_EXTERNAL_STORAGE)

        // ?????? ??????
        if(writePermission == PackageManager.PERMISSION_DENIED ||
                readPermission == PackageManager.PERMISSION_DENIED) {
            // ?????? ??????
            ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE), REQ_GALLERY)
        } else {
            // ????????? ?????? ?????? ????????? ??????
            val intent = Intent(Intent.ACTION_PICK)
            // intent??? data??? type??? ????????? ???????????? ?????????
            intent.setDataAndType(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*"
            )
            imageResult.launch(intent)
        }
    }



}

