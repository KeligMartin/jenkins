pipeline {
    agent any
    stages {
       stage('build') {
          steps {
             sh 'mvn clean compile'
          }
       }
       stage('test') {
           steps {
               sh 'mvn clean test'
           }
       }
    }
 }