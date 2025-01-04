package lsp

import log.Logger
import scala.io.Source

// TODO-

sealed trait Message:
    def jsonrpc: String = "2.0"

case class RequestMessage(
    id: Int | String,
    method: String,
    params: Option[Any] = None
) extends Message

// Testing to see if local vim client can send errors and panic
object Main {
    def main(args: Array[String]): Unit =
        val input = Source.stdin.getLines().mkString("\n")
        Logger.write(input)
}
