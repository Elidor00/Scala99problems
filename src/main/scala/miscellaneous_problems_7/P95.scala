package miscellaneous_problems_7

// English number words.
// On financial documents, like checks, numbers must sometimes be written in full words.
// Example: 175 must be written as one-seven-five.
// Write a function fullWords(num: Int) to print (non-negative) integer numbers in full words.

object P95 {

  val numberToWord: Map[Int, String] = collection.immutable.HashMap(
    0 -> "zero",
    1 -> "one",
    2 -> "two",
    3 -> "three",
    4 -> "four",
    5 -> "five",
    6 -> "six",
    7 -> "seven",
    8 -> "eight",
    9 -> "nine"
  )

  def fullWords(num: Int): String = {
    @scala.annotation.tailrec
    def fullWordsR(result: String, number: Int): String = {
      val digit = number.toString.charAt(0).toInt % 48  // % 48 because 1 is 49, 2 is 50, etc.
      if (number.toString.length > 1)
        if (numberToWord.contains(digit))
          fullWordsR(result + numberToWord(digit) + "-", number.toString.substring(1).toInt)
        else throw new NoSuchElementException("There is no key in hashMap")
      else result + numberToWord(digit)
    }

    fullWordsR("", num)
  }

  def main(args: Array[String]): Unit = {
    println(fullWords(117578512))

  }

}
