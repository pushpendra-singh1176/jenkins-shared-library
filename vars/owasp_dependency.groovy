def call() {
    dependencyCheck additionalArguments: '--scan . --failOnCVSS 7',
                    odcInstallation: 'dependency-check'

    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
