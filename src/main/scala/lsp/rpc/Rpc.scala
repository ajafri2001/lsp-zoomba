package lsp.rpc

import io.circe._, io.circe.parser._

def encodeMessage(msg: Array[Byte]): String =
    val input = String(msg)
    val result: Either[ParsingFailure, Json] = parse(input)
    result match
        case Right(json) => json.toString()
        case Left(error) =>
            throw new IllegalArgumentException("This is doomed")

def decodeMessage = ???
