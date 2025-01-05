// TODO-
import lsp.RequestMessage

case class InitializeResult(
    capabilities: ServerCapabilities,
    serverInfo: Option[ServerInfo] = None
)

case class ServerCapabilities(
    // A bunch of stuff needs to be here
)

case class ServerInfo(name: String, version: Option[String] = None)

def initialize(message: RequestMessage): InitializeResult =
    val capabilities = ServerCapabilities()
    val result = InitializeResult(
      capabilities,
      Some(ServerInfo("lsp-zoomba", Some("0.1.0")))
    )
    result
