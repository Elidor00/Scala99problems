package logic_3

// Define functions and, or, nand, nor, xor, impl, and equ (for logical equivalence) which return true or false
// according to the result of their respective operations; e.g. and(A, B) is true if and only if both A and B are true.

object P46 {

  def and(a: Boolean, b: Boolean): Boolean = (a, b) match {
    case (true, true) => true
    case (_, _) => false
  }

  def and1(a: Boolean, b: Boolean): Boolean = (a, b) match {
    case (false, _) => false
    case (_, false) => false
    case (_, _) => true
  }

  def or(a: Boolean, b: Boolean): Boolean = (a, b) match {
    case (false, false) => false
    case (_, _) => true
  }

  def not(a: Boolean): Boolean = if (a) false else true

  def equ(a: Boolean, b: Boolean): Boolean = or(and(a, b), and(not(a), not(b)))

  def xor(a: Boolean, b: Boolean): Boolean = not(equ(a, b))

  def nor(a: Boolean, b: Boolean): Boolean = not(or(a, b))

  def nand(a: Boolean, b: Boolean): Boolean = not(and(a, b))

  def impl(a: Boolean, b: Boolean): Boolean = or(not(a), b)

  def table2(f: (Boolean, Boolean) => Boolean) {
    println("A     B     result")
    for {a <- List(true, false)
         b <- List(true, false)} {
      printf("%-5s %-5s %-5s\n", a, b, f(a, b))
    }
  }

  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }

  // only for tests
  def time1[R](block: => R): Long = {
    val t0 = System.nanoTime()
    val t1 = System.nanoTime()
    val time: Long = t1.toLong - t0.toLong
    println("Elapsed time: " + time + "ns")
    time
  }

  def main(args: Array[String]): Unit = {
    table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
  }

}
