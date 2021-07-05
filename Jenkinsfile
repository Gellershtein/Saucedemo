pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }
    parameters {
            gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'

            choice{
                       choices: 'chrome\nfirefox',
                       defaultValue: 'chrome',
                       description:  'Browsers',
                       name: 'BROWSER'
                     }


            booleanParam(defaultValue: true, name: 'HEADLESS', description: 'HEADLESS'),
        }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                 git branch: "${params.BRANCH}", url: 'https://github.com/Gellershtein/Saucedemo.git'

                // Run Maven on a Unix agent.
               // sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true clean test -DBROWSER=${params.BBROWSER} -DHEADLESS=${params.BHEADLESS}
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Reporting') {
         steps {
             script {
                     allure([
                             includeProperties: false,
                             jdk: '',
                             properties: [],
                             reportBuildPolicy: 'ALWAYS',
                             results: [[path: 'target/allure-results']]
                     ])
             }
         }
        }
    }
}
