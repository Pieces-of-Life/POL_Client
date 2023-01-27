package com.umc.pieciesoflife.BottomNavBar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umc.pieciesoflife.R
import com.umc.pieciesoflife.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var Binding: FragmentHomeBinding

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            Binding = FragmentHomeBinding.inflate(inflater, container, false)

            return Binding.root
        }


    }

