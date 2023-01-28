package com.example.flowproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

import kotlinx.coroutines.launch

class FlowBuildersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow_builders)

//        lifecycleScope.launch {
//            flowOf(4,3,2,1,5,6).collect{
//                Log.d("FlowBuilders", "flowOf():$it")
//            }
//        }
//
//
//        lifecycleScope.launch {
//            flowOf("Shoaib","Ali","Bruce","Wayne").collect{
//                Log.d("FlowBuilder", "flowOf():$it")
//            }
//        }


//        lifecycleScope.launch {
//            (1..5).asFlow().collect{
//                Log.d("Flow Builders","asFlow : $it")
//            }
//        }


//        lifecycleScope.launch {
//         flow {
//             (0..10).forEach{
//                 emit(it)
//             }
//         }.collect{
//             Log.e("Flow Builders","flow : $it")
//         }
//        }
//


//        lifecycleScope.launch{
//            channelFlow {
//                (0..10).forEach {
//                    send(it)
//                }
//            }.collect{
//                Log.d("Flow Builders","channelFlow: $it")
//            }
//        }

        GlobalScope.launch(Dispatchers.Main) {
            producer()
                .onStart {
                    Log.d("TAG","Starting out")
                    emit(-100)
                }
                .onCompletion {
                    Log.d("TAG","Completed")
                }
                .onEach {
                    Log.d("TAG","About to Emit = $it")
                }
                .collect{
                Log.d("TAG","${it.toString()}")
            }
        }


    }


    private fun producer():Flow<Int>{
        return flow<Int>{
            val list=listOf(1,2,3,4,5)
            list.forEach{
                delay(1000)
                emit(it)
            }
        }
    }
}