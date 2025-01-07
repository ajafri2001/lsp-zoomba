package lsp

import lsp.log.Logger
import lsp.methods.InitializeResult
import scala.io.Source
import io.circe.Json

type LSPObject = Map[String, Json]
type LSPArray = Seq[Json]

type LSPAny = LSPObject | LSPArray | String | Int | BigInt | BigDecimal |
    Boolean | Null

case class ResponseMessage(
    id: Int,
    result: LSPAny
    // error: Null
) extends Message

object Respond:
    def respond(id: Int, result: String): Unit =
        val message: String = ResponseMessage(id, result).toString()
        val messageLength: Int = message.getBytes("UTF-8").length
        val header: String = s"Content-Length: $messageLength\r\n\r\n"

        Logger.write(header + message)

        print(header + message)
