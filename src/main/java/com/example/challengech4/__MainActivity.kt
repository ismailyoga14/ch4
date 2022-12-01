package com.example.challengech4

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.text.Selection
import android.text.Selection.setSelection
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class __MainActivity : AppCompatActivity(),View.OnClickListener {

//    lateinit var ivbatu: AppCompatImageView
//    lateinit var ivgunting: AppCompatImageView
//    lateinit var ivkertas: AppCompatImageView
//    lateinit var ivrefresh: AppCompatImageView
//    lateinit var tvversus: AppCompatTextView
//    lateinit var ivkertascom: AppCompatImageView
//    lateinit var ivbatucom: AppCompatImageView
//    lateinit var ivguntingcom: AppCompatImageView


    private val gameArray = arrayOf(R.id.iv_batucom, R.id.iv_kertascom, R.id.iv_guntingcom)
    private var gameNumber : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        setStartGame()
//        setUpView()
//        setUpAction()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Toast.makeText(applicationContext, "CPU - top, Human - bottom", Toast.LENGTH_LONG).show()

        val rock : TextView = findViewById(R.id.iv_batu)
        val paper : TextView = findViewById(R.id.iv_kertas)
        val scissors : TextView = findViewById(R.id.iv_gunting)

        rock.setOnClickListener(this)
        paper.setOnClickListener(this)
        scissors.setOnClickListener(this)
    }

    override fun onClick(v : View){
        val id = v.id

        when(id){   //checking for button id selected
            R.id.iv_batu -> {
                gameNumber = 1 //value for rock
                //TODO: set active textview player
//                bottomImage.setImageResource(R.drawable.rock) //sets buttom image as user
                computerPlay() //function provides random cpu image
            }
            R.id.iv_kertas -> {
                gameNumber = 2
//                bottomImage.setImageResource(R.drawable.paper)
                computerPlay()
            }
            R.id.iv_gunting -> {
                gameNumber = 3
//                bottomImage.setImageResource(R.drawable.scissors)
                computerPlay()
            }
        }
    }

    private fun computerPlay() {
        val imageId = (gameArray.indices).random()
//        topImage.setImageResource(gameArray[imageId])
        //TODO: set active textview comp
        checkWinner(imageId)
    }

    private fun checkWinner(imageId : Int) {
        // game logic - gets user image by value and checks against cpu image
        if(gameNumber == 1 && imageId == 0) {
            showWinner(2)
        } else if(gameNumber == 1 && imageId == 1){
            showWinner(1)
        } else if(gameNumber == 1 && imageId == 2){
            showWinner(0)
        } else if(gameNumber == 2 && imageId == 0){
            showWinner(0)
        } else if(gameNumber == 2 && imageId == 1){
            showWinner(2)
        } else if(gameNumber == 2 && imageId == 2){
            showWinner(1)
        } else if(gameNumber == 3 && imageId == 0){
            showWinner(1)
        } else if(gameNumber == 3 && imageId == 1){
            showWinner(0)
        } else if(gameNumber == 3 && imageId == 2){
            showWinner(2)
        }
    }

    private fun showWinner(result: Int) {
        //winning logic
//        when (result) {
//            0 -> Toast.makeText(applicationContext, "You Won!!!", Toast.LENGTH_SHORT).show()
//            1 -> Toast.makeText(applicationContext, "Oh No, You Lost!!!", Toast.LENGTH_SHORT).show()
//            else -> Toast.makeText(applicationContext, "Tie Game!!!", Toast.LENGTH_SHORT).show()
//        }
    }

//    private fun setStartGame() {
////
//        val list = listOf("kertas", "gunting", "batu").random()
//        val randomElement = list.asSequence().shuffled().find { true }
//
//
//    }
//
//
//    private fun setUpView() {
//        ivbatu = findViewById(R.id.iv_batu)
//        ivgunting = findViewById(R.id.iv_gunting)
//        ivkertas = findViewById(R.id.iv_kertas)
//        ivrefresh = findViewById(R.id.iv_refresh)
//        tvversus = findViewById(R.id.tv_vs)
//        ivbatucom = findViewById(R.id.iv_batucom)
//        ivguntingcom = findViewById(R.id.iv_guntingcom)
//        ivkertascom = findViewById(R.id.iv_kertascom)
//    }
//
//    private fun setUpAction() {
//        ivrefresh.setOnClickListener {
////            setStartGame()
//        }
//        val list = listOf("kertas", "gunting", "batu").random()
//
//        ivkertas.setOnClickListener {
//            setSelection(kertas)
//        }
//        ivgunting.setOnClickListener {
//            setSelection(gunting)
//            resultSet(gunting)
//        }
//        ivbatu.setOnClickListener {
//            setSelection(batu)
//            resultSet(batu)
//        }
//
//    }
//
//    private fun setSelection(typeSelection: String) {
//        when (typeSelection) {
//            kertas -> {
//                ivkertas.setBackgroundResource(R.drawable.bg_ellipse_selector)
//                ivgunting.setBackgroundResource(0)
//                ivbatu.setBackgroundResource(0)
//            }
//            gunting -> {
//                ivgunting.setBackgroundResource(R.drawable.bg_ellipse_selector)
//                ivkertas.setBackgroundResource(0)
//                ivbatu.setBackgroundResource(0)
//            }
//            batu -> {
//                ivbatu.setBackgroundResource(R.drawable.bg_ellipse_selector)
//                ivgunting.setBackgroundResource(0)
//                ivkertas.setBackgroundResource(0)
//            }
//            kertascom -> {
//                ivkertas.setBackgroundResource(R.drawable.bg_ellipse_selector)
//                ivgunting.setBackgroundResource(0)
//                ivbatu.setBackgroundResource(0)
//            }
//            guntingcom -> {
//                ivgunting.setBackgroundResource(R.drawable.bg_ellipse_selector)
//                ivkertas.setBackgroundResource(0)
//                ivbatu.setBackgroundResource(0)
//            }
//            batucom-> {
//                ivbatu.setBackgroundResource(R.drawable.bg_ellipse_selector)
//                ivgunting.setBackgroundResource(0)
//                ivkertas.setBackgroundResource(0)
//            }
//        }
//    }
//
//    private fun resultSet(resultGame: String) {
//        when (resultGame) {
//            kertas -> {
//                tvversus.setBackgroundResource(R.drawable.bg_ellipse_selector)
//            }
//            gunting -> {
//                tvversus.setBackgroundResource(R.drawable.bg_ellipse_selector)
//            }
//            batu -> {
//                tvversus.setBackgroundResource(R.drawable.bg_ellipse_selector)
//            }
//        }
//    }
//
//    companion object {
//        const val kertas = "kertas"
//        const val gunting = "gunting"
//        const val batu = "batu"
//        const val batucom = "batucom"
//        const val kertascom = "kertascom"
//        const val guntingcom = "guntingcom"
//    }
}


