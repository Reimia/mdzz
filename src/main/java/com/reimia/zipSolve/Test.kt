package com.reimia.zipSolve

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val zipPath = "D:\\source\\Iot_std_library\\stdlib\\build\\publish\\edge-stdlib-3.0.0-SNAPSHOT.zip"
        val targetDir = "D:\\"
        val zipSolve = ZipSolve()
        zipSolve.zipSolve(zipPath,targetDir)
    }
}