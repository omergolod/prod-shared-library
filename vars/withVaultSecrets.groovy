def call(Map config = [:], Closure body) {
    def secretPath = config.get('secretPath', 'secret/data/db')
    
    echo "Fetching secrets securely from Vault path: ${secretPath}..."
    
    withEnv(["VAULT_SECRET_TOKEN=simulated_token_12345"]) {
        echo "Vault token exposed to environment. Executing code block..."
        body()
    }
    
    echo "Cleanup: Temporary Vault environment variables removed successfully."
}
