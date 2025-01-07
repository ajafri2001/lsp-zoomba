package lsp

import lsp.log.Logger
import lsp.methods.InitializeResult
import scala.io.Source
import upickle.default.*

enum LSPAny derives ReadWriter:
    case LSPObject(value: Map[String, LSPAny])
    case LSPArray(value: Seq[LSPAny])
    case LSPString(value: String)
    case LSPInt(value: Int)
    case LSPBigInt(value: BigInt)
    case LSPBigDecimal(value: BigDecimal)
    case LSPBoolean(value: Boolean)
    case LSPNull

case class ResponseMessage(
    id: Int,
    result: LSPAny
) extends Message
    derives ReadWriter

object Respond:
    def respond(id: Int, result: LSPAny): Unit =
        val rawMessage = ResponseMessage(id, result)
        val message: String = write(rawMessage)
        val messageLength: Int = message.getBytes("UTF-8").length
        val header: String = s"Content-Length: $messageLength\r\n\r\n"

        Logger.write(header + message)

        print(header + message)
