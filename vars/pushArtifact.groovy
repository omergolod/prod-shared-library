def call(Map config = [:]) {
    def artifactName = config.get('artifactName')
    def version = config.get('version')

    if (!artifactName || !version) {
        error "Missing required parameters: artifactName and version must be provided."
    }

    echo "Preparing to upload artifact: ${artifactName} with version: ${version}"

    if (version.contains('-SNAPSHOT')) {
        echo "[LOG] Snapshot version detected. Routing upload to DEVELOPMENT repository."
    } else {
        echo "[LOG] Release version detected. Routing upload to PRODUCTION repository."
    }
}
