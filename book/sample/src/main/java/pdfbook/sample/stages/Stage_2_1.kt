package pdfbook.sample.stages

import android.view.Window
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import java.io.File

/**
 * Created by Administrator on 2017/12/31.
 * 存储路径
 */

class Stage_2_1:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState == null){
            if (checkStorage()) StageUtils.pass(this)
        }
        StageUtils.defaultRender(this)
    }
    private fun checkStorage():Boolean{
        val root = StorageUtils.pdfRoot
        //只检查根目录读权限
        if(!File(root).let { it.isDirectory && it.canRead() }) return false
        //文件夹不能空
        if(StorageUtils.pdfDirs.size == 0) return false
        return true
    }
}