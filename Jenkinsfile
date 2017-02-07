#!groovy

node { // <1>
    echo 'starting build' // <2>

    stage ('build')  {
      sh 'mvn clean install'
    }

    stage ('test') {
        echo 'testing...'
    }

}
