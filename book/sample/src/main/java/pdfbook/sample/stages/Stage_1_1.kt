package pdfbook.sample.stages

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

/**
 * Created by Administrator on 2017/12/31.
 * 1_1 权限检查，通过了发消息
 */

class Stage_1_1:AppCompatActivity(),AnkoLogger{
    override val loggerTag: String
        get() = "Stage_1_1"
    private fun pass(){
        StageUtils.pass(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //region Permisson(check and request)
        if (savedInstanceState == null) {
            if(checkPermission()){
                this.pass()
            }else {
                ActivityCompat.requestPermissions(
                        this@Stage_1_1,
                        permissionArray,
                        permissionCode)
            }
        }
        //endregion
        StageUtils.defaultRender(this)
    }
    //region    Permission
    val permissionArray = arrayOf<String>(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    val permissionCode = 1
    private fun checkPermission() = !permissionArray.any {
        PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(this@Stage_1_1, it)
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == permissionCode) {
            val notOk = grantResults.any {
                PackageManager.PERMISSION_GRANTED != it
            }

            if(notOk){
                val dump = StringBuilder()
                dump.append("RequestPermissions Fail\n")
                for (i in grantResults.indices){
                    dump.append("${Pair<String,Int>(permissions[i],grantResults[i]).toString()}\n")
                }
                info { dump.toString() }
            }else{
                info { "RequestPermissions Success" }
                this.pass()
            }
        }
    }
    //endregion
}