package pdfbook.sample.stages

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.view.WindowManager

/**
 * Created by Administrator on 2017/12/31.
 */

class ScreenUtils{
    companion object {
        fun notitle(activity: AppCompatActivity){
            activity.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        }
        fun fullScreen(activity: Activity){
            activity.window.apply {
                setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
                decorView.systemUiVisibility =
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN
            }
        }
    }
}