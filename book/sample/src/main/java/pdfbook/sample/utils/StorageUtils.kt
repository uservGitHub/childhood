package pdfbook.sample.stages

import android.os.Environment
import java.io.File

/**
 * Created by Administrator on 2017/12/31.
 */

class StorageUtils{
    companion object {
        val pdfRoot by lazy {
            //"${Environment.getExternalStorageDirectory()}/ptest"
            "${Environment.getExternalStorageDirectory()}/gxd.book/atest"
        }
        val pdfDirs = File(pdfRoot).list { file, s -> file.isDirectory }
        fun pdfFilenameFromDir(dir:String) =
                File(pdfRoot+"/"+dir).listFiles { file ->
                    file.isFile && file.canRead() && file.name.endsWith(".pdf", true) }.map { it.absolutePath }

    }
}