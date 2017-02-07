#!groovy

node { // <1>
    echo 'Hello World' // <2>
}

stage ('build')  {
    sh returnStatus: true, script: 'man clean install'
}