package com.fivestars.kloverexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.clover.sdk.util.CloverAccount
import com.clover.sdk.v3.order.OrderConnector
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var orderConnector: OrderConnector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
           orderConnector = OrderConnector(this@MainActivity, CloverAccount.getAccount(this@MainActivity), null)
        }

        orderConnector?.addOnOrderChangedListener { orderId, selfChange -> Log.d("darran", "$orderId $selfChange") }
    }
}