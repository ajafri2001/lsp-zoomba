// TODO-

case class InitializeResult(
    capabilities: ServerCapabilities,
    serverInfo: Option[ServerInfo] = None
)

case class ServerCapabilities(
    // A bunch of stuff needs to be here
)

case class ServerInfo(name: String, version: Option[String])
