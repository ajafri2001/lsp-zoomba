package lsp

import log.Logger
import scala.io.Source
import io.circe._, io.circe.parser._

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
        val input = Source.stdin.getLines().mkString
        val contentLength = """\d+""".r.findFirstIn(input)
        val messageStart = input.indexOf("\r\n\r\n") + 4

        val rawMessage: String =
            input.slice(messageStart, messageStart + contentLength.get.toInt)

        Logger.write(input)

        val message = parse(rawMessage).getOrElse(
          "Problem unwrapping message from raw message"
        )
}
