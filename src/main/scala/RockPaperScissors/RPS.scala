package RockPaperScissors

import RockPaperScissors.ChoiceEnum.ChoiceEnum

import scala.io.StdIn.readLine
import scala.util.Random

object RPS extends App {
  def readInput: Unit = readLine(
    """Please choose and option:
      |1. Rock
      |2. Paper
      |3. Scissors
      |""".stripMargin) match {
    case "1" => playOnce(ChoiceEnum.Rock)
    case "2" => playOnce(ChoiceEnum.Paper)
    case "3" => playOnce(ChoiceEnum.Scissors)
    case _ => {
      println("Please retry with a valid input")
      readInput
    }
  }

  def playOnce(playerChoice: ChoiceEnum) = {
    val aiChoice = ChoiceEnum.apply(Random.nextInt(3))
    chooseWinner(playerChoice, aiChoice) match {
      case Some(true) => println("You Win!!!")
      case Some(false) => println("You Lose!!!")
      case _ => println("Its a Draw!!!")
    }
    println(s"Yous chose: $playerChoice, ai chose $aiChoice")
    readInput
  }

  def chooseWinner(choices: (ChoiceEnum, ChoiceEnum)): Option[Boolean] = {
    import ChoiceEnum._
    choices match {
      case (Rock, Paper) => Some(false)
      case (Paper, Rock) => Some(true)
      case (Rock, Scissors) => Some(true)
      case (Scissors, Rock) => Some(false)
      case (Scissors, Paper) => Some(true)
      case (Paper, Scissors) => Some(false)
      case (x, y) if x == y => None
    }
  }

  readInput
}
