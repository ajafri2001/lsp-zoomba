// TODO-

import { ExtensionContext, workspace } from "npm:vscode";
import { join } from "@std/path";

import {
    LanguageClient,
    LanguageClientOptions,
    ServerOptions,
    TransportKind,
} from "vscode-languageclient/node";

let client: LanguageClient;

export function activate(context: ExtensionContext) {
    const javaExecutable = "java";

    // The server is implemented in node
    const jarPath = context.asAbsolutePath(
        join("target", "scala-3.5.2", "lsp-zoomba.jar"),
    );
    // If the extension is launched in debug mode then the debug server options are used
    // Otherwise the run options are used
    const serverOptions: ServerOptions = {
        run: {
            command: javaExecutable,
            args: ["-jar", jarPath],
            transport: TransportKind.stdio,
        },
        debug: {
            command: javaExecutable,
            args: ["-jar", jarPath],
            transport: TransportKind.stdio,
        },
    };

    // Options to control the language client
    const clientOptions: LanguageClientOptions = {
        // Register the server for plain text documents
        documentSelector: [{ scheme: "file", language: "plaintext" }],
        synchronize: {
            // Notify the server about file changes to '.clientrc files contained in the workspace
            fileEvents: workspace.createFileSystemWatcher("**/.clientrc"),
        },
    };

    // Create the language client and start the client.
    client = new LanguageClient(
        "lsp-zoomba",
        "Lsp implementation for zoomba",
        serverOptions,
        clientOptions,
    );

    // Start the client. This will also launch the server
    client.start();
}

export function deactivate(): Thenable<void> | undefined {
    if (!client) {
        return undefined;
    }
    return client.stop();
}
