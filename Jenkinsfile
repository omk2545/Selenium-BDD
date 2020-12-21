pipeline {
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

            publishHTML(target: [allowMissing         : false,
                                 alwaysLinkToLastBuild: true,
                                 keepAll              : true,
                                 reportDir            : 'test-output/Spark/',
                                 reportFiles          : 'ExtentSpark.html',
                                 reportName           : 'Extent report',
                                 reportTitles         : 'The Report'])
            cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/cucumber.json', jsonReportDirectory: 'target/cucumber-reports/json-reports/', mergeFeaturesById: true, pendingStepsNumber: -1, skipEmptyJSONFiles: true, skippedStepsNumber: -1, sortingMethod: 'NATURAL', undefinedStepsNumber: -1        }
    }
}
