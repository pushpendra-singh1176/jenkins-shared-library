def call() {
    if (params.RUN_OWASP) {
        dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'OWASP'
        dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
    } else {
        echo "OWASP skipped (parameter disabled)"
    }
}
