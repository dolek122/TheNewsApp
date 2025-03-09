package com.example.thenewsapp.sensors

import android.content.Context
import com.example.thenewsapp.ui.NewsViewModel
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatDelegate
import kotlin.math.sqrt

//obsługa czujników światła i akcelerometr w aplikacji
class SensorHelper(context: Context,private val newsViewModel: NewsViewModel, private val onShake: () -> Unit) : SensorEventListener {

    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    private val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    private var lastShakeTime = 0L

    //aktywuje czujnik
    fun registerSensors() {
        lightSensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
        accelerometer?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_UI)
        }
    }

    //dezaktywuje czujnik
    fun unregisterSensors() {
        sensorManager.unregisterListener(this)
    }

    //reaguje na zmiany wartości czujnikow
    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            when (it.sensor.type) {
                Sensor.TYPE_LIGHT -> handleLightSensor(it.values[0])
                Sensor.TYPE_ACCELEROMETER -> handleAccelerometer(it.values)
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    //zmiana trybu w zaleznosci od swiatla
    private fun handleLightSensor(lux: Float) {
        val nightMode = AppCompatDelegate.getDefaultNightMode()
        if (lux < 10 && nightMode != AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else if (lux >= 10 && nightMode != AppCompatDelegate.MODE_NIGHT_NO) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    //wykrywanie potrzasniec i uruchamia przekazana funkcje (odswiezanie strony)
    private fun handleAccelerometer(values: FloatArray) {
        val acceleration = sqrt(values[0] * values[0] + values[1] * values[1] + values[2] * values[2])
        val shakeThreshold = 15f
        if (acceleration > shakeThreshold) {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastShakeTime > 1000) {
                lastShakeTime = currentTime
                newsViewModel.getHeadlines("us")
                onShake()
            }
        }
    }
}
