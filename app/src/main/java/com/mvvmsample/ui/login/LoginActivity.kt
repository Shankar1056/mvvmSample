package com.mvvmsample.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mvvmsample.R
import com.mvvmsample.Utility.Util
import com.mvvmsample.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.viewmodel = loginViewModel
        binding.lifecycleOwner = this

        loginViewModel.errorMessage.observe(this, Observer {
            Util.showToast(applicationContext, it)
        })

        loginViewModel.successMessage.observe(this, Observer {
            Util.showToast(applicationContext, it)
        })

    }


}