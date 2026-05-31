def call(Map config) {
    echo "Starting security scans..."
    echo "Scanning target: ${config.scanTarget}"
    echo "Failure threshold set to: ${config.failThreshold}"
}
