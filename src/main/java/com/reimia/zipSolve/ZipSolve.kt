package com.reimia.zipSolve

import java.io.File
import java.nio.charset.Charset
import java.util.zip.ZipFile
import java.util.zip.ZipEntry
import java.io.FileOutputStream


class ZipSolve {

    fun zipSolve(zipPath: String, targetDir: String) {

        val zipFile = File(zipPath)
        val pathFile = File(targetDir)
        val zip = ZipFile(zipFile, Charset.forName("gbk"))
        val entries = zip.entries()
        try {
            while (entries.hasMoreElements()) {
                val entry = entries.nextElement() as ZipEntry
                val zipEntryName = entry.name
                val inputStream = zip.getInputStream(entry)
                val outPath = (targetDir + zipEntryName).replace("/", File.separator)
                //判断路径是否存在,不存在则创建文件路径
                val file = File(outPath.substring(0, outPath.lastIndexOf(File.separator)))
                if (!file.exists()) {
                    file.mkdirs()
                }
                //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
                if (File(outPath).isDirectory) {
                    continue
                }
                //保存文件路径信息（可利用md5.zip名称的唯一性，来判断是否已经解压）
                System.err.println("当前zip解压之后的路径为：$outPath")
                val out = FileOutputStream(outPath)
                val buf1 = ByteArray(2048)
                var len: Int = 0
                while (inputStream.read(buf1) != -1) {
                    len = inputStream.read(buf1)
                    out.write(buf1, 0, len)
                }
                inputStream.close()
                out.close()
            }
            print(1)
        }catch (e:Exception){
            e.printStackTrace()
        }


    }

}