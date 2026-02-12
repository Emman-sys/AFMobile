package com.example.afmobile

import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<RelativeLayout>(R.id.your_orders_layout).setOnClickListener {
            startActivity(Intent(this, MyOrdersActivity::class.java))
        }

        findViewById<RelativeLayout>(R.id.my_cart_layout).setOnClickListener {
            startActivity(Intent(this, MyCartActivity::class.java))
        }

        findViewById<RelativeLayout>(R.id.my_address_layout).setOnClickListener {
            Toast.makeText(this, "My Address Clicked", Toast.LENGTH_SHORT).show()
        }

        findViewById<RelativeLayout>(R.id.payment_methods_layout).setOnClickListener {
            startActivity(Intent(this, ToPayActivity::class.java))
        }

        findViewById<RelativeLayout>(R.id.settings_layout).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        findViewById<RelativeLayout>(R.id.help_support_layout).setOnClickListener {
            Toast.makeText(this, "Help & Support Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}