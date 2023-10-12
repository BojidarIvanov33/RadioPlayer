package com.example.radioplayer

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val radiooneUrl:String="http://stream.radioreklama.bg/radio1rock128"
    private val radiooneN:String="http://stream.radioreklama.bg/radio1128"
    private val radioCity:String="http://stream.radioreklama.bg/city128"
    private val radioEnergy90:String="http://stream.radioreklama.bg/energy-90s"
    private val radioEnjoy:String="http://stream.radioreklama.bg/nrj128"
    private val radioEnergyN:String="http://stream.radioreklama.bg/nrj128"
    private val radioVeronika:String="http://stream.radioreklama.bg/veronika128"
    private  val radioAvto:String="http://play.global.audio/avtoradio.mp3"
    private val radioFMplus:String="http://radio.freeplace.info:8000/FMPlus.mp3"
    private  val radioAmg:String="http://stream.lolliradio.net/lolli_hits.mp3"
    private val radioMelody:String="http://193.108.24.6:8000/melody?file=.mp3"
    private  val radioNjoy:String="https://web.static.btv.bg/radio/njoy-radio-proxy/index.php"
    private val radioMiami:String="https://streaming.radiostreamlive.com/miamibeachradio_devices"
    private val radioRapMixxx:String= "http://ais-sa2.cdnstream1.com/1988_128.mp3"
    private  val freshUrl:String="http://193.108.24.21:8000/fresh?file=.mp3 "
    private var mediaPlayer:MediaPlayer?=null
    private  var btnRadOne:Button?=null
    private var btnFresh:Button?=null
    private var btnCity:Button?=null
    private var btnEnergy:Button?=null
    private var btnVeronika:Button?=null
    private var btnAMG:Button?=null
    private var btnAvto:Button?=null
    private  var btnOneN:Button?=null
    private  var btnEnergyN:Button?=null
    private var btnFMplus:Button?=null
    private var btnMelody:Button?=null
    private var btnNjoy:Button?=null
    private var btnMiami:Button?=null
    private var btnRapMixxx:Button?=null
    private  var label:TextView?=null
    private var bluetoothAdapter:BluetoothAdapter?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        label=findViewById(R.id.onPlay)
bluetoothAdapter= BluetoothAdapter.getDefaultAdapter()
        if(!bluetoothAdapter!!.isEnabled){
            label?.text="Turn on Bluetooth"
        }

     fun  radioOn   (url:String){
            mediaPlayer?.release()
            mediaPlayer=null
            mediaPlayer?.prepareAsync()
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