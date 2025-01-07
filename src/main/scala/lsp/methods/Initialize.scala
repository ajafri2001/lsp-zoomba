package lsp.methods

// TODO-
import lsp.RequestMessage

case class InitializeResult(
    capabilities: ServerCapabilities,
    serverInfo: ServerInfo
)

case class ServerCapabilities(
    // A bunch of stuff needs to be here
)

case class ServerInfo(name: String, version: String)

def initialize(message: RequestMessage): String =
    val capabilities = ServerCapabilities()
    val result = InitializeResult(
      capabilities,
      ServerInfo("lsp-zoomba", "0.1.0")
    )
    result.toString
