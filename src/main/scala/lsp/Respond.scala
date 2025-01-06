package lsp

import lsp.log.Logger
import lsp.methods.InitializeResult
import scala.io.Source

object Respond:
    def respond(
        id: Int,
        result: InitializeResult
    ): Unit =
        val message: String = ResponseMessage(id, result).toString()
        val messageLength: Int = message.getBytes("UTF-8").length
        val header: String = s"Content-Length: $messageLength\r\n\r\n"
        Logger.write(header + message)

        print(header + message)
