package com.mvvmsample.ui.login

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvmsample.data.model.User

class LoginViewModel : ViewModel() {
    private var userEmail: String? = null
    private var userPassword: String? = null
    var showProgress = MutableLiveData<Boolean>(false)
    var errorMessage = MutableLiveData<String>()
    var successMessage = MutableLiveData<String>()
    private lateinit var user: User


    fun getemail(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                userEmail = editable.toString()
            }
        }
    }

    fun getPassword(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                userPassword = editable.toString()
            }
        }
    }

    fun onLoginClicked(view: View) {

        if (userEmail.toString().trim().isNullOrEmpty()) {
            errorMessage.value = "Please enter correct email address"
            return
        }

        if (!userEmail.toString().contains("@")) {
            errorMessage.value = "Invalid Email"
            return
        }

        if (userPassword.isNullOrEmpty()) {
            errorMessage.value = "Password can't be blank"
            return
        }

        if (userPassword.toString().length < 6) {
            errorMessage.value = "Invalid Password "
            return
        }

        user = User(userEmail, userPassword)
        successMessage.value = "Success"
    }


}