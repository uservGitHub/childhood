package pdfbook.sample.stages

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v4.content.ContextCompat.startActivity
import android.view.Gravity
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.*


/**
 * Created by Administrator on 2017/12/31.
 */

class StageUtils {
    companion object {
        //region    页面流转
        fun pass(activity: Activity) {
            launch {
                delay(500)

                when (activity.localClassName) {
                    MainActivity::class.java.simpleName -> startActivity(activity, Intent(activity, Stage_1_1::class.java), null)
                    Stage_1_1::class.java.simpleName -> startActivity(activity, Intent(activity, Stage_2_1::class.java), null)
                    Stage_2_1::class.java.simpleName -> startActivity(activity, Intent(activity, TestActivity::class.java), null)
                }
            }

        }

        //endregion
        //region    默认UI呈现，类名称
        fun defaultRender(activity: Activity, autoPass: Boolean = false) {
            activity.verticalLayout {
                textView() {
                    text = activity.localClassName
                    textSize = 24F
                    textColor = Color.BLUE
                    gravity = Gravity.CENTER
                }.lparams(width = matchParent, height = matchParent)
            }.apply {
                if (autoPass) pass(activity)
            }
        }
        //endregion
    }
}