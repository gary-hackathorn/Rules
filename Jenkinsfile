#!groovy

node { // <1>
    echo 'starting build' // <2>

    stage ('build')  {
        sh 'pwd'
        sh 'ls -la'
        git credentialsId: 'e8ab5b35-3cae-4e77-b08a-521e52128285', url: 'https://github.com/gary-hackathorn/Rules.git'
        echo 'code checked out'
        sh '/Users/gary/apache-maven-3.3.9/bin/mvn clean install'
    }

    stage ('test') {
        echo 'testing....'
    }

}
