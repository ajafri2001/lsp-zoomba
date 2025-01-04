package lsp

object Main {
    def main(args: Array[String]): Unit =
        println("Hello World")
        println(encodeMessage())

    def encodeMessage(): String =
        val testJson = """
                       {
                         "hello" : 1
                       }
                       """
        testJson
}
