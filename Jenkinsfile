#!groovy

node { // <1>
    echo 'starting build' // <2>

    stage ('build')  {
        sh 'pwd'
        sh 'ls -la'
        sh '/Users/gary/apache-maven-3.3.9/bin/mvn clean install'
    }

    stage ('test') {
        echo 'testing...'
    }

}
