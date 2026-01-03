def call(String imageName, String imageTag, String dockerUser) {

    echo "Building image: ${dockerUser}/${imageName}:${imageTag}"

    sh """
        docker build \
        -t ${dockerUser}/${imageName}:${imageTag} \
        -t ${dockerUser}/${imageName}:latest \
        .
    """
}

