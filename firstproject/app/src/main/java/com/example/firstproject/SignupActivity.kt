package com.example.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import com.example.firstproject.databinding.ActivitySignupBinding
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup2.setOnClickListener {

            var fname=binding.etFname.text.toString().trim()
            var lname=binding.etLname.text.toString().trim()
            var gender=binding.etGender.text.toString().trim()
            var mobile=binding.etMobile.text.toString().trim()
            var email=binding.etEmail.text.toString().trim()
            var password=binding.etPassword.text.toString().trim()
            var Cpassword=binding.etConfirmpassword.text.toString().trim()

            if (fname.isEmpty()) {
                //show error
                binding.etFname.error="Enter First name"
            }else if (lname.isEmpty()){
                //show error
                binding.etLname.error="Enter last name"
            }else if (gender.isEmpty()){
                //show error
                binding.etGender.error="Enter gender "
            }else if (!iscontact(mobile)){
                //show error
                binding.etMobile.error="Enter mobile number"
            }else if (!isvalidemail(email)){
                //show error
                binding.etEmail.error="Enter Email"
            }else if(!isvalidpassword(password)){
                //show error
                binding.etPassword.error="Enter password"
            }else if (password !== Cpassword){
                //show error
                binding.etConfirmpassword.error="enter same password"
                binding.etConfirmpassword.setText("")
            }else {
                //all fields are validated

            }

        }
    }

    private fun iscontact(contact:String) :Boolean{
        return contact.length==10
    }
    private fun isvalidemail(email: String):Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isvalidpassword(password:String):Boolean{
        var regex ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&-+=()])(?=\\\\S+\$).{8, 20}\$"
        return Pattern.compile(regex).matcher(password).matches()
    }
}