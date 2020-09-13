package com.tpg.puzzles.one.six.two

case class AsteriskOrCount(left: Option[Char], right: Option[Int]) {
  def this() = this(Some('*'), None)
  def this(value: Int) = this(None, Some(value))

  override def toString: String = {
    if (left.nonEmpty) { return s"${left.head}"}
    if (right.nonEmpty) { return s"${right.head}"}

    "-,-"
  }
}
