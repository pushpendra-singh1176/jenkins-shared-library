def call(boolean runOwasp = true) {
    if (runOwasp) {
        dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'OWASP'
        dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
    } else {
        echo "OWASP skipped (parameter disabled)"
    }
}
