package com.reimia.kotlin

fun main(){
    val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"
    fun String.getPattern(): String = """\d{2}\ $month \d{4}"""
    val s = ""
    print(s.getPattern())
}