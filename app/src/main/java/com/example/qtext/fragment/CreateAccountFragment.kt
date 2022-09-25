package com.example.qtext.fragment

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.example.qtext.R
import kotlinx.android.synthetic.main.fragment_create_account.*
import kotlinx.android.synthetic.main.fragment_create_account.view.*

class CreateAccountFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_account, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        family_edit.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val s=family_edit.text.toString()
                val length=s.length.toString()
                family_count.setText(length)
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        family_edit.setOnFocusChangeListener(object :View.OnFocusChangeListener{
            override fun onFocusChange(p0: View?, p1: Boolean) {
                if (p0!!.hasFocus()){
                    create_family.setTextColor(resources.getColor(R.color.black))
                    create_family.setOnClickListener {
                        create_family.visibility=View.GONE
                        next.visibility=View.VISIBLE
                        next.setOnClickListener {
                            next.visibility=View.GONE
                            checking.visibility=View.VISIBLE
                            val handler=Handler()
                            handler.postDelayed({
                                checking.apply {
                                    setTextSize(14F)
                                    setTextColor(resources.getColor(R.color.blue))
                                    setText("done")

                                }
                                linear_count.visibility=View.GONE
                                show_text.visibility=View.VISIBLE
                                family.setTextColor(resources.getColor(R.color.Dark_blue))
                            },3000)


                        }
                    }
                }
                if (!p0.hasFocus()){
                    create_family.setTextColor(resources.getColor(R.color.dark_gray))
                }
            }

        })


    }



}