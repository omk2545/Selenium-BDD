pipeline{
    agent any
    parameters {
        choice(name: 'SUITE_NAME', choices: ['smoke', 'sanity'], description: 'select the suite')
    }
    stages {

        stage("Run Maven command") {
            steps {
                script {
                    sh("chmod +x testrun.sh && ./testrun.sh ${params.SUITE_NAME}")
                }
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'test-output/**'

            publishHTML (target : [allowMissing: false,
                                   alwaysLinkToLastBuild: true,
                                   keepAll: true,
                                   reportDir: 'test-output/Spark/',
                                   reportFiles: 'ExtentSpark.html',
                                   reportName: 'Extent report',
                                   reportTitles: 'The Report'])

        }
    }
}
