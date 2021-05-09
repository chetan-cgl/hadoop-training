package com.chetan.scala

import scala.io.StdIn.readLine

object Calculator {

  def main(args: Array[String]): Unit = {

    println("Addition : 1 ")
    println("Subtraction : 2 ")
    println("Multiplication : 3 ")
    println("Division : 4 ")
    println("Enter your operation : ")
    val operation = readLine()
    println("Enter value 1 : ")
    val value1 = readLine()
    println("Enter value 2 : ")
    val value2 = readLine()

    calculate(operation.toInt, value1.toDouble, value2.toDouble)

  }

  def calculate(operation: Int, value1: Double, value2: Double): Unit = {

    operation match {
      case 1 => println("Addition")
        println(value1 + value2)
      case 2 => println("Subtraction")
        println(value1 - value2)
      case 3 => println("Multiplication")
        println(value1 * value2)
      case 4 => println("Division")
        println(value1 / value2)
      case whoa => println("Unexpected case: " + whoa.toString)
        3
    }
  }
}
