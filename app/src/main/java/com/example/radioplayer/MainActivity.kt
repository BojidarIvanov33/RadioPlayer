package com.example.radioplayer

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.content.IntentFilter
import android.media.MediaPlayer
import android.media.MediaPlayer.OnErrorListener
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
public  var mediaPlayer: MediaPlayer? =null
public  var label:TextView?=null

class MainActivity : AppCompatActivity(), OnErrorListener {
    private val radiooneUrl:String="http://stream.radioreklama.bg/radio1rock128"
    private val radiooneN:String="http://stream.radioreklama.bg/radio1128"
    private val radioCity:String="http://stream.radioreklama.bg/city128"
    private val radioEnergy90:String="http://stream.radioreklama.bg/energy-90s"
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
    private var lastUrl: String? =null
    lateinit var reciever:BroadcastReceiver
//    var Tag="Main Activity"
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
//        Log.d(Tag,"app start here-------------")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        label=findViewById(R.id.onPlay)
        mediaPlayer?.prepareAsync()
// Stop media when bluetooth disconnect
        reciever= BroadcastReceiver()
        IntentFilter(BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED).also { registerReceiver(reciever,it) }

        btnRadOne=findViewById(R.id.btn_one_play)
        btnRadOne?.setOnClickListener {
            lastUrl=radiooneUrl
                radioOn(radiooneUrl)
            label?.text="Now playing: Radio 1 Rock"
        }

        btnFresh=findViewById(R.id.btn_fresh_play)
        btnFresh?.setOnClickListener {
            lastUrl=freshUrl
            radioOn(freshUrl)
            label?.text="Now playing: Radio Fresh"
                  }
        btnEnergy=findViewById(R.id.btn_energy_play)
        btnEnergy?.setOnClickListener {
            radioOn(radioEnergy90)
        }
        btnCity=findViewById(R.id.btn_city_play)
        btnCity?.setOnClickListener {
            lastUrl=radioCity
            radioOn(radioCity)
            label?.text="Now playing: Radio City"
        }
        btnVeronika=findViewById(R.id.btn_veronika_play)
        btnVeronika?.setOnClickListener {
            lastUrl=radioVeronika
            radioOn(radioVeronika)
            label?.text="Now playing: Radio Veronika"
        }
        btnAMG=findViewById(R.id.btn_amg_play)
        btnAMG?.setOnClickListener {
            lastUrl=radioAmg
            radioOn(radioAmg)
            label?.text="Now playing: Radio Italia .?"
        }
        btnAvto=findViewById(R.id.btn_avto_play)
        btnAvto?.setOnClickListener {
            lastUrl=radioAvto
            radioOn(radioAvto)
            label?.text="Now playing: Avto Radio"
        }
        btnOneN=findViewById(R.id.btn_oneN_play)
        btnOneN?.setOnClickListener {
            lastUrl=radiooneN
            radioOn(radiooneN)
            label?.text="Now playing: Radio 1 "
        }
        btnEnergyN=findViewById(R.id.btn_energyN_play)
        btnEnergyN?.setOnClickListener {
            lastUrl=radioEnergyN
            radioOn(radioEnergyN)
            label?.text="Now playing: Radio Energy"
        }
        btnFMplus=findViewById(R.id.btn_FMplus_play)
        btnFMplus?.setOnClickListener {
            lastUrl=radioFMplus
            radioOn(radioFMplus)
            label?.text="Now playing: Radio FM +"
        }
        btnMelody=findViewById(R.id.btn_melody_play)
        btnMelody?.setOnClickListener {
            lastUrl=radioMelody
            radioOn(radioMelody)
            label?.text="Now playing: Radio Melody"
        }
        btnNjoy=findViewById(R.id.btn_njoy_play)
        btnNjoy?.setOnClickListener {
            lastUrl=radioNjoy
            radioOn(radioNjoy)
            label?.text="Now playing: Radio Njoy"
        }
        btnMiami=findViewById(R.id.btn_miami_play)
        btnMiami?.setOnClickListener {
            lastUrl=radioMiami
            radioOn(radioMiami)
            label?.text="Now playing: Radio Miami beach"
        }
        btnRapMixxx=findViewById(R.id.btn_rapmixxx_play)
        btnRapMixxx?.setOnClickListener {
            lastUrl=radioRapMixxx
            radioOn(radioRapMixxx)
            label?.text="Now playing: Radio Rap Mixxx"
        }

    }

    fun  radioOn  (url:String){
            mediaPlayer?.reset()
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(this@MainActivity, Uri.parse(url))
            mediaPlayer?.start()
            mediaPlayer?.setOnErrorListener(this)
    }
    override fun onError(p0: MediaPlayer?, p1: Int, p2: Int): Boolean {
        radioOn(lastUrl!!)
//        Handler().postDelayed({ radioOn(lastUrl!!) },1000)
        return true
    }



}

