def call(Map config = [:]) {

    def imageName  = config.imageName ?: error("imageName required")
    def imageTag   = config.imageTag ?: "latest"
    def dockerUser = config.dockerUser ?: error("dockerUser required")

    echo "Pushing image: ${dockerUser}/${imageName}:${imageTag}"

    sh """
        docker push ${dockerUser}/${imageName}:${imageTag}
        docker push ${dockerUser}/${imageName}:latest
    """
}
