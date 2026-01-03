def call(Map config = [:]) {

    def imageName  = config.imageName ?: error("imageName required")
    def imageTag   = config.imageTag ?: "latest"
    def dockerUser = config.dockerUser ?: error("dockerUser required")
    def credsId    = config.credsId ?: "docker"

    echo "Pushing image: ${dockerUser}/${imageName}:${imageTag}"

    withCredentials([
        usernamePassword(
            credentialsId: credsId,
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {
        sh """
            echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
            docker push ${dockerUser}/${imageName}:${imageTag}
            docker push ${dockerUser}/${imageName}:latest
            docker logout
        """
    }
}
