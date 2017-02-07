#!groovy

node { // <1>
    echo 'starting build' // <2>

    stage ('build')  {
        sh returnStatus: true, script: 'man clean install'
    }

}
