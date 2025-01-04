package lsp

import io.circe._, io.circe.parser._

object Main {
    def main(args: Array[String]): Unit =
        println("Hello World")
        println(encodeMessage())

    def encodeMessage(): Json =
        val testJson: String =
            """
            {
              "hello" : 123
            }
            """.stripMargin
        val result: Either[ParsingFailure, Json] = parse(testJson)

        result match
            case Right(json) => json
            case Left(value) =>
                throw new IllegalArgumentException("You are doomed")
}
