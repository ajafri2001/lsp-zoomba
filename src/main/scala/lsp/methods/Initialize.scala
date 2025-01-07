package lsp.methods

// TODO-
import lsp.RequestMessage
import lsp.LSPAny

case class InitializeResult(
    capabilities: ServerCapabilities,
    serverInfo: ServerInfo
)

case class ServerCapabilities(
    // A bunch of stuff needs to be here
)

case class ServerInfo(name: String, version: String)

def initialize(message: RequestMessage): LSPAny =
    val capabilities = ServerCapabilities()
    val result = InitializeResult(
      capabilities,
      ServerInfo("lsp-zoomba", "0.1.0")
    )
    // Convert result to LSPAny (e.g., LSPObject)
    LSPAny.LSPObject(
      Map(
        "capabilities" -> LSPAny.LSPObject(
          Map(
            "textDocumentSync" -> LSPAny.LSPString("Incremental")
          )
        ),
        "serverInfo" -> LSPAny.LSPObject(
          Map(
            "name" -> LSPAny.LSPString("lsp-zoomba"),
            "version" -> LSPAny.LSPString("0.1.0")
          )
        )
      )
    )
