def call() {
    dependencyCheck(
        failOnCVSS: 7,
        scanPath: '.'
    )
    dependencyCheckPublisher(pattern: '**/dependency-check-report.xml')
}
