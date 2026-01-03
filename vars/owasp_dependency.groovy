def call(boolean runOwasp) {
    if (runOwasp) {
        dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'OWASP'
        dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
    } else {
        echo "OWASP skipped"
    }
}

