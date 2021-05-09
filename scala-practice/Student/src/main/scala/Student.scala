package com.chetan.scala

object Student {

  def main(args: Array[String]): Unit = {
    calculateGrade(68)
  }

  def calculateGrade(percentage: Int): Unit = {
    if (percentage > 90 && percentage <= 100) {
      println("Grade A")
    }

    if (percentage > 80 && percentage <= 90) {
      println("Grade B")
    }

    if (percentage > 70 && percentage <= 80) {
      println("Grade C")
    }

    if (percentage < 70) {
      println("Failed")
    }
  }
}
