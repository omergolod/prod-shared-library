def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    echo "Starting security scans..."
    echo "Scanning target: ${config.scanTarget}"
    echo "Failure threshold set to: ${config.failThreshold}"
}
