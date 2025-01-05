package lsp.log

import java.io.FileWriter
import java.io.File
import io.circe.parser._

object Logger:
    def write(msg: String): Unit =
        val writer = FileWriter(
          File("/home/ajafri/Desktop/lsp-zoomba/lsp.log")
        )
        writer.write(msg)
        writer.flush()
