package day05

import java.io.{BufferedReader, File, FileReader}


/**
  * Created by qiaozhiquan on 2018/9/15.
  */

class RichFile(file: File) {

  def count(): Int = {
    val fileReader = new FileReader(file)
    val bufferReader = new BufferedReader(fileReader)

    var sum = 0
    var line = bufferReader.readLine()
    try {
      while (line != null) {
        sum += 1
        line = bufferReader.readLine()
      }
    } catch {
      case _: Exception => sum
    } finally {

    }
    sum
  }

}


object FileImplicit extends App {

  implicit  def file2RichFile(file:File) = new RichFile(file)
  val file = new File("D:\\README.txt")
  println(file.count)

}
