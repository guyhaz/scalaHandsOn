package RockPaperScissors

import scala.io.StdIn.readLine
import scala.util.Random

object RockPapeScissorsGame extends App {
  def readInput: Unit = getPlay(readLine(
    """Please choose and option:
      |1. Rock
      |2. Paper
      |3. Scissors
      |""".stripMargin)) match {
    case Some(play) => playOnce(play)
    case None => {
      println("Retry with a valid input")
      readInput
    }
  }

  def playOnce(playerChoice: Playable) = {
    val opponentChoice = getPlay(Random.between(1, 3).toString).get
    playerChoice playAgainst opponentChoice match {
      case Some(true) => println("You Win!!!")
      case Some(false) => println("You Lose!!!")
      case _ => println("Its a Draw!!!")
    }
    println(s"Yous chose: $playerChoice, opponent chose $opponentChoice")
    readInput
  }

  def getPlay(playStr: String): Option[Playable] = playStr match {
    case "1" => Some(Rock)
    case "2" => Some(Paper)
    case "3" => Some(Scissors)
    case _ => None
  }

  trait Playable {
    def name: String

    def playAgainst(opponent: Playable): Option[Boolean]

    override def toString = name
  }

  object Rock extends Playable {
    override def playAgainst(opponent: Playable): Option[Boolean] = opponent match {
      case Paper => Some(false)
      case Scissors => Some(true)
      case _ => None
    }

    override def name = "Rock"
  }

  object Paper extends Playable {
    override def playAgainst(opponent: Playable): Option[Boolean] = opponent match {
      case Rock => Some(false)
      case Scissors => Some(true)
      case _ => None
    }

    override def name = "Paper"
  }

  object Scissors extends Playable {
    override def playAgainst(opponent: Playable): Option[Boolean] = opponent match {
      case Paper => Some(false)
      case Rock => Some(true)
      case _ => None
    }

    override def name = "Scissors"
  }

  readInput
}
