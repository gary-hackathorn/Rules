#!groovy

node { // <1>
    echo 'starting build' // <2>

    stage ('build')  {
        sh 'man clean install'
    }

    stage ('test') {
        echo 'testing...'
    }

}
