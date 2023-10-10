package com.example.radioplayer

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


val radiooneUrl:String="http://stream.radioreklama.bg/radio1rock128"
val radiooneN:String="http://stream.radioreklama.bg/radio1128"
val radioCity:String="http://stream.radioreklama.bg/city128"
val radioEnergy90:String="http://stream.radioreklama.bg/energy-90s"
val radioEnjoy:String="http://stream.radioreklama.bg/nrj128"
val radioEnergyN:String="http://stream.radioreklama.bg/nrj128"
val radioVeronika:String="http://stream.radioreklama.bg/veronika128"
val radioAvto:String="http://play.global.audio/avtoradio.mp3"
val radioFMplus:String="http://radio.freeplace.info:8000/FMPlus.mp3"
val radioAmg:String="http://stream.lolliradio.net/lolli_hits.mp3"
val radioMelody:String="http://193.108.24.6:8000/melody?file=.mp3"
val radioNjoy:String="https://web.static.btv.bg/radio/njoy-radio-proxy/index.php"
val radioMiami:String="https://streaming.radiostreamlive.com/miamibeachradio_devices"
val radioRapMixxx:String= "http://ais-sa2.cdnstream1.com/1988_128.mp3"
val freshUrl:String="http://193.108.24.21:8000/fresh?file=.mp3 "
var mediaPlayer:MediaPlayer?=null
var btnRadOne:Button?=null
var btnFresh:Button?=null
var btnCity:Button?=null
var btnEnergy:Button?=null
var btnVeronika:Button?=null
var btnAMG:Button?=null
var btnAvto:Button?=null
var btnOneN:Button?=null
var btnEnergyN:Button?=null
var btnFMplus:Button?=null
var btnMelody:Button?=null
var btnNjoy:Button?=null
var btnMiami:Button?=null
var btnRapMixxx:Button?=null
var label:TextView?=null


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        label=findViewById(R.id.onPlay)
        fun radioOn (url:String){
            mediaPlayer?.release()
            mediaPlayer=null
            mediaPlayer=MediaPlayer.create(this@MainActivity, Uri.parse(url))
            mediaPlayer?.start()
        }

        btnRadOne=findViewById(R.id.btn_one_play)
        btnRadOne?.setOnClickListener {
                radioOn(radiooneUrl)
            label?.text="Now playing: Radio 1 Rock"
        }

        btnFresh=findViewById(R.id.btn_fresh_play)
        btnFresh?.setOnClickListener {
            radioOn(freshUrl)
            label?.text="Now playing: Radio Fresh"
                  }
        btnEnergy=findViewById(R.id.btn_energy_play)
        btnEnergy?.setOnClickListener {
            radioOn(radioEnergy90)
        }
        btnCity=findViewById(R.id.btn_city_play)
        btnCity?.setOnClickListener {
            radioOn(radioCity)
            label?.text="Now playing: Radio City"
        }
        btnVeronika=findViewById(R.id.btn_veronika_play)
        btnVeronika?.setOnClickListener {
            radioOn(radioVeronika)
            label?.text="Now playing: Radio Veronika"
        }
        btnAMG=findViewById(R.id.btn_amg_play)
        btnAMG?.setOnClickListener {
            radioOn(radioAmg)
            label?.text="Now playing: Radio Italia .?"
        }
        btnAvto=findViewById(R.id.btn_avto_play)
        btnAvto?.setOnClickListener {
            radioOn(radioAvto)
            label?.text="Now playing: Avto Radio"
        }
        btnOneN=findViewById(R.id.btn_oneN_play)
        btnOneN?.setOnClickListener {
            radioOn(radiooneN)
            label?.text="Now playing: Radio 1 "
        }
        btnEnergyN=findViewById(R.id.btn_energyN_play)
        btnEnergyN?.setOnClickListener {
            radioOn(radioEnergyN)
            label?.text="Now playing: Radio Energy"
        }
        btnFMplus=findViewById(R.id.btn_FMplus_play)
        btnFMplus?.setOnClickListener {
            radioOn(radioFMplus)
            label?.text="Now playing: Radio FM +"
        }
        btnMelody=findViewById(R.id.btn_melody_play)
        btnMelody?.setOnClickListener {
            radioOn(radioMelody)
            label?.text="Now playing: Radio Melody"
        }
        btnNjoy=findViewById(R.id.btn_njoy_play)
        btnNjoy?.setOnClickListener {
            radioOn(radioNjoy)
            label?.text="Now playing: Radio Njoy"
        }
        btnMiami=findViewById(R.id.btn_miami_play)
        btnMiami?.setOnClickListener {
            radioOn(radioMiami)
            label?.text="Now playing: Radio Miami beach"
        }
        btnRapMixxx=findViewById(R.id.btn_rapmixxx_play)
        btnRapMixxx?.setOnClickListener {
            radioOn(radioRapMixxx)
            label?.text="Now playing: Radio Rap Mixxx"
        }
    }
}