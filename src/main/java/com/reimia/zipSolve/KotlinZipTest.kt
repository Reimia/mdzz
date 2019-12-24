package com.reimia.zipSolve

import java.io.File
import com.reimia.zipSolve.*


object KotlinZipTest {

    @JvmStatic
    fun  main(args: Array<String>){
        val zipPath = "D:\\source\\Iot_std_library\\stdlib\\build\\publish\\edge-stdlib-3.0.0-SNAPSHOT.zip"
        val targetDir = "D:\\"
        val file = File(zipPath)
        val a = file.extension
        val b = file.nameWithoutExtension
        File(zipPath).unZipTo(targetDir)
    }

}