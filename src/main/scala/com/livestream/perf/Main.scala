package com.livestream.perf

object Main extends App {

  val oneHundredThousandList = 0 until 100000
  val oneMillionList =         0 until 1000000 
  val tenMillionList =         0 until 10000000
  val oneHundredMillionList =  0 until 100000000
  val oneBillionList =         0 until 1000000000

  loopListTest(oneMillionList)
  loopListTest(tenMillionList)
  loopListTest(oneHundredMillionList) 
  loopListTest(oneBillionList) 
  
  def loopListTest(seq: Seq[Int]) {
    val whileTime = whileListTest(seq)
    printDifference("WhileLoop  ", seq.length, whileTime)
    val forTime = forListTest(seq)
    printDifference("ForLoop    ", seq.length, forTime, whileTime)
    val foreachTime = foreachListTest(seq)
    printDifference("ForEachLoop", seq.length, foreachTime, whileTime)
    println()
  }

  def printDifference(
    label: String, iterations: Int, newTime: Long, prevTime: Long = -1
  ) {
    val loopStr = "%s %d iterations took %d ms".format(label, iterations, newTime)
    if(prevTime > -1) {
      val percentageIncrease = (((newTime - prevTime) / prevTime.toDouble) * 100).toInt
      println(loopStr + " | Percentage Increase: %d%% Total Increase: %d ms".format(
        percentageIncrease,newTime - prevTime))
    } else {
      println(loopStr)
    }
  }

  def whileListTest(seq: Seq[Int]): Long =  {
    val startTime = System.currentTimeMillis
    var i = 0
    while(i < seq.length) {
      i += 1
    }
    val stopTime = System.currentTimeMillis
    val totalTime = stopTime - startTime
    totalTime
  }

  def forListTest(seq: Seq[Int]): Long =  {
    val startTime = System.currentTimeMillis
    var sum = 0L
    for(num <- seq) {
    }
    val stopTime = System.currentTimeMillis
    val totalTime = stopTime - startTime
    totalTime
  }

  def foreachListTest(seq: Seq[Int]): Long = {
    val startTime = System.currentTimeMillis
    var sum = 0L
    seq.foreach((x: Int) => {})
    val stopTime = System.currentTimeMillis
    val totalTime = stopTime - startTime
    totalTime
  }
}
