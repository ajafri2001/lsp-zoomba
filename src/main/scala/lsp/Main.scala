package lsp

import log.Logger
import lsp.methods.InitializeResult
import scala.io.Source
import io.circe._
import io.circe.parser._
import io.circe.generic.auto._
import lsp.methods.initialize

// TODO-

sealed trait Message:
    def jsonrpc: String = "2.0"

type LSPAny =
    InitializeResult | String | Int | BigInt | BigDecimal | Boolean |
        Null // Needs lists and maps

case class RequestMessage(
    id: Int, // ideally Int | String type as formal specification dictates
    method: String,
    params: Option[Json] = None
) extends Message

case class ResponseMessage(
    id: Int,
    result: LSPAny
    // error: Null
) extends Message

// Testing to see if local vim client can send errors and panic
object Main:
    def main(args: Array[String]): Unit =

        // This is temporary, production shouldn't have EOF character ever, it should continuosly read for chunks
        val input = Source.stdin.mkString

        val contentLength = """\d+""".r.findFirstIn(input)
        val messageStart = input.indexOf("\r\n\r\n") + 4

        val rawMessage: String =
            input.slice(messageStart, messageStart + contentLength.get.toInt)

        // Pretty smart here
        val message: RequestMessage =
            parse(rawMessage)
                .flatMap(_.as[RequestMessage])
                .getOrElse(RequestMessage(id = 0, method = "", params = None))

        Respond.respond(1, initialize(message))
